package unitary;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

public class Concepto535_cestaBasicaAdicional extends JUnitBase {
	private final static String rulesFile = "rules/costeo/BRA/nivelCosteo.drl;" + 
											"rules/costeo/BRA/Concepto 535 - Cesta basica adicional.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);
	}
	
	@Test
    public void comprobarAccion() {
		
		System.out.println("concepto 535 no evaluado");
		
//		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion" );
//		
//		ksession.insert(DataBase.getTipoPuesto_VD());
//		ksession.insert(DataBase.getTipoPuesto_INV1());
//		ksession.insert(DataBase.getCategoriaSalarial_SVIG_MG());
//		ksession.insert(DataBase.getEsquemaOperativo001_17());
//		ksession.insert(DataBase.getEsquemaOperativo001_18());
//		ksession.insert(DataBase.getEsquemaOperativo001_20());
//		ksession.insert(DataBase.getOT001());
//		
//		ksession.fireAllRules();
//		
//		Costeo costeo = (Costeo)ksession.getGlobal(identifierGlobalCosteo);
//
//		Collection<DetalleCosteo> detallesCosteo = getDetallesCosteo();
//		
//		assertEquals(1, detallesCosteo.size());
//		
//		assertEquals(1200, costeo.getAcumulador(Acum.GRUPO_CestaBasica, "VD", "SVIG - MG"), delta);
//		assertEquals(600, costeo.getAcumulador(Acum.GRUPO_CestaBasica, "IN V1", "SVIG - MG"), delta);
//		assertEquals(1800, costeo.getAcumulador(Acum.TOTAL_Costo), delta);
//		for (DetalleCosteo detalleCosteo : detallesCosteo) {
//			if (detalleCosteo.getCodigoConcepto()==535) {
//				assertEquals("Adic. Cesta Básica", detalleCosteo.getDescripcion());
//				assertEquals(180, detalleCosteo.getValor1(), delta);
//				assertEquals(10, detalleCosteo.getValor2(), delta);
//				assertEquals(0.0, detalleCosteo.getValor3(), delta);
//				assertEquals(180*10, detalleCosteo.getTotal(), delta);
//			} else {
//				System.out.println ("Concepto " + detalleCosteo.getCodigoConcepto() + " no evaluado");
//			}
//		}
    }

//	@Test
//    public void comprobarAccion2() {
//		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
//		
//		ksession.insert(DataBase.getTipoPuesto_VD());
//		ksession.insert(DataBase.getCategoriaSalarial_SVIG_MG());
//		ksession.insert(DataBase.getEsquemaOperativo002_12());
//		ksession.insert(DataBase.getEsquemaOperativo002_13());
//		ksession.insert(DataBase.getOT002());
//		
//		ksession.fireAllRules();
//		
//		Costeo costeo = (Costeo)ksession.getGlobal(identifierGlobalCosteo);
//
//		Collection<DetalleCosteo> detallesCosteo = getDetallesCosteo();
//		
//		assertEquals(1, detallesCosteo.size());
//		
//		assertEquals(360, costeo.getAcumulador(Acum.GRUPO_CestaBasica, "VD", "SVIG - MG"), delta);
//		assertEquals(360, costeo.getAcumulador(Acum.TOTAL_Costo), delta);
//		for (DetalleCosteo detalleCosteo : detallesCosteo) {
//			if (detalleCosteo.getCodigoConcepto()==535) {
//				assertEquals("Adic. Cesta Básica", detalleCosteo.getDescripcion());
//				assertEquals(30, detalleCosteo.getValor1(), delta);
//				assertEquals(12, detalleCosteo.getValor2(), delta);
//				assertEquals(0.0, detalleCosteo.getValor3(), delta);
//				assertEquals(30*12, detalleCosteo.getTotal(), delta);
//			} else {
//				System.out.println ("Concepto " + detalleCosteo.getCodigoConcepto() + " no evaluado");
//			}
//		}
//    }
}

