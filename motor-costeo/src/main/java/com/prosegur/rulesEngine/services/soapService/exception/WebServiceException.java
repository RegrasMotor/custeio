package com.prosegur.rulesEngine.services.soapService.exception;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "com.prosegur.rulesEngine.services.soapService.exception.SoapFault", name="soapFault")
public class WebServiceException extends Exception {
	private static final long serialVersionUID = -5870153789360850120L;
	
	private SoapFault soapFault;

	public WebServiceException(String message) {
		super(message);
	}

	/**
	 * Constructor necesario para el unmarshalling
	 * @param message
	 * @param fault
	 */
	public WebServiceException(String message, SoapFault fault) {
		super(message);
		this.soapFault = fault;
	}

	public SoapFault getFaultInfo() {
		return this.soapFault;
	}

}