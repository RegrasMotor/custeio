package com.prosegur.rulesEngine.services.soapService.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prosegur.rulesEngine.services.soapService.adapter.DateAdapter;

@XmlAccessorType(XmlAccessType.NONE)
@Data
@XmlType(namespace = "http://model.soapService.services.rulesEngine.prosegur.com")
public class Subcliente {
	@Getter(AccessLevel.NONE)	
	private final Logger log = LoggerFactory.getLogger(Subcliente.class);
	
	@XmlID
	@XmlAttribute (required=true)
	private String uid;

	@XmlAttribute (required=true)
	private String id;

	@XmlElement (required=true)
	private String pais;

	@XmlElement (required=true)
	private String filialOperativa;
	
	@XmlElement (required=true)
	private String estado;
	
	@XmlElement (required=true)
	private String ciudad;

	@XmlElement (required=true)
	@XmlJavaTypeAdapter(DateAdapter.class)	
	private Date fechaInicio;
	
	@XmlElement (required=true)
	private int numDiasCondicionPago;
}
