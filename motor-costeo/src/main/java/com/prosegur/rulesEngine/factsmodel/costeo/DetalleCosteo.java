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
public class DetalleCosteo {
	@XmlElement (name="concepto", required=true)
	private int codigoConcepto;
	
	@XmlElement (name="auxiliar1")
	private String codigoAgrupacion1;
	
	@XmlElement (name="auxiliar2")
	private String codigoAgrupacion2;
	
	@XmlElement (required=true)
	private String descripcion;
	
	@XmlElement (required=true, defaultValue="0.0")
	private double valor1;
	
	@XmlElement (required=true, defaultValue="0.0")
	private double valor2;
	
	@XmlElement (required=true, defaultValue="0.0")
	private double valor3;
	
	@XmlElement (required=true, defaultValue="0.0")
	private double total;
}
