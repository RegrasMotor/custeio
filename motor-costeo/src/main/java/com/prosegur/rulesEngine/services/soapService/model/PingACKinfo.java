package com.prosegur.rulesEngine.services.soapService.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import com.prosegur.rulesEngine.services.soapService.adapter.DateAdapter;

@XmlType(namespace = "http://model.soapService.services.rulesEngine.prosegur.com")
@XmlAccessorType(XmlAccessType.NONE)
@Data
@EqualsAndHashCode
@NoArgsConstructor

public class PingACKinfo {
	@XmlElement (required=true)
	private String idCosteo;
	
	@XmlElement (required=true)
	private String pais;

	@XmlElement
	private String simulador;

	@XmlElement (required=true)
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date fechaEjecucion;

	@XmlElement (required=true)
	private long numOtsVivas;
	
	@XmlElement (required=true)
	private String requestPath;

	@XmlElement (required=true)
	private String requestFileName;
	
	@XmlElement (required=true)
	private String responsePath;

	@XmlElement (required=true)
	private String responseFileName;	
}
