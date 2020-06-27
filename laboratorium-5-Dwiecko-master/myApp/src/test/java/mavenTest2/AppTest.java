package mavenTest2;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest 
{
    private BinSearch binSearch;

    @BeforeEach
    public void BuildUp(){
        binSearch = new BinSearch();
    }

    @Test
    void testThatIndexIsCorrectForGivenArray() {
        int[] myList = {1, 2, 30, 3};
        int isEqualToIndex = binSearch.BinarySearch2(myList, 30);
        assertEquals(2, isEqualToIndex);
    }

    @Test
    void testPositiveAndNegativeNumbers() {
        int[] myList = {-2, -1, 0, 1};
        int isEqualToIndex = binSearch.BinarySearch2(myList, 0);
        assertEquals(2, isEqualToIndex);
    }


    @Test
    void testNegativeNumbers() {
        int[] myList = {-2, -1, -3, -5};
        int isEqualToIndex = binSearch.BinarySearch2(myList, -1);
        assertEquals(1, isEqualToIndex);
    }

    @Test
    void testEmptyArray() {
        int[] myList = new int[]{};
        int isEqualToIndex = binSearch.BinarySearch2(myList, -1);
        assertEquals(-1, isEqualToIndex);
    }


    // @Test
    // void testThatIndexIsNotCorrectForGivenArray() {
    //     int[] myList = {1, 2, 3, 3};
    //     int index = binSearch.BinarySearch2(myList, 3);
    //     assertTrue(index != 1);
    // }
   
//    @AfterAll
//    public void tearDownAll(){
//        binSearch = null;
//    }

}
