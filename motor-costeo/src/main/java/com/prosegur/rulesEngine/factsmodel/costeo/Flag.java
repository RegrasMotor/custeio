package com.prosegur.rulesEngine.factsmodel.costeo;

public enum Flag {
	asistenciaMedicaAdicional ("pg_AdAsMedica"),
	asistenciaMedica ("pg_AsMedica"),
	asistenciaMedicaEspecial ("pg_AsMedEspecial"),
	@Deprecated
	descuentoAsistenciaMedica ("pg_AsMedicaDescValor");
	
	private String name;
	
	private Flag(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
