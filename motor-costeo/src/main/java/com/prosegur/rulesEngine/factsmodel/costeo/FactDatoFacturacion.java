package com.prosegur.rulesEngine.factsmodel.costeo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@XmlAccessorType(XmlAccessType.NONE)
@Data
@XmlType
public class FactDatoFacturacion {
	
	private String idGrupoTarifario;
	private int idConceptoFacturacion;

	private double cantidad;
	private double precioUnitario;		
}
