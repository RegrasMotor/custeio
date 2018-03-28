package com.prosegur.rulesEngine.services.soapService.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@XmlType(namespace = "http://model.soapService.services.rulesEngine.prosegur.com")
@XmlRootElement(namespace = "http://model.soapService.services.rulesEngine.prosegur.com")
@XmlAccessorType(XmlAccessType.NONE)
@Data
public class ResponseCosteo {
	@XmlID
	@XmlAttribute (required=true)
	private String uid;

	@XmlAttribute (required=true)
	private String idCosteo;

	@XmlElementWrapper (required=true, name="costeosOk")
	@XmlElement (name="otViva", required=false)
	private List<OtVivaResponseOk> otsVivasOk;
	
	@XmlElementWrapper (required=true, name="costeosError")
	@XmlElement (name="otViva", required=false)
	private List<OtVivaResponseError> otsVivasError;
}
