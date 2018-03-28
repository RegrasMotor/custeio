package com.prosegur.rulesEngine.factsmodel.costeo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FactSubcliente {
	private String id;
	private String pais;
	private String filial;
	private String estado;
	private String ciudad;
	private Date fechaInicio;
	private int numDiasCondicionPago;
}
