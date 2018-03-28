package unitary.environmentVars;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import unitary.data.DataBase;
import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.costeo.FactEsquemaOperativo;

public class V_divisorhoras extends JUnitBase{
	private final static String rulesFile = "rules/costeo/BRA/environmentVars/v_divisorhoras.gdst";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile, false);
	}
	
	@Test
    public void comprobarAccion() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion" );
		
		FactEsquemaOperativo esquemaOperativo17 = DataBase.getEsquemaOperativo001_17();
		
		ksession.insert(esquemaOperativo17);
		
		ksession.fireAllRules();
		
		assertEquals(20, esquemaOperativo17.getV_divisorhoras(), delta);
    }

	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactEsquemaOperativo esquemaOperativo18 = DataBase.getEsquemaOperativo001_18();
		
		ksession.insert(esquemaOperativo18);
		
		ksession.fireAllRules();
		
		assertEquals(20, esquemaOperativo18.getV_divisorhoras(), delta);
    }	
	
	@Test
    public void comprobarAccion3() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
		
		FactEsquemaOperativo esquemaOperativo20 = DataBase.getEsquemaOperativo001_20();

		ksession.insert(esquemaOperativo20);
		
		ksession.fireAllRules();
		
		assertEquals(null, esquemaOperativo20.getV_divisorhoras());
    }	
	
	@Test
    public void comprobarAccion4() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion4" );
		
		FactEsquemaOperativo esquemaOperativo40 = DataBase.getEsquemaOperativo001_40();

		ksession.insert(esquemaOperativo40);
		
		ksession.fireAllRules();
		
		assertEquals(40, esquemaOperativo40.getV_divisorhoras(), delta);
    }		
	
	@Test
    public void comprobarAccion5() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion5" );
		
		FactEsquemaOperativo esquemaOperativo17 = DataBase.getEsquemaOperativo001_17();
		FactEsquemaOperativo esquemaOperativo18 = DataBase.getEsquemaOperativo001_18();
		FactEsquemaOperativo esquemaOperativo20 = DataBase.getEsquemaOperativo001_20();
		FactEsquemaOperativo esquemaOperativo40 = DataBase.getEsquemaOperativo001_40();

		ksession.insert(esquemaOperativo17);
		ksession.insert(esquemaOperativo18);
		ksession.insert(esquemaOperativo20);
		ksession.insert(esquemaOperativo40);
		
		ksession.fireAllRules();
		
		assertEquals(20, esquemaOperativo17.getV_divisorhoras(), delta);
		assertEquals(20, esquemaOperativo18.getV_divisorhoras(), delta);
		assertEquals(null, esquemaOperativo20.getV_divisorhoras());
		assertEquals(40, esquemaOperativo40.getV_divisorhoras(), delta);
    }		
}

