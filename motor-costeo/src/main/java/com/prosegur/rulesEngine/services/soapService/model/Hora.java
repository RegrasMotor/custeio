package com.prosegur.rulesEngine.services.soapService.model;

import java.util.Locale;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

@XmlAccessorType(XmlAccessType.NONE)
@Data
@XmlType(namespace = "http://model.soapService.services.rulesEngine.prosegur.com")
@NoArgsConstructor
@AllArgsConstructor
public class Hora {
	@Getter(AccessLevel.NONE)	
	private final Logger log = LoggerFactory.getLogger(Hora.class);
	
	@Getter(AccessLevel.NONE)	
	private static MessageSource messageSource;	
	@Autowired
    private void setMessageSource(MessageSource messageSource){
		Hora.messageSource = messageSource;
    }
	
	@XmlAttribute (required=true, name="id")
	private TipoHora id;

	@XmlAttribute (required=true)
	private double valor;
	
	@XmlEnum
	@XmlType(namespace = "http://model.soapService.services.rulesEngine.prosegur.com")
	public enum TipoHora {
		@XmlEnumValue("ESALM")	HORAINTRAJORNADA("ESALM"),
		@XmlEnumValue("NOR")	HORANORMAL("NOR"), 
		@XmlEnumValue("ENOC")	HORANOCTURNO("ENOC"),
		@XmlEnumValue("EXEFE")	HORAEXTRAEFETIVA("EXEFE"),
		@XmlEnumValue("HEESP")	HORAEXTRAESPECIAL("HEESP"),
		@XmlEnumValue("E100FE")	HORAEXTRAFESTIVO("E100FE"),
		@XmlEnumValue("E100FR")	HORAEXTRALIBRETRABAJADO("E100FR");

		private final String value;
		
		TipoHora(String v) {
			value = v;
		}
		
		public String value() {
			return value;
		}
		
		public static TipoHora fromValue(String v) {
	        for (TipoHora c: TipoHora.values()) {
	            if (c.value.equals(v)) {
	                return c;
	            }
	        }
	        throw new IllegalArgumentException(messageSource.getMessage("IllegalArgumentException.message",new Object[] {TipoHora.class.getSimpleName(), v}, Locale.getDefault()));
	    }
	}	
}
