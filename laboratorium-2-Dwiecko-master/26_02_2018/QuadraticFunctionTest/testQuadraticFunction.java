import static org.junit.Assert.*;
import org.junit.Test;

public class testQuadraticFunction {

	private QuadraticFunction quadratic;

	@Test (expected = IllegalArgumentException.class)
	public void testThatFirstArgumentRaisesException() {
		quadratic = new QuadraticFunction(0.0,0.0,0.0);
	}
	@Test
	public void firstArgumentIsEqualToGivenNumber() {
		quadratic = new QuadraticFunction(1.0,0.0,0.0);
		assertEquals(1.0, quadratic.getA());
	}
	
	@Test
	public void secondArgumentIsEqualToGivenNumber() {
		quadratic = new QuadraticFunction(1.0,1.0,1.0);
		assertEquals(1.0, quadratic.getB());
	}
	
	@Test
	public void calculatesProperDelta() {
		quadratic = new QuadraticFunction(1.0,12.0,36.0);
		assertEquals(1.0, quadratic.getX1());
	}
	

}
