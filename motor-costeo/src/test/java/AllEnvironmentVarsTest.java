import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import unitary.environmentVars.P_ad_nocturno;
import unitary.environmentVars.P_rvida;
import unitary.environmentVars.V_divisorhoras;
import unitary.environmentVars.V_taser;

// specify a runner class: Suite.class
@RunWith(Suite.class)

// specify an array of test classes
@Suite.SuiteClasses({
//	C_arvanoturno.class,
	P_ad_nocturno.class,
	P_rvida.class,
	V_divisorhoras.class,
	V_taser.class}
)

// the actual class is empty
public class AllEnvironmentVarsTest {
}