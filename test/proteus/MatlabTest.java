/**
 * @author Anuradha Vakil
 * @author Nikos Arechiga
 * Toyota InfoTechnology Center, USA
 * 465 N Bernardo Ave, Mountain View, CA 94043
 */
package proteus;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import matlab.syntax.*;

public class MatlabTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		testMatlab();	
	}
	
	public void testMatlab(){
		String s = " Kp = 5; Kd =10; acceleration = ((Kp*distance) - (Kd*velocity) + (Ki*z)); znext = z + distance;if ( znext > 0 ) Kp = Kp - 2;else Kp = Kp + 2;end";
		MatlabProgram mp = MatlabProgram.parse(s);
//		List<Statement> st = mp.getStatements();
		
//		System.out.println("st.get(0)  "+st.get(0));
//		System.out.println("st.get(1)  "+st.get(1));
	}

	
}
