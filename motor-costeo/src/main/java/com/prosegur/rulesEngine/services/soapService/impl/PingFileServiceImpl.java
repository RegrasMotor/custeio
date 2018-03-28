package com.prosegur.rulesEngine.services.soapService.impl;

import java.io.File;
import java.util.Date;

import javax.jws.WebService;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import lombok.extern.slf4j.Slf4j;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.xml.sax.SAXException;

import com.prosegur.rulesEngine.services.EngineServices;
import com.prosegur.rulesEngine.services.soapClient.WsRespostaCalculo.EstadoRetorno;
import com.prosegur.rulesEngine.services.soapClient.WsRespostaCalculo.PeticionFinalizadaRequest;
import com.prosegur.rulesEngine.services.soapClient.WsRespostaCalculo.PeticionFinalizadaResponse;
import com.prosegur.rulesEngine.services.soapClient.WsRespostaCalculo.WsRespostaCalculoSoap;
import com.prosegur.rulesEngine.services.soapService.Costeo;
import com.prosegur.rulesEngine.services.soapService.PingFileService;
import com.prosegur.rulesEngine.services.soapService.exception.WebServiceException;
import com.prosegur.rulesEngine.services.soapService.model.PingACK;
import com.prosegur.rulesEngine.services.soapService.model.PingACKerror;
import com.prosegur.rulesEngine.services.soapService.model.PingACKinfo;
import com.prosegur.rulesEngine.services.soapService.model.RequestCosteo;
import com.prosegur.rulesEngine.services.soapService.model.ResponseCosteo;

@WebService (endpointInterface = "com.prosegur.rulesEngine.services.soapService.PingFileService")
@Slf4j
public class PingFileServiceImpl implements PingFileService {
	public final static String XSD_REQUESTCOSTEO_FILE = "../../META-INF/schemas/RequestCosteo.xsd";
	public final static String XSD_RESPONSECOSTEO_FILE = "../../META-INF/schemas/ResponseCosteo.xsd";
	
	@Autowired private Costeo costeo;
	
	@Value("${services.file.ping.requestPath}") private String requestPath;
	@Value("${services.file.ping.responsePath}") private String responsePath;
	@Value("${services.file.ping.prettyXml}") private boolean prettyXML;
	
	@Override
	public PingACK ping (String filename, String endPointResponseService) throws WebServiceException {
		PingACK ack = new PingACK(new Date());
		
		final String requestFile = requestPath + "/" + filename;
		final StreamSource requestStream = new StreamSource(new File(requestFile));
		
		RequestCosteo requestCosteo = null;
		try {
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			//Schema schema = schemaFactory.newSchema(this.getClass().getResource("/schemas/RequestCosteo.xsd"));
			Schema schema = schemaFactory.newSchema(this.getClass().getClassLoader().getResource(XSD_REQUESTCOSTEO_FILE));

			JAXBContext jc = JAXBContext.newInstance(RequestCosteo.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			unmarshaller.setSchema(schema);
			requestCosteo = (RequestCosteo)unmarshaller.unmarshal(requestStream, RequestCosteo.class).getValue();
		} catch (SAXException | JAXBException e) {
			log.error("Error en la deserialización de la petición de costeo. " + e.getMessage(), e);
			ack.setError(new PingACKerror(e.getClass().getName(), "Error en la deserialización de la petición de costeo. " + e.getMessage(), e.getCause()));
		} catch (Exception e) {
			log.error("Error no manejado durante la solicitud de costeo. " + e.getMessage(), e);
			ack.setError(new PingACKerror(e.getClass().getName(), "Error en la deserialización de la petición de costeo. " + e.getMessage(), e.getCause()));		
		}
	
		if (!(new File(responsePath).exists())) {
			ack.setError(new PingACKerror("The system cannot find the response path specified (" + responsePath + ")"));
		}

		if (ack.getError()==null) {
			PingACKinfo info = new PingACKinfo();
			info.setIdCosteo(requestCosteo.getIdCosteo());
			info.setPais(requestCosteo.getPais());
			info.setSimulador(requestCosteo.getSimulador());
			info.setFechaEjecucion(requestCosteo.getFechaEjecucion());
			info.setNumOtsVivas(requestCosteo.getOtsVivas().size());
			info.setRequestPath(requestPath);
			info.setRequestFileName(filename);
			info.setResponsePath(responsePath);
			info.setResponseFileName(requestCosteo.getIdCosteo() + ".response." + System.currentTimeMillis() + ".xml");
			ack.setInfo(info);
			
			HiloCosteo hiloCosteo = new HiloCosteo(requestCosteo, info.getResponseFileName(), endPointResponseService);
			hiloCosteo.start();
		}

		return ack;
	}

	private class HiloCosteo extends Thread{
		private RequestCosteo requestCosteo;
		private String responseFilename;
		private String endPointResponseService;
		private WsRespostaCalculoSoap wsRespostaCalculoSoapClient;
		
		public HiloCosteo (RequestCosteo request, String responseFilename, String endPointResponseService) {
			this.requestCosteo = request;
			this.responseFilename = responseFilename;
			this.endPointResponseService = endPointResponseService;
			
			JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
	        jaxWsProxyFactoryBean.setServiceClass(WsRespostaCalculoSoap.class);
	        jaxWsProxyFactoryBean.setAddress(endPointResponseService);
	        this.wsRespostaCalculoSoapClient = (WsRespostaCalculoSoap) jaxWsProxyFactoryBean.create();
		}
		
		public void run	() {
			PeticionFinalizadaRequest request = new PeticionFinalizadaRequest();
			
			try {
				ResponseCosteo responseCosteo = costeo.calcularCosteo(requestCosteo);
				
				SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
				//Schema schema = schemaFactory.newSchema(this.getClass().getResource(XSD_RESPONSECOSTEO_FILE));
				Schema schema = schemaFactory.newSchema(this.getClass().getClassLoader().getResource(XSD_RESPONSECOSTEO_FILE));
				
				JAXBContext jcResponse = JAXBContext.newInstance(ResponseCosteo.class);
				Marshaller marshaller = jcResponse.createMarshaller();
				marshaller.setSchema(schema);
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, prettyXML);
				marshaller.marshal(responseCosteo, new File(responsePath+"/"+responseFilename));		
				
				request.setIdCosteo(requestCosteo.getIdCosteo());
				request.setDireccionFichero(responseFilename);
			} catch (WebServiceException e) {
				log.error("Error de cálculo en el costeo '"+requestCosteo.getIdCosteo()+"'. " + e.getMessage(), e);

				EstadoRetorno estadoRetorno = new EstadoRetorno();
				estadoRetorno.setCodigo(e.getClass().getName());
				estadoRetorno.setDescripcion("Error de cálculo en el costeo '"+requestCosteo.getIdCosteo()+"'.\n" + ((e.getMessage()==null)?"":("Message: "+e.getMessage()+"\n")) + ((e.getCause()==null)?"":("Cause: "+e.getCause())));
				
				request.setIdCosteo(requestCosteo.getIdCosteo());
				request.setRetorno(estadoRetorno);
			} catch (SAXException | JAXBException e) {
				log.error("Error en la serialización de los resultados del costeo '"+requestCosteo.getIdCosteo()+"'. " + e.getMessage(), e);
				
				EstadoRetorno estadoRetorno = new EstadoRetorno();
				estadoRetorno.setCodigo(e.getClass().getName());
				estadoRetorno.setDescripcion("Error en la serialización de los resultados del costeo '"+requestCosteo.getIdCosteo()+"'.\n" + ((e.getMessage()==null)?"":("Message: "+e.getMessage()+"\n")) + ((e.getCause()==null)?"":("Cause: "+e.getCause())));
				
				request.setIdCosteo(requestCosteo.getIdCosteo());
				request.setRetorno(estadoRetorno);
			} catch (Exception e) {
				log.error("Error inesperado en el cálculo del costeo '"+requestCosteo.getIdCosteo()+"'. " + e.getMessage(), e);
				
				EstadoRetorno estadoRetorno = new EstadoRetorno();
				estadoRetorno.setCodigo(e.getClass().getName());
				estadoRetorno.setDescripcion("Error inesperado en el cálculo del costeo '"+requestCosteo.getIdCosteo()+"'.\n" + ((e.getMessage()==null)?"":("Message: "+e.getMessage()+"\n")) + ((e.getCause()==null)?"":("Cause: "+e.getCause())));
				
				request.setIdCosteo(requestCosteo.getIdCosteo());
				request.setRetorno(estadoRetorno);
			}

			try {
				log.info("Invocando servicio de respuesta " + endPointResponseService);
				log.debug("<ComunicaPeticionFinalizada>\n" +
						"\t<request>\n" + 
						"\t\t<IdCosteo>" + request.getIdCosteo() + "</IdCosteo>\n" + 
						"\t\t<DireccionFichero>" + request.getDireccionFichero() + "</DireccionFichero>\n" +
						"\t\t<Retorno>\n" +
		          		"\t\t\t<Codigo>" + ((request.getRetorno()==null)?"":request.getRetorno().getCodigo()) + "</Codigo>\n" +
		          		"\t\t\t<Descripcion>" + ((request.getRetorno()==null)?"":request.getRetorno().getDescripcion()) + "</Descripcion>\n" +
		          		"\t\t</Retorno>\n" +
		          		"\t</request>\n" +
		          		"</ComunicaPeticionFinalizada>\n");
				PeticionFinalizadaResponse response = this.wsRespostaCalculoSoapClient.comunicaPeticionFinalizada(request);
				log.debug("<ComunicaPeticionFinalizadaResponse>\n" +
						"\t<ComunicaPeticionFinalizadaResult>\n" + 
		          		"\t\t<Codigo>" + response.getCodigo() + "</Codigo>\n" +
		          		"\t\t<Descripcion>" + response.getDescripcion() + "</Descripcion>\n" +
		          		"\t</ComunicaPeticionFinalizadaResult>\n" +
		          		"</ComunicaPeticionFinalizadaResponse>\n");
			} catch (Exception ex) {
				log.error("Error inesperado en la comunicación de petición finalizada para el cálculo del costeo '"+requestCosteo.getIdCosteo()+"'. " + ex.getMessage(), ex);
			}
		}
	}
}

