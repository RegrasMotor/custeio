package com.prosegur.rulesEngine.services.soapService.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@XmlAccessorType(XmlAccessType.NONE)
@Data
@XmlType(namespace = "http://model.soapService.services.rulesEngine.prosegur.com")
public class Params {
	@XmlElement (defaultValue="30.41666667") 
	private float numeroDiasMes = 365/12f;

	@XmlElement (defaultValue="1.16666667")
	private float numeroFestivosMes = 14/12;
	
	@XmlElement (defaultValue="4.3452") 
	private float coeficienteStdDiasXsemana = 4.3452f;
	
	@XmlElement (defaultValue="true") 
	private boolean aceptaPuestosSinCobertura = true;
	
	@XmlElement
	private Double margenInformado;
	
//	@XmlElement (defaultValue="14")
//	private int numeroFestivosAno = 14;	
}
