package com.prosegur.rulesEngine.factsmodel.costeo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FactMedioAuxiliarDetalle{
	
	private String id;
	private double cantidad;
	private double costeAmortizacionUnitario;
	private double costeAmortizacionTotal;
}
