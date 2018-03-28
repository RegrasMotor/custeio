package com.prosegur.rulesEngine.factsmodel.costeo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FactItemDeCostoDetalle{
	
	private String idGrupoTarifario;
	private String idItemDeCosto;
	private double valor;
}
