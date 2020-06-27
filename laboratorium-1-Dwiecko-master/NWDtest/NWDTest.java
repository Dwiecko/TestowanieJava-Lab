import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import FirstTask.NWD;

public class NWDTest {
	private NWD nwd;
	
	@Before
	public void setUp(){
		nwd = new NWD();
	}
	
	@Test
	public void NWDreturnsExpectedPositiveValue() {
		int result = nwd.nwd(4, 2);
		assertEquals(2,result);
	}
	
	@Test
	public void NWDreturnsExpectedValueCombinedWithNegativeAndPositiveNumbers() {
		int result = nwd.nwd(-1, 2);
		assertEquals(-1,result);
	}
	@Test
	public void NWDreturnsExpectedValueCombinedWithTwoNegativeNumbers() {
		int result = nwd.nwd(-1, -2);
		assertEquals(-1,result);
	}
}
