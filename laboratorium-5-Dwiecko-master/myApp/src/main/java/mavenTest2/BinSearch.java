package mavenTest2;

public class BinSearch {

	 public int BinarySearch2(int[] array, int value){       
	int low = 0;
	int highest = array.length - 1;
    
    while (low <= highest)
    {
        int midpoint = low + (highest - low)/2;

        if (value == array[midpoint])
        {                    
            return midpoint;
        }
        else if (value < array[midpoint])
			highest = midpoint - 1;
        else
            low = midpoint + 1;
    }

    return -1;
	}
}
