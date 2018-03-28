package com.prosegur.rulesEngine.factsmodel.costeo;

public enum Acum {
	GRUPO_AdicionalTiempoServicio("ATS_"),
	GRUPO_AsistenciaMedica("assmedicaCATEG_"),
	GRUPO_ATS("ATS_"),
	GRUPO_CestaBasica("tot_cbasica_"),
	GRUPO_DSRunitario("dsr_unitario_"),
	GRUPO_Festivos("tot_ferias_"), // Tb ac_ferias_por_CatTposto
	GRUPO_Gratificacion("tot_grat_"),
	GRUPO_Gratificacion112("tot_grat_112"),
	GRUPO_Gratificacion113("tot_grat_113"),
	GRUPO_Gratificacion114("tot_grat_114"),
	GRUPO_HorasExtras("horasextras_"),
	GRUPO_HorasNormales("tot_HNormal_"),
	GRUPO_IncidEncargos("IncidEncargos_"),
	GRUPO_TotPeric("tot_peric"),
	GRUPO_Salario("tot_Salario_"),	//valor total del beneficio 100
	GRUPO_SalarioBasico("tot_sbasico"),
	GRUPO_ARV("tot_riscovida_"),
	GRUPO_ARVUnitario("arv_unitario_"),
	GRUPO_ARVFijo("arv_fixo_"),
	GRUPO_TotAssid("tot_Assid_"),
	GRUPO_TotRem1("tot_rem1_"),
	GRUPO_TotRem3("tot_rem3_"),
	GRUPO_TotRem4("tot_rem4_"),
	GRUPO_TotRem5("tot_rem5_"),
	GRUPO_TotRemARV("tot_remARV_"),
	GRUPO_ValeComida("tot_valeref_"),
	GRUPO_ValeComidaRendeiro("tot_valerefRend_"),
	GRUPO_SeguroVida("tot_svida_"),
	TOTAL_HORA_ALMUERZO("tot_hora_almuerzo"), //concepto 230
	TOTAL_HORAS_EXTRAORDINARIAS("tot_horas_extraordinarias"), 
	TOTAL_HORAS_NOTURNAS("tot_horas_noturnas"), 
	TOTAL_Costo("pg_tot_mocosto"),
	TOTAL_IngresosBrutos("pg_tot_ingreso"),
	TOTAL_SalarioBasico("pg_tot_sbasico"),
	TOTAL_Impuestos("pg_tot_taxcosto"),
	TOTAL_Tasas("pg_tot_taxas"),
	TOTAL_PorcTasas("pg_tot_porctaxas"),
	TOTAL_PorcImpuestos("pg_tot_porctax"),
	TOTAL_VT("pg_tot_VT"),
	TOTAL_RECEITA_LIQUIDA("tot_receita_liquida");//concepto 9007
	
	private String name;
	
	private Acum(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
