package com.prosegur.rulesEngine.factsmodel.costeo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class FactEsquemaOperativo {
	private static final Logger log = LoggerFactory.getLogger(FactEsquemaOperativo.class);
	
	private FactOT ot;
	private int id;
	private int numeroPuestos;
	private String idTipoPuesto;
	private String idCategoriaSalarial;
	private String idEscala;
	private String tipoJornada;
	private int    diasTrabajadosSemana;
	private float  horasJornadaXpersona;
	private double numeroPersonas;
	private double numeroPersonasReal;
	private double numeroTurnosMes;
	private String coberturaAlmuerzo;
	private double horasAlmuerzo;
	private Date  horaFinJornada;
	
	private double horasInItinere;
	private String tipoHorasInItinere;
	private String tipoHorasSobreAviso;
	private double horasSobreAviso;
	private double horasIntrajornada;
	private double horasNormales;
	private double horasAdicNocturno;
	private double horasExtrasEfetivas;
	private double horasExtrasEspeciales;
	private double horasExtrasFestivo;
	private double horasExtrasLibreTrabajado;

	/**
	 * Variables definidas en función de la escala, categoría y tipo de puesto
	 * del esquema de trabajo ()
	 */
	private double porcentualHoraEspecial;

	/**
	 * Variables de listas
	 */
	private List<FactBeneficioDetalle> beneficios;
	private List<FactMedioAuxiliarDetalle> mediosAuxiliares;
	private List<FactDatoFacturacion> datosFacturacion;

	public void addBeneficio(FactBeneficioDetalle beneficio) {
		if (beneficios == null) {
			beneficios = new ArrayList<FactBeneficioDetalle>();
		}
		beneficios.add(beneficio);
	}

	public FactBeneficioDetalle getBeneficio(int codigoBeneficio) {
		if (beneficios != null) {
			for (FactBeneficioDetalle beneficio : beneficios) {
				if (beneficio.getId() == codigoBeneficio) {
					return beneficio;
				}
			}
		}

		return null;
	}

	public void addMedioAuxiliar(FactMedioAuxiliarDetalle mediosAuxiliar) {
		if (mediosAuxiliares == null) {
			mediosAuxiliares = new ArrayList<FactMedioAuxiliarDetalle>();
		}
		mediosAuxiliares.add(mediosAuxiliar);
	}

	public FactMedioAuxiliarDetalle getMedioAuxiliar(String codigoMedioAuxiliar) {
		if (mediosAuxiliares != null) {
			for (FactMedioAuxiliarDetalle medioAuxiliar : mediosAuxiliares) {
				if (medioAuxiliar.getId().equals(codigoMedioAuxiliar)) {
					return medioAuxiliar;
				}
			}
		}

		return null;
	}

	public void addTarifa(FactDatoFacturacion datoFacturacion) {
		if (datosFacturacion == null) {
			datosFacturacion = new ArrayList<FactDatoFacturacion>();
		}
		datosFacturacion.add(datoFacturacion);
	}

	/**
	 * Variables de ámbito
	 */
	private boolean c_AdicNocRed = true;
	private boolean c_ARVRemun;
	private boolean c_ARVRemunDesconsidera;		
	private boolean c_desconsideraARV;
	private boolean c_diatrabalho;
	private boolean c_Feriado12X36;	
	private boolean c_rendeiro;
	private boolean c_subclientesCEFBA;
	private boolean ch_Regra_DescVR;
	private boolean c_nocalcDSR;
	private Double p_13salario;
	private Double p_accidente;
	private Double p_ad_nocturno;
	private Double p_ad_noct_jorn;
	private Double p_ad_nocred;
	private Double p_v_ad_nocred = 100d;
	private Double p_arv_vsdf;
	private Double p_ats;
	private Double p_ats_pat;
	private Double p_aviso;
	private Double p_cesbasicSB;
	private Double p_cestabasica;
	private Double p_cumulativa;
	private Double p_custoabonosb;
	private Double p_das_medica;
	private Double p_diavig;
	private Double p_descestab;
	private Double p_dessvida;
	private Double p_des_vtra;
	private Double p_desc_asf;
	private Double p_desc_amedica;
	private Double p_encargo_13sal;
	private Double p_encargo_feria;
	private Double p_incra;
	private Double p_inden_impro;
	private Double p_indenizao;
	private Double p_in_fgts;
	private Double p_inss = 0d;
	private Double p_fap;
	private Double p_ferias;
	private Double p_fgts;
	private Double p_periculosidad;
	private Double p_premio_ferias;
	private Double p_premio_indeni;
	private Double p_processo;
	private Double p_rvida;
	private double p_rvida_encargo;
	private Double p_sebrae;
	private Double p_seducacion;
	private Double p_senac;
	private Double p_sesc;
	private Double p_svida_fixo;
	private Double p_svida_remun;
	private Double p_svida_salario;
	private Double p_valeref;
	//GC018
	private Double p_reajuste_cct;
	private Double p_retencion;
	private Double p_absentismo;
	private Double q_svida;
	private Double v_adic_troca;
	private Double v_associacoes;
	private Double v_auxfuneral;
	private Double vCestaBasicaEsc;
	private Double v_custoabonodt = 2d;
	private Double v_custo_ria;
	private Double v_das_odonto;
	private Double v_dasm_tope;	
	private Double v_descVR = 0d;
	@Deprecated
	private Double v_desc_amedica;
	private Double v_descestab;
	private Double v_dessvida;
	private Double v_divisorhoras = 220d;
	private Double v_examen_psico;
	private Double v_examenes;
	private Double v_he_mes;
	private boolean v_hred_ext;
	private Double v_intrajornada;
	private Double v_pcvc;
	private Double v_ppr;
	private Double v_pqpm;
	private Double v_QtdRecic;
	private Double v_reciclagem;
	private Double v_recrutamento;
	private Double v_rvida;
	private Double v_seguro_rc;
	private Double v_sesmt;
	private Double v_sindicancia;
	private Double v_SumulaFixo;
	private Double v_svida_fixo;
	private Double v_taser;
	private Double v_treinamento;
	private Double v_valeref = 0d;
	private Double v_ValeRefEscala;
	private Double v_seguridad;
	private Double v_insytu;
	private Double v_descAMedicaFix;
	private Double p_custo_indenizacao;
	private Double p_custo_improdutividade;
	private Double p_custo_processo;
	private Double v_custo_mao_obra;
	private Double v_custo_inspetoria;
	
	/**
	 * Variables con excepciones y dependencias
	 */
	private int e_salarioBase120;
	private int e_salarioBase125;
	private int e_salarioBase130;
	private int e_salarioBase200;
	private int e_salarioBase210;
	private int e_salarioBase220;
	private int e_salarioBase230;
	private int e_salarioBase240;
	private int e_salarioBase270;
	private int e_salarioBase275;
	private int e_salarioBase289;	
	
	@Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)	
	private HashMap<String, Double> excepciones = new HashMap<String, Double>();

	public void setExcepcion(String clave, double valor) {
		if (log.isTraceEnabled()) {
			Double valorAnterior = excepciones.get(clave);
			log.trace("KnowledgeRuntime.FactEsquemaOperativo.setExcepcion '" + clave + "': " + valorAnterior + " -> " + valor);
		}
		excepciones.put(clave, valor);
	}

	public Double getExcepcion(String clave) {
		Double valor = excepciones.get(clave);

		return valor;
	}
}
