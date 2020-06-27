//DAWID WIECKO GR 2 
//Eclipse: Run As -> Gradle Test
import static org.assertj.core.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;


public class CalculatorTest {

	private Calculator calc;
	
	@Before
	public void setUp(){
		calc = new Calculator();
	}
	@Test
	public void StringIsNotEmpty() {
		String number = calc.add(3, -2) + "";
		assertThat(number).asString().isNotEmpty();
	}
	
	@Test
	public void TestAdd() {
		String number = calc.add(3, -2) + " ";
		assertThat(number).contains("1");
	}
	@Test
	public void ValuesAreNotNullable() {
		assertThat(calc.sub(3, 1)).hasNoNullFieldsOrProperties();
	}
	@Test
	public void GivenResultContainsOnlyDigits() {
		String text =  "" + calc.sub(3, 1);
		assertThat(text).containsOnlyDigits();
	}
	@Test
	public void TestSub() {
		String text = "" + calc.sub(19, 9);
		assertThat(text).contains("0");
	}
	@Test
	public void TestLessThanZero() {
		assertThat(calc.sub(10, 100)).isLessThan(0);
	}
	@Test
	public void TestMultiply() {
		assertThat(calc.multi(-2, -4)).isEqualTo(8);
	}
	@Test
	public void FieldIsInstanceOfACalculatorClass() {
		assertThat((Integer)calc.multi(-2, -4)).isInstanceOf(Integer.class);
	}
	
	@Test
	public void TestGreater() {
		assertThat(calc.greater(-6, -3)).isFalse();
	}
	
	@Test
	public void testLess() {
		assertThat(calc.less(-100, -3)).isTrue();
	}
	
	@Test
	public void testEquality() {
		assertThat(calc.equality(2, 1)).isEqualTo(false);
	}
	
	@Test
	public void returnsArithmeticExceptionAfterDividingByZero(){
		Throwable thrown = catchThrowable(() -> {
			calc.div(2, 0);
		});
		
		assertThat(thrown)
		  .isInstanceOf(ArithmeticException.class)
		  .hasMessageContaining("/ by zero");
	}
}