package com.prosegur.rulesEngine.services.soapService.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import com.prosegur.rulesEngine.services.soapService.adapter.DateTimeAdapter;

@XmlType(namespace = "http://model.soapService.services.rulesEngine.prosegur.com")
@XmlAccessorType(XmlAccessType.NONE)
@Data
@EqualsAndHashCode
@RequiredArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class PingACK {
	@XmlAttribute (required=true)
	@XmlJavaTypeAdapter(DateTimeAdapter.class)
	@NonNull
	private Date time;
	
	@XmlElement
	private PingACKerror error;
	
	@XmlElement
	private PingACKinfo info;	
}
