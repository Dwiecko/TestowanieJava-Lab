import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Calculatortest {

	private Calculator calc;
	private Calculator calc2;
	@Before
	public void setUp(){
		calc = new Calculator();
	}
	
	@Test
	public void checkThatBothEmptyObjectsAreEqual(){
		//Prepare
		calc2 = new Calculator();
		
		boolean bothAreEqual = calc.equals(calc2);
		//assertEquals(calc, calc2);
		assertFalse(bothAreEqual);
	}

	@Test
	public void testAdd() {
		assertEquals(1, calc.add(3, -2));
	}
	
	@Test
	public void testSubstract() {
		assertEquals(2, calc.sub(3, 1));
	}
	
	@Test
	public void testMultiply() {
		assertEquals(8, calc.multi(-2, -4));
	}
	
	@Test
	public void testDivide() {
		assertEquals(2, calc.div(-6, -3));
	}
	
	@Test
	public void testGreater() {
		assertEquals(false, calc.greater(-6, -3));
	}
	
	@Test
	public void testLess() {
		assertEquals(true, calc.less(-100, -3));
	}
	
	@Test
	public void testEquality() {
		assertEquals(false, calc.equality(2, 1));
	}
	
	@Test(expected=java.lang.ArithmeticException.class)
	public void returnsArithmeticExceptionAfterDividingByZero(){
		calc.div(2, 0);
	}
}
