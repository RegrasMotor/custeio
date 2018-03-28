package com.prosegur.rulesEngine.services.soapService.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@XmlType(namespace = "http://model.soapService.services.rulesEngine.prosegur.com")
@XmlAccessorType(XmlAccessType.NONE)
@Data
@EqualsAndHashCode
public class DatosFacturacion {
	@Getter(AccessLevel.NONE)	
	private final Logger log = LoggerFactory.getLogger(DatosFacturacion.class);

	@XmlElementWrapper (required=true, name="conceptosFacturacion")
	@XmlElement (name="conceptoFacturacion", required=false)
	private List<ConceptoFacturacion> conceptosFacturacion;
	
	@XmlElementWrapper (required=true, name="datos")
	@XmlElement (name="datoFacturacion", required=false)
	private List<DatoFacturacion> datos;
}
