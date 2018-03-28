package unitary;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;

import unitary.data.DataBase;
import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.costeo.DetalleCosteo;

public class Concepto9001_VentaTotal extends JUnitBase {
	private final static String rulesFile = "rules/costeo/BRA/nivelCosteo.drl;" + 
											"rules/costeo/BRA/Concepto 950 - ReceitaBruta.drl;"+
											"rules/costeo/BRA/Concepto 9001 - Venta total.drl";
	
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

		ksession.fireAllRules();
		
		Collection<DetalleCosteo> detallesCosteo = getDetallesCosteo();
		
		assertEquals(3, detallesCosteo.size());
		
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
			} else if (detalleCosteo.getCodigoConcepto()==9001) {
				assertEquals("Receita Bruta", detalleCosteo.getDescripcion());
				assertEquals(0, detalleCosteo.getValor1(), delta);
				assertEquals(0, detalleCosteo.getValor2(), delta);
				assertEquals(0, detalleCosteo.getValor3(), delta);
				assertEquals(17822.06+42.62, detalleCosteo.getTotal(), delta);				
			} else {
				System.out.println ("Concepto " + detalleCosteo.getCodigoConcepto() + " no evaluado");
			}
		}
		
    }
}

