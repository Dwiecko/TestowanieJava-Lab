import static org.junit.Assert.*;

import org.junit.Test;

public class SortingTest {
	private Sorting sorting;
	
	@Test(expected=NullPointerException.class)
	public void nullArrayRaisesNullPointerException(){
		int[] array = null;
		sorting = new Sorting(array);
	}
	@Test
	public void testShowArrayMethod(){
		int[] array = {15,22,3,4};
		sorting = new Sorting(array);
		
		sorting.sortArray("R");

		assertEquals("3 4 15 22 ",sorting.showArray()); 
	}
	@Test(expected=IllegalArgumentException.class)
	public void unknownOptionRaisesIllegalArgumentException(){
		int[] array = {15,22,3,4};
		sorting = new Sorting(array);
		
		sorting.sortArray("X");
	}
	@Test
	public void sortEmptyArray(){
		//Arrange
		int[] array = new int[1];
		sorting = new Sorting(array);
		//Act 
		boolean isSorted = sorting.isSorted("R");
		//Assert
		assertTrue(isSorted); 
	}
	@Test
	public void arrayIsSortedInAscendingOrder(){
		//Arrange
		int[] array = {15,22,3,4};
		sorting = new Sorting(array);
		sorting.sortArray("R");
		//Act 
		boolean isSorted = sorting.isSorted("R");
		//Assert
		assertTrue(isSorted); 
	}
	@Test
	public void arrayIsSortedInDescendingOrder(){
		//Arrange
		int[] array = {1,45,3,4,1};
		sorting = new Sorting(array);
		sorting.sortArray("M");
		//Act 
		boolean isSorted = sorting.isSorted("M");
		//Assert
		assertTrue(isSorted); 
	}
	@Test
	public void sortingAscendingOrderArrayInDescendingOrderReturnsFalse(){
		//Arrange
		int[] array = {2,4,3,1,22};
		sorting = new Sorting(array);
		sorting.sortArray("R");
		//Act 
		boolean isSorted = sorting.isSorted("M");
		//Assert
		assertFalse(isSorted); 
	}
	@Test
	public void sortingDescendingOrderArrayInAscendingOrderReturnsFalse(){
		//Arrange
		int[] array = {4,3,2,1};
		sorting = new Sorting(array);
		sorting.sortArray("M");
		//Act 
		boolean isSorted = sorting.isSorted("R");
		//Assert
		assertFalse(isSorted); 
	}
}
