package com.prosegur.rulesEngine.services.soapService.model;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.prosegur.rulesEngine.services.soapService.adapter.DateAdapter;

@XmlType(namespace = "http://model.soapService.services.rulesEngine.prosegur.com")
@XmlAccessorType(XmlAccessType.NONE)
@Data
@EqualsAndHashCode
@XmlRootElement (namespace = "http://model.soapService.services.rulesEngine.prosegur.com")
public class RequestCosteo {
	@XmlID
	@XmlAttribute (required=true)
	private String uid;

	@XmlAttribute (required=true)
	private String idCosteo;
	
	@XmlAttribute
	@XmlJavaTypeAdapter(DateAdapter.class)	
	private Date fechaEjecucion = new Date();
	
	@XmlAttribute (required=true)
	private String pais;
	
	@XmlAttribute
	private String simulador;

	@XmlElement (name="otViva", required=true)
	private List<OtVivaRequest> otsVivas;
	
	/*	
	@XmlElement (required=true)
	private Params params;
	
	@XmlElement (required=true)
	private OT ot;
	
	@XmlElement (required=true)
	private Cliente cliente;

	@XmlElement (required=true)
	private Subcliente subcliente;

	@XmlElementWrapper (required=true)
	@XmlElement (name="grupoTarifario", required=false)
	private List<GrupoTarifario> gruposTarifarios;
	
	@XmlElementWrapper (required=true)
	@XmlElement (name="medioAuxiliar", required=false)
	private List<MedioAuxiliar> mediosAuxiliares;
	
	@XmlElementWrapper (required=true)
	@XmlElement (name="beneficio", required=false)
	private List<Beneficio> beneficios;
	
	@XmlElementWrapper (required=true)
	@XmlElement (name="itemDeCosto", required=false)
	private List<ItemDeCosto> itemsDeCosto;
	
	@XmlElementWrapper (required=true)
	@XmlElement (name="esquemaOperativo", required=true)
	private List<EsquemaOperativo> esquemasOperativos;
	
	@XmlElementWrapper (required=true)	
	@XmlElement (name="tipoPuesto", required=true)
	private List<TipoPuesto> tiposPuestos;

	@XmlElementWrapper (required=true)	
	@XmlElement (name="categoriaSalarial", required=true)
	private List<CategoriaSalarial> categoriasSalariales;

	@XmlElementWrapper (required=true)
	@XmlElement (name="escala", required=true)
	private List<Escala> escalas;
	
	@XmlElementWrapper (required=true)
	@XmlElement (name="escalaXcategoria", required=true)
	private List<EscalaXCategoria> escalasXcategorias;
	
	@XmlElement (required=true)
	private DatosFacturacion datosFacturacion;
	*/
}
