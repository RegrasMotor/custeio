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
public class ItemDeCostoDetalle {
	@Getter(AccessLevel.NONE)	
	private final Logger log = LoggerFactory.getLogger(ItemDeCostoDetalle.class);
	
	@XmlIDREF
	@XmlAttribute (required=true, name="uidGrupoTarifario")
	private GrupoTarifario grupoTarifario;
	
	@XmlIDREF
	@XmlAttribute (required=true, name="uidItemDeCosto")
	private ItemDeCosto itemDeCosto;

	@XmlElement (required=true)
	private double valor;	
}
