package com.prosegur.rulesEngine.services.soapService;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import org.apache.cxf.annotations.SchemaValidation;
import org.apache.cxf.annotations.WSDLDocumentation;

import com.prosegur.rulesEngine.services.soapService.exception.WebServiceException;
import com.prosegur.rulesEngine.services.soapService.model.PingACK;

@WebService (targetNamespace="http://soapService.services.rulesEngine.prosegur.com/")
@SchemaValidation
@WSDLDocumentation("")
public interface PingFileService {
	
	@WSDLDocumentation("")
	public @WebResult(name="ack", targetNamespace="http://soapService.services.rulesEngine.prosegur.com/") PingACK ping (
			@XmlElement(required=true) @WebParam(name="filename") String filename,
			@XmlElement(required=true) @WebParam(name="endpointResponseService") String endpointResponseService
    ) throws WebServiceException;
}
