package unitary;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;

import unitary.data.DataBase;
import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.costeo.DetalleCosteo;

public class Concepto610_inicializarMediosAuxiliares extends JUnitBase {
	private final static String rulesFile = "rules/costeo/BRA/nivelCosteo.drl;" + 
											"rules/costeo/BRA/Concepto 610 - Inicializar medios auxiliares.drl";
	
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
		ksession.insert(DataBase.getMedioAuxiliar000288());
		ksession.insert(DataBase.getMedioAuxiliar000029());
		ksession.insert(DataBase.getMedioAuxiliar000093());
		
		ksession.fireAllRules();
		
		Collection<DetalleCosteo> detallesCosteo = getDetallesCosteo();
		
		assertEquals(3, detallesCosteo.size());
		
		for (DetalleCosteo detalleCosteo : detallesCosteo) {
			if (detalleCosteo.getCodigoConcepto()==610) {
				if (detalleCosteo.getCodigoAgrupacion1().equals("000288")) {
					assertEquals("COFRE AÇO C FEC ELET C AUDITORIA N SECURITY-M H33", detalleCosteo.getDescripcion());
					assertEquals(1, detalleCosteo.getValor1(), delta);
					assertEquals(4.8, detalleCosteo.getValor2(), delta);
					assertEquals(0.0, detalleCosteo.getValor3(), delta);
					assertEquals(1*4.8, detalleCosteo.getTotal(), delta);
				} else if (detalleCosteo.getCodigoAgrupacion1().equals("000093")) {
					assertEquals("CREME (PROTETOR SOLAR) LUVEX - FATOR 58", detalleCosteo.getDescripcion());
					assertEquals(4, detalleCosteo.getValor1(), delta);
					assertEquals(13, detalleCosteo.getValor2(), delta);
					assertEquals(0.0, detalleCosteo.getValor3(), delta);
					assertEquals(4*13, detalleCosteo.getTotal(), delta);
				} else if (detalleCosteo.getCodigoAgrupacion1().equals("000029")) {
					assertEquals("CAPA DE CHUVA PVC FORRADA PRETA", detalleCosteo.getDescripcion());
					assertEquals(2, detalleCosteo.getValor1(), delta);
					assertEquals(0.91, detalleCosteo.getValor2(), delta);
					assertEquals(0.0, detalleCosteo.getValor3(), delta);
					assertEquals(2*0.91, detalleCosteo.getTotal(), delta);
				} else {
					System.out.println ("Par agrupacion ("+detalleCosteo.getCodigoAgrupacion1()+"/"+detalleCosteo.getCodigoAgrupacion2()+") no evaluado");
				}
			} else {
				System.out.println ("Concepto " + detalleCosteo.getCodigoConcepto() + " no evaluado");
			}
		}
    }
}

