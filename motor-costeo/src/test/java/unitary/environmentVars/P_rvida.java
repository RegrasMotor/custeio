package unitary.environmentVars;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import unitary.data.DataBase;
import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.costeo.FactEsquemaOperativo;

public class P_rvida extends JUnitBase{
	private final static String rulesFile = "rules/costeo/BRA/environmentVars/p_rvida.gdst";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile, false);
	}
	
	@Test
    public void comprobarAccion() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion" );
		
		FactEsquemaOperativo esquemaOperativo17 = DataBase.getEsquemaOperativo001_17();
		
		ksession.insert(DataBase.getOT001());
		ksession.insert(esquemaOperativo17);
		
		ksession.fireAllRules();
		
		assertEquals(30, esquemaOperativo17.getP_rvida(), delta);
    }

	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactEsquemaOperativo esquemaOperativo18 = DataBase.getEsquemaOperativo001_18();
		
		ksession.insert(DataBase.getOT001());		
		ksession.insert(esquemaOperativo18);
		
		ksession.fireAllRules();
		
		assertEquals(30, esquemaOperativo18.getP_rvida(), delta);
    }	
	
	@Test
    public void comprobarAccion3() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
		
		FactEsquemaOperativo esquemaOperativo20 = DataBase.getEsquemaOperativo001_20();

		ksession.insert(DataBase.getOT001());	
		ksession.insert(esquemaOperativo20);
		
		ksession.fireAllRules();
		
		assertEquals(50, esquemaOperativo20.getP_rvida(), delta);
    }	
	
	@Test
    public void comprobarAccion4() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion4" );
		
		FactEsquemaOperativo esquemaOperativo17 = DataBase.getEsquemaOperativo001_17();
		FactEsquemaOperativo esquemaOperativo18 = DataBase.getEsquemaOperativo001_18();
		FactEsquemaOperativo esquemaOperativo20 = DataBase.getEsquemaOperativo001_20();

		ksession.insert(DataBase.getOT001());		
		ksession.insert(esquemaOperativo17);
		ksession.insert(esquemaOperativo18);
		ksession.insert(esquemaOperativo20);
		
		ksession.fireAllRules();
		
		assertEquals(30, esquemaOperativo17.getP_rvida(), delta);
		assertEquals(30, esquemaOperativo18.getP_rvida(), delta);
		assertEquals(50, esquemaOperativo20.getP_rvida(), delta);
    }		
}

