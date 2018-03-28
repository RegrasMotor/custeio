package unitary;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;

import unitary.data.DataBase;
import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.costeo.DetalleCosteo;

public class Concepto743_ExamenesMedicosDeTrabajo extends JUnitBase {
	private final static String rulesFile = "rules/costeo/BRA/environmentVars/v_sesmt.gdst;" +
											"rules/costeo/BRA/nivelCosteo.drl;" + 
											"rules/costeo/BRA/Concepto 743 - Examenes medicos de trabajo.drl";
	
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
		
		Collection<DetalleCosteo> detallesCosteo = getDetallesCosteo();
		
		assertEquals(1, detallesCosteo.size());
		
		for (DetalleCosteo detalleCosteo : detallesCosteo) {
			if (detalleCosteo.getCodigoConcepto()==743) {
				
					assertEquals("Valor SESMT", detalleCosteo.getDescripcion());
					assertEquals(12, detalleCosteo.getValor1(), delta);
					assertEquals(40, detalleCosteo.getValor2(), delta);
					assertEquals(0.0, detalleCosteo.getValor3(), delta);
					assertEquals(40*12, detalleCosteo.getTotal(), delta);
				
			} else {
				System.out.println ("Concepto " + detalleCosteo.getCodigoConcepto() + " no evaluado");
			}
		}
    }
}

