package unitary;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

public class Compilacion extends JUnitBase {
	private final static String rulesFile = "rules/costeo/BRA/functions/auxiliares.function;" +
											"rules/costeo/BRA/functions/festivosProporcionales.function;" +

											"rules/costeo/BRA/environmentVars/c_arvanoturno.gdst;" +
											"rules/costeo/BRA/environmentVars/c_arvExtra.gdst;" +
											"rules/costeo/BRA/environmentVars/c_ARVRemun.gdst;" +
											"rules/costeo/BRA/environmentVars/c_ARVRemunDesconsidera.gdst;" +
											"rules/costeo/BRA/environmentVars/c_diatrabalho.gdst;" +
											"rules/costeo/BRA/environmentVars/p_13salario.gdst;" +
											"rules/costeo/BRA/environmentVars/p_accidente.gdst;" +
											"rules/costeo/BRA/environmentVars/p_ad_nocturno.gdst;" +
											"rules/costeo/BRA/environmentVars/p_arv_vsdf.gdst;" +
											"rules/costeo/BRA/environmentVars/p_ats.gdst;" +
											"rules/costeo/BRA/environmentVars/p_cesbasicSB.gdst;" +
											"rules/costeo/BRA/environmentVars/p_cestabasica.gdst;" +
											"rules/costeo/BRA/environmentVars/p_cofins.gdst;" +
											"rules/costeo/BRA/environmentVars/p_cpmf.gdst;" +
											"rules/costeo/BRA/environmentVars/p_cumulativa.gdst;" +
											"rules/costeo/BRA/environmentVars/p_custoabonosb.gdst;" +
											"rules/costeo/BRA/environmentVars/p_descestab.gdst;" +
											"rules/costeo/BRA/environmentVars/p_dessvida.gdst;" +
											"rules/costeo/BRA/environmentVars/p_des_vtra.gdst;" +
											"rules/costeo/BRA/environmentVars/p_diavig.gdst;" +
											"rules/costeo/BRA/environmentVars/p_encargo_13sal.gdst;" +
											"rules/costeo/BRA/environmentVars/p_encargo_feria.gdst;" +
											"rules/costeo/BRA/environmentVars/p_ferias.gdst;" +
											"rules/costeo/BRA/environmentVars/p_fgts.gdst;" +
											"rules/costeo/BRA/environmentVars/p_incra.gdst;" +
											"rules/costeo/BRA/environmentVars/p_indenizao.gdst;" +
											"rules/costeo/BRA/environmentVars/p_inden_impro.gdst;" +
											"rules/costeo/BRA/environmentVars/p_inss.gdst;" +
											"rules/costeo/BRA/environmentVars/p_in_fgts.gdst;" +
											"rules/costeo/BRA/environmentVars/p_iss.gdst;" +
											"rules/costeo/BRA/environmentVars/p_periculosidad.gdst;" +
											"rules/costeo/BRA/environmentVars/p_pis.gdst;" +
											"rules/costeo/BRA/environmentVars/p_premio_ferias.gdst;" +
											"rules/costeo/BRA/environmentVars/p_premio_indeni.gdst;" +
											"rules/costeo/BRA/environmentVars/p_processo.gdst;" +
											"rules/costeo/BRA/environmentVars/p_rvida.gdst;" +
											"rules/costeo/BRA/environmentVars/p_rvida_encargo.gdst;" +
											"rules/costeo/BRA/environmentVars/p_sebrae.gdst;" +
											"rules/costeo/BRA/environmentVars/p_seducacion.gdst;" +
											"rules/costeo/BRA/environmentVars/p_senac.gdst;" +
											"rules/costeo/BRA/environmentVars/p_sesc.gdst;" +
											"rules/costeo/BRA/environmentVars/p_svida_fixo.gdst;" +
											"rules/costeo/BRA/environmentVars/p_svida_remun.gdst;" +
											"rules/costeo/BRA/environmentVars/p_svida_salario.gdst;" +
											"rules/costeo/BRA/environmentVars/p_taxa_financ.gdst;" +
											"rules/costeo/BRA/environmentVars/p_venta1.gdst;" +
											"rules/costeo/BRA/environmentVars/p_venta2.gdst;" +
											"rules/costeo/BRA/environmentVars/p_venta3.gdst;" +
											"rules/costeo/BRA/environmentVars/p_venta4.gdst;" +
											"rules/costeo/BRA/environmentVars/p_venta5.gdst;" +
											"rules/costeo/BRA/environmentVars/q_svida.gdst;" +
											"rules/costeo/BRA/environmentVars/q_taxa_financ.gdst;" +
											"rules/costeo/BRA/environmentVars/v_associacoes.gdst;" +
											"rules/costeo/BRA/environmentVars/v_auxfuneral.gdst;" +
											"rules/costeo/BRA/environmentVars/v_custoabonodt.gdst;" +
											"rules/costeo/BRA/environmentVars/v_custo_ria.gdst;" +
											"rules/costeo/BRA/environmentVars/v_das_odonto.gdst;" +
											"rules/costeo/BRA/environmentVars/v_descestab.gdst;" +
											"rules/costeo/BRA/environmentVars/v_desc_amedica.gdst;" +
											"rules/costeo/BRA/environmentVars/v_dessvida.gdst;" +
											"rules/costeo/BRA/environmentVars/v_divisorhoras.gdst;" +
											"rules/costeo/BRA/environmentVars/v_examenes.gdst;" +
											"rules/costeo/BRA/environmentVars/v_examen_psico.gdst;" +
											"rules/costeo/BRA/environmentVars/v_pcvc.gdst;" +
											"rules/costeo/BRA/environmentVars/v_reciclagem.gdst;" +
											"rules/costeo/BRA/environmentVars/v_recrutamento.gdst;" +
											"rules/costeo/BRA/environmentVars/v_rvida.gdst;" +
											"rules/costeo/BRA/environmentVars/v_salariomin.gdst;" +
											"rules/costeo/BRA/environmentVars/v_seguro_rc.gdst;" +
											"rules/costeo/BRA/environmentVars/v_sesmt.gdst;" +
											"rules/costeo/BRA/environmentVars/v_sindicancia.gdst;" +
											"rules/costeo/BRA/environmentVars/v_svida_fixo.gdst;" +
											"rules/costeo/BRA/environmentVars/v_taser.gdst;" +
											"rules/costeo/BRA/environmentVars/v_treinamento.gdst;" +
											"rules/costeo/BRA/environmentVars/v_ValeRefEscala.gdst;" +
			
											"rules/costeo/BRA/agrupaciones.drl;" + 
											"rules/costeo/BRA/Concepto 110 - Salario base.drl;" +
											"rules/costeo/BRA/Concepto 112 - Gratificacion X OT.drl;" +
											"rules/costeo/BRA/Concepto 113 - Gratificacion por categoria.drl;" + 
											"rules/costeo/BRA/Concepto 114 - Gratificacion sobre salario base.drl;" + 
											"rules/costeo/BRA/Concepto 118 - Riesgo de vida.drl;" +
											"rules/costeo/BRA/Concepto 120 -  Adicional nocturno.drl;" + 
											"rules/costeo/BRA/Concepto 119 - Riesgo de vida (valor fijo).drl;" +
											"rules/costeo/BRA/Concepto 140 - Reflexion sobre DSR.drl;" +
											"rules/costeo/BRA/Concepto 161 - Coste reemplazo pausa almuerzo.drl;" +
											"rules/costeo/BRA/Concepto 163 - Tiempo adicional del servicio.drl;" + 
											"rules/costeo/BRA/Concepto 180 - Dia del vigilante.drl;" + 
											"rules/costeo/BRA/Concepto 182 - Dia del trabajo.drl;" + 
											"rules/costeo/BRA/Concepto 190 -Riesgo de vida VSDF.drl;" + 
											"rules/costeo/BRA/Concepto 240 - Hora extra especial.drl;" +
											"rules/costeo/BRA/Concepto 526 - Descuento valor fijo asistencia medica.drl;" +
											"rules/costeo/BRA/Concepto 529 - Adicional Asistencia Odontologica.drl;" +
											"rules/costeo/BRA/Concepto 531 - Descuento asistencia odontologica.drl;" +
											"rules/costeo/BRA/Concepto 536 - Cesta basica adicional Sin descuento.drl;" +
											"rules/costeo/BRA/Concepto 537 - Cesta basica especial.drl;" +
											"rules/costeo/BRA/Concepto 538 - Cesta basica descuento.drl;" +
											"rules/costeo/BRA/Concepto 540 - Vale comida.drl;" + 
											"rules/costeo/BRA/Concepto 543 - Vale comida especial.drl;" +
											"rules/costeo/BRA/Concepto 545 - Adicional vale comida.drl;" +
											"rules/costeo/BRA/Concepto 610 - Inicializar medios auxiliares.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);
	}
	
	@Test
    public void comprobarAccion() {
		
	}
}

