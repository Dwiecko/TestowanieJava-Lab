import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
// Last element in an array is a solution. 
// Largest.java finds largest element in an array from 0..N-1 elements
// Tested in JUnit 4
@RunWith(Parameterized.class)
public class tableTest {
	//Use of parameterized table
	@Parameters
    public static int[][] data() {
        int[][] c = 
        	{{4000,6,20, 20, 1, 2000, 4000}, 
        	{100,1, 50, 1000, 2000, 50, 2000}};
        return  c;
    }
	
	//Get elements row by row
    @Parameter
    public int[] valuesFromTable;
	
	@Test
	public void findLargestInATable() {
		int expectedMax = valuesFromTable[valuesFromTable.length-1];
		int max = Largest.largest(valuesFromTable);
		
		assertEquals(max, expectedMax);
	}
}
