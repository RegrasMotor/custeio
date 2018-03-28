package com.prosegur.rulesEngine.factsmodel.costeo;

import lombok.Data;

@Data
public class FactEscala {
	private String id;
	private String descripcion;
	
	private int diasTrabajadosXsemana;
	private int diasLibresXsemana;
}
