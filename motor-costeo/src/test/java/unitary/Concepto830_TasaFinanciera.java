package unitary;

import org.junit.BeforeClass;
import org.junit.Test;

import unitary.data.DataBase;
import base.JUnitBase;

public class Concepto830_TasaFinanciera extends JUnitBase {
	private final static String rulesFile = "rules/costeo/BRA/environmentVars/p_taxa_financ.gdst;"+
											"rules/costeo/BRA/environmentVars/q_taxa_financ.gdst;"+
											"rules/costeo/BRA/functions/ventaTeorica.function;"+			
											"rules/costeo/BRA/nivelCosteo.drl;" + 
											"rules/costeo/BRA/Concepto 830 - Tasa financiera.drl";
	
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
		
//		ksession.insert(new FactTarifa(30, "Preço Mensal"));
//		ksession.insert(new FactTarifa(34, "Preço Hora Extra"));
		
		ksession.insert(DataBase.getEsquemaOperativo001_12());
		ksession.insert(DataBase.getEsquemaOperativo001_13());
		
		ksession.insert(DataBase.getEsquemaOperativo001_17());
		ksession.insert(DataBase.getEsquemaOperativo001_18());
		ksession.insert(DataBase.getEsquemaOperativo001_20());
		ksession.insert(DataBase.getOT001());
		ksession.insert(DataBase.getParams001());

		ksession.fireAllRules();
		
		System.out.println ("Concepto 830 no evaluado");
		
//		Costeo costeo = (Costeo)ksession.getGlobal(identifierGlobalCosteo);
//
//		assertEquals(3, costeo.getDetalles().size());
//		
//		for (DetalleCosteo detalleCosteo : costeo.getDetalles()) {
//			if (detalleCosteo.getCodigoConcepto()==950) {
//				if (detalleCosteo.getCodigoDescripcion() == 30) {
//					assertEquals("Preço Mensal", detalleCosteo.getDescripcion());
//					assertEquals(1, detalleCosteo.getValor1(), delta);
//					assertEquals(17822.06, detalleCosteo.getValor2(), delta);
//					assertEquals(0, detalleCosteo.getValor3(), delta);
//					assertEquals(17822.06, detalleCosteo.getTotal(), delta);
//				}
//				if (detalleCosteo.getCodigoDescripcion() == 34) {
//					assertEquals("Preço Hora Extra", detalleCosteo.getDescripcion());
//					assertEquals(1, detalleCosteo.getValor1(), delta);
//					assertEquals(42.62, detalleCosteo.getValor2(), delta);
//					assertEquals(0, detalleCosteo.getValor3(), delta);
//					assertEquals(42.62, detalleCosteo.getTotal(), delta);
//				}
//			} else if (detalleCosteo.getCodigoConcepto()==825) {
//				assertEquals("CPMF", detalleCosteo.getDescripcion());
//				assertEquals(25, detalleCosteo.getValor1(), delta);
//				assertEquals(0, detalleCosteo.getValor2(), delta);
//				assertEquals(0, detalleCosteo.getValor3(), delta);
//				assertEquals((17822.06+42.62)*(25/100d), detalleCosteo.getTotal(), delta);				
//			} else {
//				System.out.println ("Concepto " + detalleCosteo.getCodigoConcepto() + " no evaluado");
//			}
//		}
//		
    }
}

