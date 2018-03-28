package com.prosegur.rulesEngine.services.soapService.model;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlID;
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
import com.prosegur.rulesEngine.services.soapService.model.Hora.TipoHora;

@Data
@XmlType(namespace = "http://model.soapService.services.rulesEngine.prosegur.com")
@XmlAccessorType(XmlAccessType.NONE)
public class EsquemaOperativo {
	@Getter(AccessLevel.NONE)	
	private final Logger log = LoggerFactory.getLogger(EsquemaOperativo.class);

	@Getter(AccessLevel.NONE)	
	private static MessageSource messageSource;	
	@Autowired
    private void setMessageSource(MessageSource messageSource){
        EsquemaOperativo.messageSource = messageSource;
    }
	
	@XmlID
	@XmlAttribute (required=true)
	private String uid;
	
	@XmlAttribute (required=true)
	private int id;
	
	@XmlElement
	private int numeroPuestos;
	
	@XmlIDREF
	@XmlElement (required=true)
	private TipoPuesto tipoPuesto;
	
	@XmlIDREF
	@XmlElement (required=true)
	private CategoriaSalarial categoriaSalarial;	

	@XmlIDREF
	@XmlElement (required=true)
	private Escala escala;
	
//	@XmlElement (defaultValue="false")
//	private boolean mediaJornada;

//	@XmlElement
//	@XmlJavaTypeAdapter(FrecuenciaMediaJornadaAdapter.class)
//	private FrecuenciaMediaJornada frecuenciaMediaJornada;
	
//	@XmlElement (defaultValue="false")
//	private boolean trabajaLunes;
//	@XmlElement (defaultValue="false")
//	private boolean trabajaMartes;
//	@XmlElement (defaultValue="false")
//	private boolean trabajaMiercoles;
//	@XmlElement (defaultValue="false")
//	private boolean trabajaJueves;
//	@XmlElement (defaultValue="false")
//	private boolean trabajaViernes;
//	@XmlElement (defaultValue="false")
//	private boolean trabajaSabado;
//	@XmlElement (defaultValue="false")
//	private boolean trabajaDomingo;
	
//	@XmlElement (defaultValue="0.0")
//	private float horasJornadaXpuesto;

	@XmlElement 
	private double numeroTurnosMes;	
	
	@XmlElement (defaultValue="0.0")
	private float horasJornadaXpersona;
	
	@XmlElement (required=true)
	@XmlJavaTypeAdapter(TimeAdapter.class)	
	private Date horaFinJornada;
	
	@XmlElement (required=true)
	private CoberturaAlmuerzo coberturaAlmuerzo;
	
	@XmlElement (defaultValue="0.0")
	private float horasAlmuerzo;
	
	@XmlElement (required=true)
	private TipoJornada tipoJornada;
	
	@XmlElement
	private int diasTrabajadosSemana;
	
	@XmlElement (required=true)
	private Float numeroPersonas;
	
	@XmlElement (required=true)
	private Float numeroPersonasReal;
	
	@XmlElement (defaultValue="0.0")
	private float horasInItinere;
	
	@XmlElement (defaultValue="0.0")
	private float horasSobreAviso;

	@XmlElement (required=false)
	private String tipoHorasInItinere;
	
	@XmlElement (required=false)
	private String tipoHorasSobreAviso;
	
	@XmlElementWrapper (required=true, name="horas")
	@XmlElement(name = "hora", required=true)
	private List<Hora> horas;

	@XmlElementWrapper (required=true, name="mediosAuxiliares")
	@XmlElement(name = "medioAuxiliar", required=false)
	private List<MedioAuxiliarDetalle> mediosAuxiliares;
	
	@XmlElementWrapper (required=true, name="beneficios")
	@XmlElement(name = "beneficio", required=false)
	private List<BeneficioDetalle> beneficios;
	
	@XmlEnum
	@XmlType(namespace = "http://model.soapService.services.rulesEngine.prosegur.com")
	public enum CoberturaAlmuerzo {
		@XmlEnumValue("T")
		TRABAJA("T"), 
		@XmlEnumValue("C")
		CON_COBERTURA("C"),
		@XmlEnumValue("N")
		NO_TRABAJA("N");

		private final String value;
		
		CoberturaAlmuerzo(String v) {
			value = v;
		}
		
		public String value() {
			return value;
		}
		
		public static CoberturaAlmuerzo fromValue(String v) {
	        for (CoberturaAlmuerzo c: CoberturaAlmuerzo.values()) {
	            if (c.value.equals(v)) {
	                return c;
	            }
	        }
	        throw new IllegalArgumentException(messageSource.getMessage("IllegalArgumentException.message",new Object[] {CoberturaAlmuerzo.class.getSimpleName(), v}, Locale.getDefault()));
	    }
	}	
	
	@XmlEnum
	@XmlType(namespace = "http://model.soapService.services.rulesEngine.prosegur.com")
	public enum TipoJornada {
		@XmlEnumValue("T")
		TODOS_LOS_DIAS("T"), 
		@XmlEnumValue("H")
		SOLO_LABORABLES("H"),
		@XmlEnumValue("F")
		SOLO_FESTIVOS("F");

		private final String value;
		
		TipoJornada(String v) {
			value = v;
		}
		
		public String value() {
			return value;
		}
		
		public static TipoJornada fromValue(String v) {
	        for (TipoJornada c: TipoJornada.values()) {
	            if (c.value.equals(v)) {
	                return c;
	            }
	        }
	        throw new IllegalArgumentException(messageSource.getMessage("IllegalArgumentException.message",new Object[] {TipoJornada.class.getSimpleName(), v}, Locale.getDefault()));
	    }
	}	
	
//	@XmlEnum
//	public enum FrecuenciaMediaJornada {
//		@XmlEnumValue("M")
//		MENSUAL("M"), 
//		@XmlEnumValue("Q")
//		QUINCENAL("Q"),
//		@XmlEnumValue("S")
//		SEMANAL("S");
//
//		private final String value;
//		
//		FrecuenciaMediaJornada(String v) {
//			value = v;
//		}
//		
//		public String value() {
//			return value;
//		}
//		
//		public static FrecuenciaMediaJornada fromValue(String v) {
//	        for (FrecuenciaMediaJornada c: FrecuenciaMediaJornada.values()) {
//	            if (c.value.equals(v)) {
//	                return c;
//	            }
//	        }
//	        throw new IllegalArgumentException(messageSource.getMessage("IllegalArgumentException.message",new Object[] {FrecuenciaMediaJornada.class.getSimpleName(), v}, Locale.getDefault()));
//	    }
//	}
	
	public Hora getHora (TipoHora tipoHora) {
		if (horas !=null) {
			for (Hora hora : horas) {
				if (hora.getId() == tipoHora) {
					return hora;
				}
			}
		}
		
		return null;
	}
}
