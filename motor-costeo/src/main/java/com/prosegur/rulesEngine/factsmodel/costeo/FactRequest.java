package com.prosegur.rulesEngine.factsmodel.costeo;

import java.util.List;

import lombok.Data;

@Data
public class FactRequest {

	private FactParams params;
	private FactOT ot;
	private FactCliente cliente;
	private FactSubcliente subcliente;
	private List<FactBeneficio> beneficios;
	private List<FactMedioAuxiliar> mediosAuxiliares;
	private List<FactItemDeCosto> itemsDeCosto;
	private List<FactCategoriaSalarial> categoriasSalariales;
	private List<FactEscala> escalas;
	private List<FactEscalaXCategoria> escalasXcategorias;
	private List<FactEsquemaOperativo> esquemasOperativos;
	private List<FactTipoPuesto> tiposPuestos;
	private List<FactGrupoTarifario> gruposTarifarios;
	private List<FactConceptoFacturacion> conceptosFacturacion;
	private List<FactDatoFacturacion> datosFacturacion;
}
