package com.prosegur.rulesEngine.factsmodel.costeo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(namespace = "http://model.soapService.services.rulesEngine.prosegur.com")
public class DetalleCosteoError {

	public DetalleCosteoError(String message, String messageFault, String exceptionType, StackTraceElement[] trace) {
	    StringBuilder stackTraceBuffer = new StringBuilder();
	    for (StackTraceElement element : trace) {
	      stackTraceBuffer.append(element.toString());
	      stackTraceBuffer.append('\n');
	    }
	    String strTrace = stackTraceBuffer.toString();
	    
	    this.message = message;
	    this.messageFault = messageFault;
	    this.exceptionType = exceptionType;
	    this.trace = strTrace;
	}
	  
	@XmlElement (required=true)
	private String message;
    
	@XmlElement (required=true)
    private String messageFault;
    
	@XmlElement
    private String exceptionType;

	@XmlElement
    private String trace;
}
