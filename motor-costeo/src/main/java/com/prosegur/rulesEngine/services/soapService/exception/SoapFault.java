package com.prosegur.rulesEngine.services.soapService.exception;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class SoapFault {
	private final static String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss"; 
	
	private final DateFormat df = new SimpleDateFormat(DATETIME_FORMAT);
	
    /*
    * Momento en el que se produce la excepcion
    */
    private String exceptionTime;	
    /*
    * Nombre de la clase que corresponde a la excepción raíz
    */
    private String exceptionType;
    /*
    * Mensaje de la excepción raíz
    */
    private String exceptionMessage;
    /*
    * Stack trace de la excepción
    */
    private String exceptionTrace;
        
	/**
	 * Constructor sin parámetros necesario para el unmarshalling
	 */
	public SoapFault() {
		super();
	}
	
	public SoapFault(Exception rootException) {
		super();
		this.exceptionTime = df.format(new Date (System.currentTimeMillis()));
		this.exceptionType = rootException.getClass().getName();
		this.exceptionMessage = rootException.getMessage();
		StringBuilder stackTraceBuffer = new StringBuilder();
		for (StackTraceElement element : rootException.getStackTrace()) {
			stackTraceBuffer.append(element.toString());
			stackTraceBuffer.append('\n');
		}
		this.exceptionTrace = stackTraceBuffer.toString();
	}
}