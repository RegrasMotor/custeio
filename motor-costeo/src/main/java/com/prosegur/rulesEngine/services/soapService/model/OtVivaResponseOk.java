package com.prosegur.rulesEngine.services.soapService.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.prosegur.rulesEngine.factsmodel.costeo.DetalleCosteo;

@XmlType(namespace = "http://model.soapService.services.rulesEngine.prosegur.com")
@XmlAccessorType(XmlAccessType.NONE)
@Data
@EqualsAndHashCode
public class OtVivaResponseOk {

	@XmlElement (required=true)
	private String idOt;

	@XmlElement (required=true)
	private String idClasificacion;	
	
	@XmlElement (required=true)
	private String idCliente;
	
	@XmlElement (required=true)
	private String idSubcliente;
	
	@XmlElement (required=true)
	private String idGrupoTarifario;
	
	@XmlElementWrapper (required=true, name="detallesCosteo")
	@XmlElement (name="detalleCosteo")
	private List<DetalleCosteo> detallesCosteo;
}
