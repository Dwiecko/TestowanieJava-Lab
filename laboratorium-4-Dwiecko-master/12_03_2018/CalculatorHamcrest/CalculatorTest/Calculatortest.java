import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.RepeatedTest;
//import org.junit.jupiter.api.Test;

public class Calculatortest {

	private Calculator calc;
	
	@Before
	public void setUp(){
		calc = new Calculator();
	}
	
	@Test
	public void testAdd() {
		assertThat(calc.add(3, -2), is(1));
	}
	
	@Test
	public void testSubstract() {
		assertThat(calc.sub(3, 1), equalTo(2));
	}
	
	@Test
	public void testMultiply() {
		//assertEquals(8, calc.multi(-2, -4));
		assertThat(calc.multi(-2, -4), is(not(equalTo(-8))));
	}
	@Test
	public void testValueIsNotNullable() {
		//assertEquals(8, calc.multi(-2, -4))
		assertThat(calc.multi(-2, -4), is(not(nullValue())));
	}
	
	@Test
	public void testDivide() {
		String value = "" + calc.div(100, 5);
		assertThat(value, endsWith("0"));
	}
	
	@Test
	public void testGreater() {
		assertThat(calc.greater(-6, -3), is(false));
	}
	
	@Test
	public void testLess() {
		assertThat(calc.less(-100, -3), is(true));
	}
	
	@Test
	public void testEquality() {
		assertThat(calc.equality(2, 1), is(false));
	}
	
	@Test(expected=java.lang.ArithmeticException.class)
	public void returnsArithmeticExceptionAfterDividingByZero(){
		calc.div(2, 0);
	}
}
