package unitary;

import org.junit.BeforeClass;
import org.junit.Test;

import unitary.data.DataBase;
import base.JUnitBase;

public class Concepto114_gratificacionSobreSalarioBase extends JUnitBase {
	private final static String rulesFile = "rules/costeo/BRA/nivelCosteo.drl;" + 
											"rules/costeo/BRA/Concepto 114 - Gratificacion sobre salario base.drl";
	
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
		
//		Costeo costeo = (Costeo)ksession.getGlobal(identifierGlobalCosteo);

		System.out.println ("Concepto 114 no evaluado");
		
//		assertEquals(2, costeo.getDetalles().size());
//		
//		for (DetalleCosteo detalleCosteo : costeo.getDetalles()) {
//			if (detalleCosteo.getCodigoConcepto()==112) {
//				if (detalleCosteo.getCodigoAgrupacion1().equals("VD") && detalleCosteo.getCodigoAgrupacion2().equals("SVIG - MG")) {
//					assertEquals("Gratificacao X OT - VD", detalleCosteo.getDescripcion());
//					assertEquals(8, detalleCosteo.getValor1(), delta);
//					assertEquals(100, detalleCosteo.getValor2(), delta);
//					assertEquals(0.0, detalleCosteo.getValor3(), delta);
//					assertEquals(8*100, detalleCosteo.getTotal(), delta);
//				} else if (detalleCosteo.getCodigoAgrupacion1().equals("IN V1") && detalleCosteo.getCodigoAgrupacion2().equals("SVIG - MG")) {
//					assertEquals("Gratificacao X OT - IN V1", detalleCosteo.getDescripcion());
//					assertEquals(4, detalleCosteo.getValor1(), delta);
//					assertEquals(100, detalleCosteo.getValor2(), delta);
//					assertEquals(0.0, detalleCosteo.getValor3(), delta);
//					assertEquals(4*100, detalleCosteo.getTotal(), delta);
//				} else {
//					System.out.println ("Par agrupacion ("+detalleCosteo.getCodigoAgrupacion1()+"/"+detalleCosteo.getCodigoAgrupacion2()+") no evaluado");
//				}
//			} else {
//				System.out.println ("Concepto " + detalleCosteo.getCodigoConcepto() + " no evaluado");
//			}
//		}
    }

	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
//		ksession.insert(DataBase.getTipoPuesto_VD());
//		ksession.insert(DataBase.getCategoriaSalarial_SVIG_MG());
//		ksession.insert(DataBase.getEsquemaOperativo002_12());
//		ksession.insert(DataBase.getOT002());
//		
//		ksession.fireAllRules();
//		
//		Costeo costeo = (Costeo)ksession.getGlobal(identifierGlobalCosteo);
//
//		assertEquals(1, costeo.getDetalles().size());
//		
//		for (DetalleCosteo detalleCosteo : costeo.getDetalles()) {
//			if (detalleCosteo.getCodigoConcepto()==112) {
//				if (detalleCosteo.getCodigoDescripcion()==12) {
//					assertEquals("Gratificacao X OT - SVIG - MG_VD", detalleCosteo.getDescripcion());
//					assertEquals(4, detalleCosteo.getValor1(), delta);
//					assertEquals(125, detalleCosteo.getValor2(), delta);
//					assertEquals(0.0, detalleCosteo.getValor3(), delta);
//					assertEquals(4*125, detalleCosteo.getTotal(), delta);
//				} else {
//					System.out.println ("Agrupacion ("+detalleCosteo.getCodigoDescripcion()+") no evaluado");
//				}
//			} else {
//				System.out.println ("Concepto " + detalleCosteo.getCodigoConcepto() + " no evaluado");
//			}
//		}
    }
}

