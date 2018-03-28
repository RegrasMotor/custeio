package com.prosegur.rulesEngine.services.soapService.model;

import java.util.Date;
import java.util.Locale;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.prosegur.rulesEngine.services.soapService.adapter.TimeAdapter;
import com.prosegur.rulesEngine.services.soapService.model.EsquemaOperativo.CoberturaAlmuerzo;

@Data
@XmlType(namespace = "http://model.soapService.services.rulesEngine.prosegur.com")
@XmlAccessorType(XmlAccessType.NONE)
public class EscalaXCategoria {
	@Getter(AccessLevel.NONE)	
	private final Logger log = LoggerFactory.getLogger(EscalaXCategoria.class);
	
	@Getter(AccessLevel.NONE)	
	private static MessageSource messageSource;	
	@Autowired
    private void setMessageSource(MessageSource messageSource){
		EscalaXCategoria.messageSource = messageSource;
    }
	
	@XmlIDREF
	@XmlAttribute (required=true)
	private Escala escala;

	@XmlIDREF
	@XmlAttribute (required=true)
	private TipoPuesto tipoPuesto;

	@XmlIDREF
	@XmlAttribute (required=true)
	private CategoriaSalarial categoriaSalarial;
	
	@XmlElement (required=true, defaultValue="0.0")
	private float tiempoMinimoAlmuerzo;
	
	@XmlElement (required=true)
	private TipoCalculo tipoCalculo;
	
	@XmlElement
	private float horasPeriodo;
	
	@XmlElement (required=true)
	@XmlJavaTypeAdapter(TimeAdapter.class)	
	private Date horaInicioAdicNocturno;
	
	@XmlElement (required=true)
	@XmlJavaTypeAdapter(TimeAdapter.class)	
	private Date horaFinAdicNocturno;

	@XmlElement (defaultValue="0.0")
	private double porcentajeHoraExtraEscala;
	
	@XmlElement (defaultValue="0.0")
	private double porcentajeHoraExtraLibreTrabajado;

	@XmlElement (defaultValue="0.0")
	private double porcentajeHoraExtraAdicNocturno;
	
	@XmlElement (defaultValue="0.0")
	private double porcentajeHoraExtraAlmuerzo;
	
	@XmlElement (defaultValue="0.0")
	private double porcentajeHoraExtraFestivo;	
	
	@XmlElement (defaultValue="0.0")
	private double porcentajeHoraExtraEspecial;

	@XmlEnum
	@XmlType(namespace = "http://model.soapService.services.rulesEngine.prosegur.com")
	public enum TipoCalculo {
		@XmlEnumValue("M")
		MENSUAL("M"), 
		@XmlEnumValue("D")
		DIARIA("D"),
		@XmlEnumValue("S")
		SEMANAL("S");

		private final String value;
		
		TipoCalculo(String v) {
			value = v;
		}
		
		public String value() {
			return value;
		}
		
		public static TipoCalculo fromValue(String v) {
	        for (TipoCalculo c: TipoCalculo.values()) {
	            if (c.value.equals(v)) {
	                return c;
	            }
	        }
	        throw new IllegalArgumentException(messageSource.getMessage("IllegalArgumentException.message",new Object[] {CoberturaAlmuerzo.class.getSimpleName(), v}, Locale.getDefault()));
	    }
	}	
		
}
