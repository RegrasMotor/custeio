package unitary;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;

import unitary.data.DataBase;
import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.costeo.DetalleCosteo;

public class Concepto120_adicionalNocturno extends JUnitBase {
	private final static String rulesFile = "rules/costeo/BRA/environmentVars/c_arvanoturno.gdst;" +
											"rules/costeo/BRA/environmentVars/v_divisorhoras.gdst;" +
											"rules/costeo/BRA/environmentVars/p_ad_nocturno.gdst;" +
											"rules/costeo/BRA/environmentVars/p_rvida.gdst;" +
											"rules/costeo/BRA/nivelCosteo.drl;" + 
											"rules/costeo/BRA/Concepto 118 - Riesgo de vida.drl;" +
											"rules/costeo/BRA/Concepto 120 -  Adicional nocturno.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);
	}
	
	@Test
    public void comprobarAccion() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion" );

		ksession.insert(DataBase.getTipoPuesto_VD());
		ksession.insert(DataBase.getTipoPuesto_INV1());
		ksession.insert(DataBase.getCategoriaSalarial_SVIG_MG());
		ksession.insert(DataBase.getEsquemaOperativo001_17());
		ksession.insert(DataBase.getEsquemaOperativo001_18());
		ksession.insert(DataBase.getEsquemaOperativo001_20());
		ksession.insert(DataBase.getOT001());
		
		ksession.fireAllRules();
		
		Collection<DetalleCosteo> detallesCosteo = getDetallesCosteo();
		
		assertEquals(5, detallesCosteo.size());
		
		for (DetalleCosteo detalleCosteo : detallesCosteo) {
			if (detalleCosteo.getCodigoConcepto()==118) {
				if (detalleCosteo.getCodigoAgrupacion1().equals("VD") && detalleCosteo.getCodigoAgrupacion2().equals("SVIG - MG")) {
					assertEquals("Risco de vida - Vigilante Patrimonial - VIGILÂNCIA", detalleCosteo.getDescripcion());
					assertEquals(8, detalleCosteo.getValor1(), delta);
					assertEquals(1177.76*(30/100d), detalleCosteo.getValor2(), delta);
					assertEquals(30.0, detalleCosteo.getValor3(), delta);
					assertEquals(1177.76*(30/100d)*8, detalleCosteo.getTotal(), delta);
				} else if (detalleCosteo.getCodigoAgrupacion1().equals("IN V1") && detalleCosteo.getCodigoAgrupacion2().equals("SVIG - MG")) {
					assertEquals("Risco de vida - Inspetor Patrimonial 1 - VIGILÂNCIA", detalleCosteo.getDescripcion());
					assertEquals(4, detalleCosteo.getValor1(), delta);
					assertEquals(1498.31*(50/100d), detalleCosteo.getValor2(), delta);
					assertEquals(50.0, detalleCosteo.getValor3(), delta);
					assertEquals(1498.31*(50/100d)*4, detalleCosteo.getTotal(), delta);
				} else {
					System.out.println ("Par agrupacion ("+detalleCosteo.getCodigoAgrupacion1()+"/"+detalleCosteo.getCodigoAgrupacion2()+") no evaluado");
				}
			} else if (detalleCosteo.getCodigoConcepto()==120) {
				if (detalleCosteo.getCodigoAgrupacion1().equals("17")) {
					assertEquals("Adic. Noturno - VD/12X36", detalleCosteo.getDescripcion());
					assertEquals(212.92, detalleCosteo.getValor1(), delta);
					assertEquals(12.3664, detalleCosteo.getValor2(), delta);
					assertEquals(21, detalleCosteo.getValor3(), delta);
					assertEquals(2633.0709, detalleCosteo.getTotal(), delta);
				} else if (detalleCosteo.getCodigoAgrupacion1().equals("18")) {
					assertEquals("Adic. Noturno - VD/12X36", detalleCosteo.getDescripcion());
					assertEquals(212.92, detalleCosteo.getValor1(), delta);
					assertEquals(12.3664, detalleCosteo.getValor2(), delta);
					assertEquals(21, detalleCosteo.getValor3(), delta);
					assertEquals(2633.0709, detalleCosteo.getTotal(), delta);
				} else if (detalleCosteo.getCodigoAgrupacion1().equals("20")) {
					assertEquals("Adic. Noturno - IN V1/12X36", detalleCosteo.getDescripcion());
					assertEquals(212.92, detalleCosteo.getValor1(), delta);
					assertEquals(4.0863, detalleCosteo.getValor2(), delta);
					assertEquals(40, detalleCosteo.getValor3(), delta);
					assertEquals(870.0549, detalleCosteo.getTotal(), delta);					
				} else {
					System.out.println ("Esquema de trabajo ("+detalleCosteo.getCodigoAgrupacion1()+") no evaluado");
				}
			} else {
				System.out.println ("Concepto " + detalleCosteo.getCodigoConcepto() + " no evaluado");
			}
		}
    }
}

