package unitary;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;

import unitary.data.DataBase;
import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.costeo.DetalleCosteo;

public class Concepto540_valeComida extends JUnitBase {
	private final static String rulesFile = "rules/costeo/BRA/environmentVars/v_ValeRefEscala.gdst;" +
											"rules/costeo/BRA/functions/festivosProporcionales.function;"+
											"rules/costeo/BRA/nivelCosteo.drl;" + 
											"rules/costeo/BRA/Concepto 540 - Vale comida.drl";
	
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
		
		assertEquals(2, detallesCosteo.size());
		
		for (DetalleCosteo detalleCosteo : detallesCosteo) {
			if (detalleCosteo.getCodigoConcepto()==540) {
				if (detalleCosteo.getCodigoAgrupacion1().equals("VD") && detalleCosteo.getCodigoAgrupacion2().equals("SVIG - MG")) {
					assertEquals("Vale refeição - Vigilante Patrimonial - VIGILÂNCIA", detalleCosteo.getDescripcion());
					assertEquals(8, detalleCosteo.getValor1(), delta);
					assertEquals(40, detalleCosteo.getValor2(), delta);
					assertEquals(0.0, detalleCosteo.getValor3(), delta);
					assertEquals(8*40, detalleCosteo.getTotal(), delta);
				} else if (detalleCosteo.getCodigoAgrupacion1().equals("IN V1") && detalleCosteo.getCodigoAgrupacion2().equals("SVIG - MG")) {
					assertEquals("Vale refeição - Inspetor Patrimonial 1 - VIGILÂNCIA", detalleCosteo.getDescripcion());
					assertEquals(2, detalleCosteo.getValor1(), delta);
					assertEquals(100, detalleCosteo.getValor2(), delta);
					assertEquals(0.0, detalleCosteo.getValor3(), delta);
					assertEquals(2*100, detalleCosteo.getTotal(), delta);
				} else {
					System.out.println ("Par agrupacion ("+detalleCosteo.getCodigoAgrupacion1()+"/"+detalleCosteo.getCodigoAgrupacion2()+") no evaluado");
				}
			} else {
				System.out.println ("Concepto " + detalleCosteo.getCodigoConcepto() + " no evaluado");
			}
		}
    }
}

