package unitary;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;

import unitary.data.DataBase;
import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.costeo.DetalleCosteo;

public class Concepto810_ISS extends JUnitBase {
	private final static String rulesFile = "rules/costeo/BRA/environmentVars/p_iss.gdst;"+
											"rules/costeo/BRA/functions/ventaTeorica.function;"+
											"rules/costeo/BRA/nivelCosteo.drl;" + 
											"rules/costeo/BRA/Concepto 950 - ReceitaBruta.drl;"+
											"rules/costeo/BRA/Concepto 810 - ISS.drl";
	
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
		
		Collection<DetalleCosteo> detallesCosteo = getDetallesCosteo();
		
		assertEquals(4, detallesCosteo.size());
		
		for (DetalleCosteo detalleCosteo : detallesCosteo) {
			if (detalleCosteo.getCodigoConcepto()==950) {
				if (detalleCosteo.getCodigoAgrupacion1().equals("30")) {
					assertEquals("Preço Mensal", detalleCosteo.getDescripcion());
					assertEquals(1, detalleCosteo.getValor1(), delta);
					assertEquals(17822.06, detalleCosteo.getValor2(), delta);
					assertEquals(0, detalleCosteo.getValor3(), delta);
					assertEquals(17822.06, detalleCosteo.getTotal(), delta);
				}
				if (detalleCosteo.getCodigoAgrupacion1().equals("34")) {
					assertEquals("Preço Hora Extra", detalleCosteo.getDescripcion());
					assertEquals(1, detalleCosteo.getValor1(), delta);
					assertEquals(42.62, detalleCosteo.getValor2(), delta);
					assertEquals(0, detalleCosteo.getValor3(), delta);
					assertEquals(42.62, detalleCosteo.getTotal(), delta);
				}
			} else if (detalleCosteo.getCodigoConcepto()==810 && detalleCosteo.getDescripcion().equals("ISS")) {
				assertEquals("ISS", detalleCosteo.getDescripcion());
				assertEquals(14, detalleCosteo.getValor1(), delta);
				assertEquals(0, detalleCosteo.getValor2(), delta);
				assertEquals(0, detalleCosteo.getValor3(), delta);
				assertEquals((17822.06+42.62)*(14/100d), detalleCosteo.getTotal(), delta);				
			} else {
				System.out.println ("Concepto " + detalleCosteo.getCodigoConcepto() + " (" + detalleCosteo.getDescripcion() + ") no evaluado");
			}
		}
		
    }
}

