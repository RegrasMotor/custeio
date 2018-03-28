package com.prosegur.rulesEngine.services.soapService.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlType;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@XmlAccessorType(XmlAccessType.NONE)
@Data
@XmlType(namespace = "http://model.soapService.services.rulesEngine.prosegur.com")
public class BeneficioDetalle {
	@Getter(AccessLevel.NONE)	
	private final Logger log = LoggerFactory.getLogger(BeneficioDetalle.class);
	
	@XmlIDREF
	@XmlAttribute (required=true, name="uid")
	private Beneficio beneficio;

	@XmlElement (required=true)
	private double cantidad;
	
	@XmlElement (required=true)
	private double valorUnitario;

	@XmlElement (required=true)
	private double valorTotal;	
}
