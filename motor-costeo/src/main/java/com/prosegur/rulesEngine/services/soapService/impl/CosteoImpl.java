package com.prosegur.rulesEngine.services.soapService.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import com.prosegur.rulesEngine.factsmodel.costeo.DetalleCosteo;
import com.prosegur.rulesEngine.factsmodel.costeo.DetalleCosteoError;
import com.prosegur.rulesEngine.factsmodel.costeo.FactRequest;
import com.prosegur.rulesEngine.services.EngineServices;
import com.prosegur.rulesEngine.services.exception.ServiceException;
import com.prosegur.rulesEngine.services.soapService.Costeo;
import com.prosegur.rulesEngine.services.soapService.exception.SoapFault;
import com.prosegur.rulesEngine.services.soapService.exception.WebServiceException;
import com.prosegur.rulesEngine.services.soapService.model.OtVivaRequest;
import com.prosegur.rulesEngine.services.soapService.model.OtVivaResponseError;
import com.prosegur.rulesEngine.services.soapService.model.OtVivaResponseOk;
import com.prosegur.rulesEngine.services.soapService.model.RequestCosteo;
import com.prosegur.rulesEngine.services.soapService.model.ResponseCosteo;
import com.prosegur.rulesEngine.services.soapService.model.mapper.MapperFacts;

@WebService (endpointInterface = "com.prosegur.rulesEngine.services.soapService.Costeo")
@Slf4j
public class CosteoImpl implements Costeo {
	@Autowired
	private EngineServices engineServices;
	
	@Override
	public ResponseCosteo calcularCosteo(RequestCosteo requestCosteo) throws WebServiceException {
		log.info("Inicio cálculo de costeo "+ requestCosteo.getIdCosteo());
		log.info("Costeo " + requestCosteo.getIdCosteo() + ". País: "+ requestCosteo.getPais());
		log.info("Costeo " + requestCosteo.getIdCosteo() + ". Simulador: "+ requestCosteo.getSimulador());
		
		ResponseCosteo response = null;
		List<OtVivaResponseOk> listaOtsVivasResponseOk = new ArrayList<OtVivaResponseOk>();
		List<OtVivaResponseError> listaOtsVivasResponseError = new ArrayList<OtVivaResponseError>();			
		try {
			for (OtVivaRequest otViva : requestCosteo.getOtsVivas()) {
		        try {
		        	log.info("Costeo " + requestCosteo.getIdCosteo() + ". Parse hechos de petición OTViva " + otViva.getOt().getUid());
		        	FactRequest factRequestCosteo = MapperFacts.parse(requestCosteo, otViva);
		          
		        	log.info("Costeo " + requestCosteo.getIdCosteo() + ". Ejecución cálculo OTViva " + otViva.getOt().getUid());
		        	List<DetalleCosteo> detallesCosteo = this.engineServices.executeCosteo(factRequestCosteo, requestCosteo.getPais(), requestCosteo.getSimulador());
		          
		        	log.info("Costeo " + requestCosteo.getIdCosteo() + ". Format respuesta OTViva " + otViva.getOt().getUid());
		        	OtVivaResponseOk otVivaResponse = MapperFacts.formatOtVivaResponse(otViva, detallesCosteo);
		        	listaOtsVivasResponseOk.add(otVivaResponse);
		        } catch (ServiceException e) {
		        	log.error(e.getMessage(), e);
		          
		        	DetalleCosteoError detalleError = new DetalleCosteoError("There was an error during executing 'costeo'", e.getMessage(), e.getClass().getName(), e.getStackTrace());
		        	OtVivaResponseError otVivaResponse = MapperFacts.formatOtVivaResponse(otViva, detalleError);
		        	listaOtsVivasResponseError.add(otVivaResponse);
		        } catch (Exception e) {
		        	log.error(e.getMessage(), e);
		          
		        	DetalleCosteoError detalleError = new DetalleCosteoError("There was an unhandled exception at runtime.", e.getMessage(), e.getClass().getName(), e.getStackTrace());
		        	OtVivaResponseError otVivaResponse = MapperFacts.formatOtVivaResponse(otViva, detalleError);
		        	listaOtsVivasResponseError.add(otVivaResponse);
		        }
			}
			log.info("Format respuesta costeo "+ requestCosteo.getIdCosteo());
			response = MapperFacts.formatResponse(requestCosteo, listaOtsVivasResponseOk, listaOtsVivasResponseError);
			return response;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		      throw new WebServiceException("There was an unhandled exception at runtime.", new SoapFault(e));
		}
	}

}

