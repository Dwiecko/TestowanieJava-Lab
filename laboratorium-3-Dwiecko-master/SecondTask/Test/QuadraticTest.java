import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuadraticTest {
	
	private QuadraticFunction quadratic;
	private static BufferedReader reader;
	private String line;
	private final double delta = 0.0000001;
	
	private Boolean readable(String line) {
		if(line.startsWith("#")){
			return false;
		}
		return true;
	}
	
	private double[] getArguments(StringTokenizer stringTokenizer){
		
		double[] arguments = new double[5];
		for(int i = 0; i < 5; i++){
			arguments[i] = Double.valueOf(stringTokenizer.nextToken());
		}
		return arguments; 
	}
	
	@Before
	public void setUp() throws Exception {
		reader = new BufferedReader(new FileReader("Test/dane.txt"));
	}
	
	@After
	public void tearDown() {
		reader = null;
		quadratic = null;
	}
	
	@Test
	public void QuadraticFromFileX1Test() throws Exception {
		while ((line = reader.readLine()) != null) {
			if (!readable(line)){
				continue;
			}
			
			StringTokenizer stringTokenizer = new StringTokenizer(line);
			double[] arguments = getArguments(stringTokenizer);
			quadratic = QuadraticFunction.of(arguments[0], arguments[1], arguments[2]);
			double expected = arguments[3];
			assertEquals(expected, quadratic.getX1(), delta);
		}
	}

	@Test
	public void QuadraticFromFileX2Test() throws Exception {
		while ((line = reader.readLine()) != null) {
			if (!readable(line)){
				continue;
			}
			
			StringTokenizer stringTokenizer = new StringTokenizer(line);
			double[] arguments = getArguments(stringTokenizer);
			quadratic = QuadraticFunction.of(arguments[0], arguments[1], arguments[2]);
			double expected = arguments[4];
			assertEquals(expected, quadratic.getX2(), delta);
		}
	}
	@Test
	public void LinearQuadraticFunctionTest() throws Exception {
		while ((line = reader.readLine()) != null) {
			if (!readable(line)){
				continue;
			}
			
			StringTokenizer stringTokenizer = new StringTokenizer(line);
			double[] arguments = getArguments(stringTokenizer);
			quadratic = QuadraticFunction.of(arguments[0], arguments[1], arguments[2]);
			double expected = arguments[3];
			assertEquals(expected, quadratic.getX1(), delta);
		}
	}
//	@Test(expected = IllegalArgumentException.class)
//	public void catchIllegalArgumentException() throws Exception {
//		while ((line = reader.readLine()) != null) {
//			if (!readable(line)){
//				continue;
//			}
//			
//			StringTokenizer stringTokenizer = new StringTokenizer(line);
//			double[] arguments = getArguments(stringTokenizer);
//			quadratic = QuadraticFunction.of(arguments[0], arguments[1], arguments[2]);
//			double expected = arguments[3];
//			assertEquals(expected, quadratic.getX1(), delta);
//		}
//	}
		
}