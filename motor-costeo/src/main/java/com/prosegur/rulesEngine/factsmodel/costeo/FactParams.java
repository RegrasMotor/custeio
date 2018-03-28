package com.prosegur.rulesEngine.factsmodel.costeo;

import java.util.Date;

import lombok.Data;

@Data
public class FactParams {
	private Date fechaEjecucion;
	private Double margenInformado;
	private float numeroDiasMes;
	private float numeroFestivosMes;
	private boolean aceptaPuestosSinCobertura;
	private float coeficienteStdDiasXsemana;
}
