package unitary;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;

import unitary.data.DataBase;
import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.costeo.DetalleCosteo;

public class Concepto744_LuchaContraVigilanciaIlegal extends JUnitBase {
	private final static String rulesFile = "rules/costeo/BRA/environmentVars/v_pcvc.gdst;" +
											"rules/costeo/BRA/nivelCosteo.drl;" + 
											"rules/costeo/BRA/Concepto 744 - Lucha contra vigilancia ilegal.drl";
	
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
			if (detalleCosteo.getCodigoConcepto()==744) {
				if (detalleCosteo.getCodigoAgrupacion1().equals("VD") && detalleCosteo.getCodigoAgrupacion2().equals("SVIG - MG")) {
					assertEquals("Combate Vig. Clandestina - SVIG - MG/VD", detalleCosteo.getDescripcion());
					assertEquals(8, detalleCosteo.getValor1(), delta);
					assertEquals(6, detalleCosteo.getValor2(), delta);
					assertEquals(0.0, detalleCosteo.getValor3(), delta);
					assertEquals(8*6, detalleCosteo.getTotal(), delta);
				} else if (detalleCosteo.getCodigoAgrupacion1().equals("IN V1") && detalleCosteo.getCodigoAgrupacion2().equals("SVIG - MG")) {
					assertEquals("Combate Vig. Clandestina - SVIG - MG/IN V1", detalleCosteo.getDescripcion());
					assertEquals(4, detalleCosteo.getValor1(), delta);
					assertEquals(12, detalleCosteo.getValor2(), delta);
					assertEquals(0.0, detalleCosteo.getValor3(), delta);
					assertEquals(4*12, detalleCosteo.getTotal(), delta);
				} else {
					System.out.println ("Par agrupacion ("+detalleCosteo.getCodigoAgrupacion1()+"/"+detalleCosteo.getCodigoAgrupacion2()+") no evaluado");
				}
			} else {
				System.out.println ("Concepto " + detalleCosteo.getCodigoConcepto() + " no evaluado");
			}
		}
    }
}

