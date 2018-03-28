package com.prosegur.rulesEngine.factsmodel.costeo;

import java.util.Date;

import lombok.Data;

@Data
public class FactEscalaXCategoria {
	private String idEscala;
	private String idTipoPuesto;
	private String idCategoriaSalarial;

	private Date horaInicioAdicNocturno;
	private Date horaFinAdicNocturno;
	
	private double porcentajeHoraExtraEscala;
	private double porcentajeHoraExtraLibreTrabajado;
	private double porcentajeHoraExtraAdicNocturno;
	private double porcentajeHoraExtraAlmuerzo;
	private double porcentajeHoraExtraFestivo;	
	private double porcentajeHoraExtraEspecial;	
}
