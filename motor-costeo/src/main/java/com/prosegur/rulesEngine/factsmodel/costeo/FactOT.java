package com.prosegur.rulesEngine.factsmodel.costeo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class FactOT {
	private String id;
	private String empresa;
	private String delegacion;
	private FactCliente cliente;
	private FactSubcliente subcliente;
	private String tipoServicio;	
	
	private List<FactBeneficioDetalle> beneficios;
	private List<FactMedioAuxiliarDetalle> mediosAuxiliares;
	private List<FactItemDeCostoDetalle> itemsDeCosto;
	
	public void addBeneficio (FactBeneficioDetalle beneficio) {
		if (beneficios == null) {
			beneficios = new ArrayList<FactBeneficioDetalle>();
		}
		beneficios.add(beneficio);
	}
	
	public FactBeneficioDetalle getBeneficio (int codigoBeneficio) {
		if (beneficios !=null) {
			for (FactBeneficioDetalle beneficio : beneficios) {
				if (beneficio.getId() == codigoBeneficio) {
					return beneficio;
				}
			}
		}
		
		return null;
	}

	public void addMedioAuxiliar (FactMedioAuxiliarDetalle mediosAuxiliar) {
		if (mediosAuxiliares == null) {
			mediosAuxiliares = new ArrayList<FactMedioAuxiliarDetalle>();
		}
		mediosAuxiliares.add(mediosAuxiliar);
	}
	
	public FactMedioAuxiliarDetalle getMedioAuxiliar (String codigoMedioAuxiliar) {
		if (mediosAuxiliares !=null) {
			for (FactMedioAuxiliarDetalle medioAuxiliar : mediosAuxiliares) {
				if (medioAuxiliar.getId().equals(codigoMedioAuxiliar)) {
					return medioAuxiliar;			
				}
			}
		}
		
		return null;
	}
	
	public void addItemDeCosto (FactItemDeCostoDetalle itemDeCosto) {
		if (itemsDeCosto == null) {
			itemsDeCosto = new ArrayList<FactItemDeCostoDetalle>();
		}
		itemsDeCosto.add(itemDeCosto);
	}
	
	public FactItemDeCostoDetalle getItemDeCosto (String idGrupoTarifario, String idItemDeCosto) {
		if (itemsDeCosto !=null) {
			for (FactItemDeCostoDetalle itemDeCosto : itemsDeCosto) {
				if (itemDeCosto.getIdGrupoTarifario().equals(idGrupoTarifario) && itemDeCosto.getIdItemDeCosto().equals(idItemDeCosto)) {
					return itemDeCosto;			
				}
			}
		}
		
		return null;
	}	
	
	/**
	 * Gestion de excepciones
	 */
	
	@Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)	
	private HashMap<String, Double> excepciones = new HashMap<String, Double>();

	public void setExcepcion(String clave, double valor) {
		excepciones.put(clave, valor);
	}

	public Double getExcepcion(String clave) {
		Double valor = excepciones.get(clave);

		return valor;
	}
	
	/**
	 * Flags
	 */
	@Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)	
	private HashMap<Flag, Boolean> flags = new HashMap<Flag, Boolean>();

	public void active (Flag flag) {
		flags.put(flag, true);
	}

	public void desactive (Flag flag) {
		flags.put(flag, false);
	}

	public boolean isActive (Flag flag) {
		Boolean active = flags.get(flag);
		
		return (active!=null && active)?true:false;
	}
	
	/**
	 * Variables de ámbito
	 */	
	@Deprecated
	private Double p_des_vtra;
	private Double p_iss;	
	private Double p_pis;
	private Double p_cofins;
	private Double p_cpmf;
	private Double p_taxa_financ;
	private Double q_taxa_financ;
	private Double p_venta1;
	private Double p_venta2;
	private Double p_venta3;
	private Double p_venta4;
	private Double p_venta5;	
	private Double v_salariomin = 0d;
	private Double p_taxa_fee;
	private Double p_provisao_CCT;
	private Double p_carta_fianca;
}
