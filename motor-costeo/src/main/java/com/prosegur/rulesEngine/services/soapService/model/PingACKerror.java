package com.prosegur.rulesEngine.services.soapService.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@XmlType(namespace = "http://model.soapService.services.rulesEngine.prosegur.com")
@XmlAccessorType(XmlAccessType.NONE)
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class PingACKerror {
	
	public PingACKerror (String message) {
		this.message = message;
	}

	public PingACKerror (String type, String message, Throwable cause) {
		this (type, message, (cause==null)?null:cause.toString());
	}
	
	@XmlElement (required=true)
	private String type;
	
	@XmlElement (required=true)
	private String message;

	@XmlElement
	private String cause;
}
