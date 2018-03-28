package unitary;

/*
 * Pruebas que hay que rehacer, no válidas. A espera de acumuladores. 
 * Únicamente usada para ver que compila
 */

import org.junit.BeforeClass;
import org.junit.Test;

import unitary.data.DataBase;
import base.JUnitBase;

public class Concepto538_CestaBasicaDescuento extends JUnitBase {
	private final static String rulesFile = "rules/costeo/BRA/environmentVars/p_cesbasicSB.gdst;" +
											"rules/costeo/BRA/environmentVars/p_descestab.gdst;" +
											"rules/costeo/BRA/environmentVars/v_descestab.gdst;" +
											"rules/costeo/BRA/nivelCosteo.drl;" + 
											"rules/costeo/BRA/Concepto 538 - Cesta basica descuento.drl";
	
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
		
		ksession.fireAllRules();
		
		System.out.println ("Concepto 538 no evaluado");
		
//		Costeo costeo = (Costeo)ksession.getGlobal(identifierGlobalCosteo);
//
//		assertEquals(2, costeo.getDetalles().size());
//		
//		for (DetalleCosteo detalleCosteo : costeo.getDetalles()) {
//			if (detalleCosteo.getCodigoConcepto()==-190) {
//				if (detalleCosteo.getCodigoAgrupacion1().equals("VD") && detalleCosteo.getCodigoAgrupacion2().equals("SVIG - MG")) {
//					assertEquals("Salário - Vigilante Patrimonial - VIGILÂNCIA", detalleCosteo.getDescripcion());
//					assertEquals(8, detalleCosteo.getValor1(), delta);
//					assertEquals(1177.76, detalleCosteo.getValor2(), delta);
//					assertEquals(0.0, detalleCosteo.getValor3(), delta);
//					assertEquals(9422.08, detalleCosteo.getTotal(), delta);
//				} else if (detalleCosteo.getCodigoAgrupacion1().equals("IN V1") && detalleCosteo.getCodigoAgrupacion2().equals("SVIG - MG")) {
//					assertEquals("Salário - Inspetor Patrimonial 1 - VIGILÂNCIA", detalleCosteo.getDescripcion());
//					assertEquals(4, detalleCosteo.getValor1(), delta);
//					assertEquals(1498.31, detalleCosteo.getValor2(), delta);
//					assertEquals(0.0, detalleCosteo.getValor3(), delta);
//					assertEquals(5993.24, detalleCosteo.getTotal(), delta);
//				} else {
//					System.out.println ("Par agrupacion ("+detalleCosteo.getCodigoAgrupacion1()+"/"+detalleCosteo.getCodigoAgrupacion2()+") no evaluado");
//				}
//			} else {
//				System.out.println ("Concepto " + detalleCosteo.getCodigoConcepto() + " no evaluado");
//			}
//		}
    }
}

