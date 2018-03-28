package com.prosegur.rulesEngine.services.soapService;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import org.apache.cxf.annotations.SchemaValidation;
import org.apache.cxf.annotations.WSDLDocumentation;

import com.prosegur.rulesEngine.services.soapService.exception.WebServiceException;
import com.prosegur.rulesEngine.services.soapService.model.RequestCosteo;
import com.prosegur.rulesEngine.services.soapService.model.ResponseCosteo;

@WebService (targetNamespace="http://soapService.services.rulesEngine.prosegur.com/")
@SchemaValidation
@WSDLDocumentation("")
public interface Costeo {
	
	@WSDLDocumentation("")
	public @WebResult(name="responseCosteo", targetNamespace="http://soapService.services.rulesEngine.prosegur.com/") ResponseCosteo calcularCosteo (
			@XmlElement(required=true) @WebParam(name="requestCosteo") RequestCosteo requestCosteo 
    ) throws WebServiceException ;
}
