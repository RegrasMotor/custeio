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
public class OtVivaRequest {
	@Getter(AccessLevel.NONE)	
	private final Logger log = LoggerFactory.getLogger(OtVivaRequest.class);

	@XmlElement (required=true)
	private Params params;
	
	@XmlElement (required=true)
	private OT ot;
	
	@XmlElement (required=true)
	private Cliente cliente;

	@XmlElement (required=true)
	private Subcliente subcliente;

	@XmlElementWrapper (required=true, name="gruposTarifarios")
	@XmlElement (name="grupoTarifario", required=false)
	private List<GrupoTarifario> gruposTarifarios;
	
	@XmlElementWrapper (required=true, name="mediosAuxiliares")
	@XmlElement (name="medioAuxiliar", required=false)
	private List<MedioAuxiliar> mediosAuxiliares;
	
	@XmlElementWrapper (required=true, name="beneficios")
	@XmlElement (name="beneficio", required=false)
	private List<Beneficio> beneficios;
	
	@XmlElementWrapper (required=true, name="itemsDeCosto")
	@XmlElement (name="itemDeCosto", required=false)
	private List<ItemDeCosto> itemsDeCosto;
	
	@XmlElementWrapper (required=true, name="esquemasOperativos")
	@XmlElement (name="esquemaOperativo")
	private List<EsquemaOperativo> esquemasOperativos;
	
	@XmlElementWrapper (required=true, name="tiposPuestos")
	@XmlElement (name="tipoPuesto")
	private List<TipoPuesto> tiposPuestos;

	@XmlElementWrapper (required=true, name="categoriasSalariales")
	@XmlElement (name="categoriaSalarial")
	private List<CategoriaSalarial> categoriasSalariales;

	@XmlElementWrapper (required=true, name="escalas")
	@XmlElement (name="escala")
	private List<Escala> escalas;
	
	@XmlElementWrapper (required=true, name="escalasXcategorias")
	@XmlElement (name="escalaXcategoria")
	private List<EscalaXCategoria> escalasXcategorias;
	
	@XmlElement (required=true)
	private DatosFacturacion datosFacturacion;
}
