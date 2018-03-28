package com.prosegur.rulesEngine.services.soapService.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@XmlAccessorType(XmlAccessType.NONE)
@Data
@XmlType(namespace = "http://model.soapService.services.rulesEngine.prosegur.com")
public class GrupoTarifario {
	@Getter(AccessLevel.NONE)	
	private final Logger log = LoggerFactory.getLogger(GrupoTarifario.class);
	
	@XmlID
	@XmlAttribute (required=true)
	private String uid;

	@XmlAttribute
	private String id;

	@XmlElement (required=true)
	private String descripcion;
}
