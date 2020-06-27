import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import FirstTask.NWW;

public class NWWtest {
	private NWW nww;
	
	//Arrange
	@Before
	public void setUp(){
		nww = new NWW();
	}

	@Test
	public void NWWreturnsExpectedResult(){
		int result = nww.nww(4, 2);
		
		assertEquals(4,result);
	}

	@Test(expected=java.lang.ArithmeticException.class)
	public void NWWreturnsArithmeticExceptionAfterDividingByZero() {
		nww.nww(1, 0);
	}
}
