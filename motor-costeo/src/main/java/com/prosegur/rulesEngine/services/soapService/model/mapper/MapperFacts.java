package com.prosegur.rulesEngine.services.soapService.model.mapper;

import java.util.ArrayList;
import java.util.List;

import com.prosegur.rulesEngine.factsmodel.costeo.DetalleCosteo;
import com.prosegur.rulesEngine.factsmodel.costeo.DetalleCosteoError;
import com.prosegur.rulesEngine.factsmodel.costeo.FactBeneficio;
import com.prosegur.rulesEngine.factsmodel.costeo.FactBeneficioDetalle;
import com.prosegur.rulesEngine.factsmodel.costeo.FactCategoriaSalarial;
import com.prosegur.rulesEngine.factsmodel.costeo.FactCliente;
import com.prosegur.rulesEngine.factsmodel.costeo.FactConceptoFacturacion;
import com.prosegur.rulesEngine.factsmodel.costeo.FactDatoFacturacion;
import com.prosegur.rulesEngine.factsmodel.costeo.FactEscala;
import com.prosegur.rulesEngine.factsmodel.costeo.FactEscalaXCategoria;
import com.prosegur.rulesEngine.factsmodel.costeo.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.costeo.FactGrupoTarifario;
import com.prosegur.rulesEngine.factsmodel.costeo.FactItemDeCosto;
import com.prosegur.rulesEngine.factsmodel.costeo.FactItemDeCostoDetalle;
import com.prosegur.rulesEngine.factsmodel.costeo.FactMedioAuxiliar;
import com.prosegur.rulesEngine.factsmodel.costeo.FactMedioAuxiliarDetalle;
import com.prosegur.rulesEngine.factsmodel.costeo.FactOT;
import com.prosegur.rulesEngine.factsmodel.costeo.FactParams;
import com.prosegur.rulesEngine.factsmodel.costeo.FactRequest;
import com.prosegur.rulesEngine.factsmodel.costeo.FactSubcliente;
import com.prosegur.rulesEngine.factsmodel.costeo.FactTipoPuesto;
import com.prosegur.rulesEngine.services.soapService.model.Beneficio;
import com.prosegur.rulesEngine.services.soapService.model.BeneficioDetalle;
import com.prosegur.rulesEngine.services.soapService.model.CategoriaSalarial;
import com.prosegur.rulesEngine.services.soapService.model.Cliente;
import com.prosegur.rulesEngine.services.soapService.model.ConceptoFacturacion;
import com.prosegur.rulesEngine.services.soapService.model.DatoFacturacion;
import com.prosegur.rulesEngine.services.soapService.model.Escala;
import com.prosegur.rulesEngine.services.soapService.model.EscalaXCategoria;
import com.prosegur.rulesEngine.services.soapService.model.EsquemaOperativo;
import com.prosegur.rulesEngine.services.soapService.model.GrupoTarifario;
import com.prosegur.rulesEngine.services.soapService.model.Hora.TipoHora;
import com.prosegur.rulesEngine.services.soapService.model.ItemDeCosto;
import com.prosegur.rulesEngine.services.soapService.model.ItemDeCostoDetalle;
import com.prosegur.rulesEngine.services.soapService.model.MedioAuxiliar;
import com.prosegur.rulesEngine.services.soapService.model.MedioAuxiliarDetalle;
import com.prosegur.rulesEngine.services.soapService.model.OT;
import com.prosegur.rulesEngine.services.soapService.model.OtVivaRequest;
import com.prosegur.rulesEngine.services.soapService.model.OtVivaResponseError;
import com.prosegur.rulesEngine.services.soapService.model.OtVivaResponseOk;
import com.prosegur.rulesEngine.services.soapService.model.Params;
import com.prosegur.rulesEngine.services.soapService.model.RequestCosteo;
import com.prosegur.rulesEngine.services.soapService.model.ResponseCosteo;
import com.prosegur.rulesEngine.services.soapService.model.Subcliente;
import com.prosegur.rulesEngine.services.soapService.model.TipoPuesto;

public class MapperFacts {
	
	public static FactRequest parse(RequestCosteo request, OtVivaRequest otViva) {
		
		FactRequest factRequest = new FactRequest();
		factRequest.setParams(MapperFacts.parse(request, otViva.getParams()));
		factRequest.setMediosAuxiliares(MapperFacts.parseMediosAuxiliares(otViva.getMediosAuxiliares()));
		factRequest.setBeneficios(MapperFacts.parseBeneficios(otViva.getBeneficios()));
		factRequest.setItemsDeCosto(MapperFacts.parseItemsDeCosto(otViva.getItemsDeCosto()));
		factRequest.setOt(MapperFacts.parse(otViva.getOt()));
		factRequest.setCliente(factRequest.getOt().getCliente());
		factRequest.setSubcliente(factRequest.getOt().getSubcliente());
		factRequest.setEsquemasOperativos(MapperFacts.parseEsquemasOperativos(factRequest.getOt(), otViva.getEsquemasOperativos()));
		factRequest.setEscalas(MapperFacts.parseEscalas(otViva.getEscalas()));
		factRequest.setTiposPuestos(MapperFacts.parseTiposPuestos(otViva.getTiposPuestos()));
		factRequest.setCategoriasSalariales(MapperFacts.parseCategoriasSalariales(otViva.getCategoriasSalariales()));
		factRequest.setEscalasXcategorias(MapperFacts.parseEscalasXcategorias(otViva.getEscalasXcategorias()));
		factRequest.setGruposTarifarios(MapperFacts.parseGruposTarifarios(otViva.getGruposTarifarios()));
		factRequest.setConceptosFacturacion(MapperFacts.parseConceptosFacturacion(otViva.getDatosFacturacion().getConceptosFacturacion()));
		factRequest.setDatosFacturacion(MapperFacts.parseDatosFacturacion(otViva.getDatosFacturacion().getDatos()));
				
		return factRequest;
	}

    public static FactParams parse(RequestCosteo request, Params params) {
    	FactParams factParams = new FactParams();
    	
    	factParams.setFechaEjecucion(request.getFechaEjecucion());
    	
    	factParams.setNumeroDiasMes(params.getNumeroDiasMes());
    	factParams.setNumeroFestivosMes(params.getNumeroFestivosMes());
    	factParams.setCoeficienteStdDiasXsemana(params.getCoeficienteStdDiasXsemana());
    	factParams.setAceptaPuestosSinCobertura(params.isAceptaPuestosSinCobertura());
    	factParams.setMargenInformado(params.getMargenInformado());
    	    	
    	return factParams;
    }
    
    public static FactOT parse(OT ot) {
    	FactOT factOT = new FactOT();
    	
    	factOT.setId(ot.getUid());
    	factOT.setEmpresa(ot.getEmpresa());
    	factOT.setDelegacion(ot.getDelegacion());
    	factOT.setCliente(parse(ot.getCliente()));
    	factOT.setSubcliente(parse(ot.getSubcliente()));
    	factOT.setTipoServicio(ot.getTipoServicio().value());
    	
    	factOT.setMediosAuxiliares (parseMediosAuxiliaresDetalles(ot.getMediosAuxiliares()));
    	factOT.setBeneficios (parseBeneficiosDetalles(ot.getBeneficios()));		
    	factOT.setItemsDeCosto (parseItemsDeCostoDetalles(ot.getItemsDeCosto()));
    	
    	return factOT;
    }
    
    public static List<FactEscala> parseEscalas(List<Escala> escalas) {
    	List<FactEscala> factsEscalas = new ArrayList<FactEscala>();
    	
    	for (Escala escala : escalas) {
	    	FactEscala factEscala = new FactEscala();
	    	
	    	factEscala.setId(escala.getId());
	    	factEscala.setDiasTrabajadosXsemana(escala.getDiasTrabajadosXsemana());
	    	factEscala.setDiasLibresXsemana(escala.getDiasLibresXsemana());
	    	
	    	factsEscalas.add(factEscala);
    	}
    	
    	return factsEscalas;
    }
    
    public static List<FactCategoriaSalarial> parseCategoriasSalariales(List<CategoriaSalarial> categoriasSalariales) {
    	List<FactCategoriaSalarial> factsCategoriasSalariales = new ArrayList<FactCategoriaSalarial>();
    	
    	for (CategoriaSalarial categoriaSalarial : categoriasSalariales) {
    		FactCategoriaSalarial factCategoriaSalarial = new FactCategoriaSalarial();
	    	
        	factCategoriaSalarial.setId(categoriaSalarial.getId());
        	factCategoriaSalarial.setDescripcion(categoriaSalarial.getDescripcion());
	    	
        	factsCategoriasSalariales.add(factCategoriaSalarial);
    	}
    	
    	return factsCategoriasSalariales;    	
    }
    
    public static FactEscalaXCategoria parse(EscalaXCategoria escalaXCategoria) {
    	FactEscalaXCategoria factEscalaXCategoria = new FactEscalaXCategoria();
    	
    	factEscalaXCategoria.setIdEscala(escalaXCategoria.getEscala().getId());
    	factEscalaXCategoria.setIdTipoPuesto(escalaXCategoria.getTipoPuesto().getId());
    	factEscalaXCategoria.setIdCategoriaSalarial(escalaXCategoria.getCategoriaSalarial().getId());
    	factEscalaXCategoria.setHoraInicioAdicNocturno(escalaXCategoria.getHoraInicioAdicNocturno());
    	factEscalaXCategoria.setHoraFinAdicNocturno(escalaXCategoria.getHoraFinAdicNocturno());
    	factEscalaXCategoria.setPorcentajeHoraExtraEscala(escalaXCategoria.getPorcentajeHoraExtraEscala());
    	factEscalaXCategoria.setPorcentajeHoraExtraLibreTrabajado(escalaXCategoria.getPorcentajeHoraExtraLibreTrabajado());
    	factEscalaXCategoria.setPorcentajeHoraExtraAdicNocturno(escalaXCategoria.getPorcentajeHoraExtraAdicNocturno());
    	factEscalaXCategoria.setPorcentajeHoraExtraAlmuerzo(escalaXCategoria.getPorcentajeHoraExtraAlmuerzo());
    	factEscalaXCategoria.setPorcentajeHoraExtraFestivo(escalaXCategoria.getPorcentajeHoraExtraFestivo());
    	factEscalaXCategoria.setPorcentajeHoraExtraEspecial(escalaXCategoria.getPorcentajeHoraExtraEspecial());
    	
    	return factEscalaXCategoria;
    }
    
    public static List<FactTipoPuesto> parseTiposPuestos(List<TipoPuesto> tiposPuestos) {
    	List<FactTipoPuesto> factsTiposPuestos = new ArrayList<FactTipoPuesto>();
    	
    	for (TipoPuesto tipoPuesto : tiposPuestos) {
    		FactTipoPuesto factTipoPuesto = new FactTipoPuesto();
	    	
        	factTipoPuesto.setId(tipoPuesto.getId());
        	factTipoPuesto.setDescripcion(tipoPuesto.getDescripcion());
	    	
        	factsTiposPuestos.add(factTipoPuesto);
    	}
    	
    	return factsTiposPuestos;
    }


    public static List<FactEscalaXCategoria> parseEscalasXcategorias(List<EscalaXCategoria> escalasXcategorias) {
    	List<FactEscalaXCategoria> factsEscalasXcategorias = new ArrayList<FactEscalaXCategoria>();
    	
    	for (EscalaXCategoria escalaXcategoria : escalasXcategorias) {
    		factsEscalasXcategorias.add(parse(escalaXcategoria));
    	}
    	
    	return factsEscalasXcategorias;
    }
        
    public static FactMedioAuxiliar parse(MedioAuxiliar medioAuxiliar) {
    	FactMedioAuxiliar factMedioAuxiliar = new FactMedioAuxiliar();
    	
    	factMedioAuxiliar.setId (medioAuxiliar.getId());
    	factMedioAuxiliar.setDescripcion (medioAuxiliar.getDescripcion());
    	
    	return factMedioAuxiliar;
    }

    public static FactMedioAuxiliarDetalle parse(MedioAuxiliarDetalle medioAuxiliarDetalle) {
    	FactMedioAuxiliarDetalle factMedioAuxiliarDetalle = new FactMedioAuxiliarDetalle();
    	
    	factMedioAuxiliarDetalle.setId (medioAuxiliarDetalle.getMedioAuxiliar().getId());
    	factMedioAuxiliarDetalle.setCantidad (medioAuxiliarDetalle.getCantidad());
    	factMedioAuxiliarDetalle.setCosteAmortizacionUnitario (medioAuxiliarDetalle.getCosteAmortizacionUnitario());
    	factMedioAuxiliarDetalle.setCosteAmortizacionTotal (medioAuxiliarDetalle.getCosteAmortizacionTotal());
    	
    	return factMedioAuxiliarDetalle;
    }    
    
    public static FactItemDeCosto parse(ItemDeCosto itemDeCosto) {
    	FactItemDeCosto factItemDeCosto = new FactItemDeCosto();
    	
    	factItemDeCosto.setId (itemDeCosto.getId());
    	factItemDeCosto.setDescripcion (itemDeCosto.getDescripcion());
    	
    	return factItemDeCosto;
    }

    public static FactItemDeCostoDetalle parse(ItemDeCostoDetalle itemDeCostoDetalle) {
    	FactItemDeCostoDetalle factItemDeCostoDetalle = new FactItemDeCostoDetalle();
    	
    	factItemDeCostoDetalle.setIdGrupoTarifario (itemDeCostoDetalle.getGrupoTarifario().getId());
    	factItemDeCostoDetalle.setIdItemDeCosto (itemDeCostoDetalle.getItemDeCosto().getId());
    	factItemDeCostoDetalle.setValor (itemDeCostoDetalle.getValor());
    	
    	return factItemDeCostoDetalle;
    }

    public static List<FactMedioAuxiliar> parseMediosAuxiliares(List<MedioAuxiliar> mediosAuxiliares) {
    	List<FactMedioAuxiliar> factsMediosAuxiliares = new ArrayList<FactMedioAuxiliar>();
    	
    	for (MedioAuxiliar medioAuxiliar : mediosAuxiliares) {
	    	factsMediosAuxiliares.add(parse(medioAuxiliar));
    	}
    	
    	return factsMediosAuxiliares;
    }
	
    public static List<FactItemDeCosto> parseItemsDeCosto(List<ItemDeCosto> itemsDeCosto) {
    	List<FactItemDeCosto> factsItemsDeCosto = new ArrayList<FactItemDeCosto>();
    	
    	for (ItemDeCosto itemDeCosto : itemsDeCosto) {
	    	factsItemsDeCosto.add(parse(itemDeCosto));
    	}
    	
    	return factsItemsDeCosto;
    }
    
    public static List<FactMedioAuxiliarDetalle> parseMediosAuxiliaresDetalles(List<MedioAuxiliarDetalle> mediosAuxiliaresDetalles) {
    	List<FactMedioAuxiliarDetalle> factsMediosAuxiliaresDetalles = new ArrayList<FactMedioAuxiliarDetalle>();
    	
    	for (MedioAuxiliarDetalle medioAuxiliarDetalle : mediosAuxiliaresDetalles) {
	    	factsMediosAuxiliaresDetalles.add(parse(medioAuxiliarDetalle));
    	}
    	
    	return factsMediosAuxiliaresDetalles;
    }	
    
    public static List<FactItemDeCostoDetalle> parseItemsDeCostoDetalles(List<ItemDeCostoDetalle> itemsDeCostoDetalles) {
    	List<FactItemDeCostoDetalle> factsItemsDeCostoDetalles = new ArrayList<FactItemDeCostoDetalle>();
    	
    	for (ItemDeCostoDetalle itemDeCostoDetalle : itemsDeCostoDetalles) {
	    	factsItemsDeCostoDetalles.add(parse(itemDeCostoDetalle));
    	}
    	
    	return factsItemsDeCostoDetalles;
    }	
    
    public static List<FactBeneficioDetalle> parseBeneficiosDetalles(List<BeneficioDetalle> beneficiosDetalles) {
    	List<FactBeneficioDetalle> factsBeneficiosDetalles = new ArrayList<FactBeneficioDetalle>();
    	
    	for (BeneficioDetalle beneficioDetalle : beneficiosDetalles) {
	    	factsBeneficiosDetalles.add(parse(beneficioDetalle));
    	}
    	
    	return factsBeneficiosDetalles;
    }	    
    
	public static FactBeneficioDetalle parse(BeneficioDetalle beneficioDetalle) {
		FactBeneficioDetalle factBeneficioDetalle = new FactBeneficioDetalle();
		
		factBeneficioDetalle.setId (beneficioDetalle.getBeneficio().getId());
		factBeneficioDetalle.setCantidad (beneficioDetalle.getCantidad());
		factBeneficioDetalle.setValorUnitario (beneficioDetalle.getValorUnitario());
		factBeneficioDetalle.setValorTotal (beneficioDetalle.getValorTotal());
		
		return factBeneficioDetalle;
	}

    public static FactBeneficio parse(Beneficio beneficio) {
		FactBeneficio factBeneficio = new FactBeneficio();
		
		factBeneficio.setId (beneficio.getId());
		factBeneficio.setDescripcion (beneficio.getDescripcion());
		
		return factBeneficio;
	}

    public static FactCliente parse(Cliente cliente) {
		FactCliente factCliente = new FactCliente();
		
		factCliente.setId (cliente.getId());
		
		return factCliente;
	}
    
    public static FactSubcliente parse(Subcliente subcliente) {
		FactSubcliente factSubcliente = new FactSubcliente();
		
		factSubcliente.setId (subcliente.getId());
		factSubcliente.setPais (subcliente.getPais());
		factSubcliente.setFilial (subcliente.getFilialOperativa());
		factSubcliente.setEstado (subcliente.getEstado());
		factSubcliente.setCiudad (subcliente.getCiudad());
		factSubcliente.setFechaInicio (subcliente.getFechaInicio());
		factSubcliente.setNumDiasCondicionPago (subcliente.getNumDiasCondicionPago());
		
		return factSubcliente;
	}
    
	public static List<FactBeneficio> parseBeneficios(List<Beneficio> beneficios) {
		List<FactBeneficio> factsBeneficios = new ArrayList<FactBeneficio>();
		
		for (Beneficio beneficio : beneficios) {
			factsBeneficios.add(parse(beneficio));
		}
		
		return factsBeneficios;
	}
	
	public static List<FactConceptoFacturacion> parseConceptosFacturacion (List<ConceptoFacturacion> conceptosFacturacion) {
		List<FactConceptoFacturacion> factsConceptosFacturacion = new ArrayList<FactConceptoFacturacion>();
		
		for (ConceptoFacturacion conceptoFacturacion : conceptosFacturacion) {
			factsConceptosFacturacion.add(parse(conceptoFacturacion));
		}
		
		return factsConceptosFacturacion;
	}	
	
	public static FactConceptoFacturacion parse(ConceptoFacturacion conceptoFacturacion) {
		FactConceptoFacturacion factConceptoFacturacion = new FactConceptoFacturacion();
		
		factConceptoFacturacion.setId (conceptoFacturacion.getId());
		factConceptoFacturacion.setDescripcion (conceptoFacturacion.getDescripcion());
		
		return factConceptoFacturacion;
	}
	
	public static List<FactGrupoTarifario> parseGruposTarifarios (List<GrupoTarifario> gruposTarifario) {
		List<FactGrupoTarifario> factsGruposTarifarios = new ArrayList<FactGrupoTarifario>();
		
		for (GrupoTarifario grupoTarifario : gruposTarifario) {
			factsGruposTarifarios.add(parse(grupoTarifario));
		}
		
		return factsGruposTarifarios;
	}	
	
	public static FactGrupoTarifario parse(GrupoTarifario grupoTarifario) {
		FactGrupoTarifario factGrupoTarifario = new FactGrupoTarifario();
		
		factGrupoTarifario.setId (grupoTarifario.getId());
		factGrupoTarifario.setDescripcion (grupoTarifario.getDescripcion());
		
		return factGrupoTarifario;
	}
	
	public static List<FactDatoFacturacion> parseDatosFacturacion (List<DatoFacturacion> datosFacturacion) {
		List<FactDatoFacturacion> factsDatosFacturacion = new ArrayList<FactDatoFacturacion>();
		
		for (DatoFacturacion datoFacturacion : datosFacturacion) {
			factsDatosFacturacion.add(parse(datoFacturacion));
		}
		
		return factsDatosFacturacion;
	}	
	
	public static FactDatoFacturacion parse(DatoFacturacion datoFacturacion) {
		FactDatoFacturacion factDatoFacturacion = new FactDatoFacturacion();
		
		factDatoFacturacion.setIdGrupoTarifario (datoFacturacion.getGrupoTarifario().getId());
		factDatoFacturacion.setIdConceptoFacturacion (datoFacturacion.getConceptoFacturacion().getId());
		factDatoFacturacion.setCantidad (datoFacturacion.getCantidad());
		factDatoFacturacion.setPrecioUnitario (datoFacturacion.getPrecio());
		
		return factDatoFacturacion;
	}
	
    public static List<FactEsquemaOperativo> parseEsquemasOperativos(FactOT factOt, List<EsquemaOperativo> esquemasOperativos) {
    	List<FactEsquemaOperativo> factsEsquemasOperativos = new ArrayList<FactEsquemaOperativo>();
    	
    	for (EsquemaOperativo esquemaOperativo : esquemasOperativos) {
	    	FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
	    	
	    	factEsquemaOperativo.setOt(factOt);
	    	factEsquemaOperativo.setId(esquemaOperativo.getId());
	    	factEsquemaOperativo.setNumeroPuestos(esquemaOperativo.getNumeroPuestos());
	    	factEsquemaOperativo.setIdEscala(esquemaOperativo.getEscala().getId());
	    	factEsquemaOperativo.setIdTipoPuesto(esquemaOperativo.getTipoPuesto().getId());
	    	factEsquemaOperativo.setHorasJornadaXpersona(esquemaOperativo.getHorasJornadaXpersona());
	    	factEsquemaOperativo.setIdCategoriaSalarial(esquemaOperativo.getCategoriaSalarial().getId());
	    	factEsquemaOperativo.setDiasTrabajadosSemana(esquemaOperativo.getDiasTrabajadosSemana());
	    	factEsquemaOperativo.setHoraFinJornada(esquemaOperativo.getHoraFinJornada());
	    	factEsquemaOperativo.setCoberturaAlmuerzo((esquemaOperativo.getCoberturaAlmuerzo()==null)?null:esquemaOperativo.getCoberturaAlmuerzo().value());
	    	factEsquemaOperativo.setHorasAlmuerzo(esquemaOperativo.getHorasAlmuerzo());
	    	factEsquemaOperativo.setTipoJornada((esquemaOperativo.getTipoJornada()==null)?null:esquemaOperativo.getTipoJornada().value());
	    	factEsquemaOperativo.setNumeroPersonasReal(esquemaOperativo.getNumeroPersonasReal());
	    	factEsquemaOperativo.setNumeroPersonas(esquemaOperativo.getNumeroPersonas());
	    	factEsquemaOperativo.setNumeroTurnosMes(esquemaOperativo.getNumeroTurnosMes());
	    	factEsquemaOperativo.setHorasInItinere(esquemaOperativo.getHorasInItinere());
	    	factEsquemaOperativo.setHorasSobreAviso(esquemaOperativo.getHorasSobreAviso());
	    	
	    	factEsquemaOperativo.setHorasIntrajornada((esquemaOperativo.getHora(TipoHora.HORAINTRAJORNADA)==null)?0:esquemaOperativo.getHora(TipoHora.HORAINTRAJORNADA).getValor());
	    	factEsquemaOperativo.setHorasNormales((esquemaOperativo.getHora(TipoHora.HORANORMAL)==null)?0:esquemaOperativo.getHora(TipoHora.HORANORMAL).getValor());
	    	factEsquemaOperativo.setHorasAdicNocturno((esquemaOperativo.getHora(TipoHora.HORANOCTURNO)==null)?0:esquemaOperativo.getHora(TipoHora.HORANOCTURNO).getValor());
	    	factEsquemaOperativo.setHorasExtrasEfetivas((esquemaOperativo.getHora(TipoHora.HORAEXTRAEFETIVA)==null)?0:esquemaOperativo.getHora(TipoHora.HORAEXTRAEFETIVA).getValor());
	    	factEsquemaOperativo.setHorasExtrasEspeciales((esquemaOperativo.getHora(TipoHora.HORAEXTRAESPECIAL)==null)?0:esquemaOperativo.getHora(TipoHora.HORAEXTRAESPECIAL).getValor());
	    	factEsquemaOperativo.setHorasExtrasFestivo((esquemaOperativo.getHora(TipoHora.HORAEXTRAFESTIVO)==null)?0:esquemaOperativo.getHora(TipoHora.HORAEXTRAFESTIVO).getValor());
	    	factEsquemaOperativo.setHorasExtrasLibreTrabajado((esquemaOperativo.getHora(TipoHora.HORAEXTRALIBRETRABAJADO)==null)?0:esquemaOperativo.getHora(TipoHora.HORAEXTRALIBRETRABAJADO).getValor());

	    	factEsquemaOperativo.setMediosAuxiliares (parseMediosAuxiliaresDetalles(esquemaOperativo.getMediosAuxiliares()));
	    	
	    	factEsquemaOperativo.setBeneficios (parseBeneficiosDetalles(esquemaOperativo.getBeneficios()));		
	    	
	    	factsEsquemasOperativos.add (factEsquemaOperativo);
    	}
    	
    	return factsEsquemasOperativos;
    }

    /*
    public static ResponseCosteo formatResponse (RequestCosteo requestCosteo, List<DetalleCosteo> detallesCosteo) {
    	ResponseCosteo response = new ResponseCosteo();

    	response.setUid (requestCosteo.getUid());    	
    	response.setIdCosteo (requestCosteo.getIdCosteo());
    	response.setIdOt(requestCosteo.getOt().getUid());
    	response.setIdClasificacion(requestCosteo.getOt().getClasificacion());
    	response.setIdCliente(requestCosteo.getOt().getCliente().getUid());
    	response.setIdSubcliente(requestCosteo.getOt().getSubcliente().getUid());
    	response.setIdGrupoTarifario(requestCosteo.getOt().getGrupotarifario());
    	response.setDetallesCosteo (detallesCosteo);
    	
    	return response;
    }
    */

    public static ResponseCosteo formatResponse(RequestCosteo requestCosteo, List<OtVivaResponseOk> otsVivasResponseOk, List<OtVivaResponseError> otsVivasResponseError) {
    	ResponseCosteo response = new ResponseCosteo();
      
		response.setUid(requestCosteo.getUid());
		response.setIdCosteo(requestCosteo.getIdCosteo());
		response.setOtsVivasOk(otsVivasResponseOk);
		response.setOtsVivasError(otsVivasResponseError);
		      
		return response;
    }
    
    public static OtVivaResponseOk formatOtVivaResponse(OtVivaRequest otVivaRequest, List<DetalleCosteo> detallesCosteo) {
    	OtVivaResponseOk response = new OtVivaResponseOk();
      
		response.setIdOt(otVivaRequest.getOt().getUid());
		response.setIdClasificacion(otVivaRequest.getOt().getClasificacion());
		response.setIdCliente(otVivaRequest.getOt().getCliente().getUid());
		response.setIdSubcliente(otVivaRequest.getOt().getSubcliente().getUid());
		response.setIdGrupoTarifario(otVivaRequest.getOt().getGrupotarifario());
		response.setDetallesCosteo(detallesCosteo);
		  
		return response;
    }
    
    public static OtVivaResponseError formatOtVivaResponse(OtVivaRequest otVivaRequest, DetalleCosteoError detalleCosteoError) {
    	OtVivaResponseError response = new OtVivaResponseError();
      
		response.setIdOt(otVivaRequest.getOt().getUid());
		response.setIdClasificacion(otVivaRequest.getOt().getClasificacion());
		response.setIdCliente(otVivaRequest.getOt().getCliente().getUid());
		response.setIdSubcliente(otVivaRequest.getOt().getSubcliente().getUid());
		response.setIdGrupoTarifario(otVivaRequest.getOt().getGrupotarifario());
		response.setDetalleError(detalleCosteoError);
		      
		return response;
    }
}

