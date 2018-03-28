package unitary;

/*
 * Pruebas que hay que rehacer, no válidas. A espera de acumuladores. 
 * Únicamente usada para ver que compila
 */

//import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;
//import unitary.data.DataBase;

//import com.prosegur.rulesEngine.costeo.model.factsmodel.Costeo;
//import com.prosegur.rulesEngine.costeo.model.factsmodel.DetalleCosteo;
//import com.prosegur.rulesEngine.costeo.model.factsmodel.GestionCosteo;

public class Concepto417_PremioVacaciones extends JUnitBase {
	private final static String rulesFile = "rules/costeo/BRA/environmentVars/p_premio_ferias.gdst;" +
											"rules/costeo/BRA/environmentVars/p_premio_indeni.gdst;" +
											"rules/costeo/BRA/nivelCosteo.drl;" + 
											"rules/costeo/BRA/Concepto 417 - Premio de Vacaciones.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);
	}
	
	@Test
    public void comprobarAccion() {
		
		System.out.println ("Concepto 417 no evaluado");
//		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion" );
//		
//		ksession.insert(DataBase.getTipoPuesto_VD());
//		ksession.insert(DataBase.getTipoPuesto_INV1());
//		ksession.insert(DataBase.getCategoriaSalarial_SVIG_MG());
//		ksession.insert(DataBase.getEsquemaOperativo001_17());
//		ksession.insert(DataBase.getEsquemaOperativo001_18());
//		ksession.insert(DataBase.getEsquemaOperativo001_20());
//		
//		ksession.fireAllRules();
//		
//		Costeo costeo = (Costeo)ksession.getGlobal(identifierGlobalCosteo);
//
//		assertEquals(1, costeo.getDetalles().size());
//		
//		for (DetalleCosteo detalleCosteo : costeo.getDetalles()) {
//			if (detalleCosteo.getCodigoConcepto()==311) {
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

