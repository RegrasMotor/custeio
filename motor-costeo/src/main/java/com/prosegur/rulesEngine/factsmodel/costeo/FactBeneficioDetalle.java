package com.prosegur.rulesEngine.factsmodel.costeo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FactBeneficioDetalle {
	
	private int id;
	private double cantidad;
	private double valorUnitario;
	private double valorTotal;
}
