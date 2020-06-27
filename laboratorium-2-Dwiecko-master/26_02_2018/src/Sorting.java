public class Sorting {

	private int[] array;
	private int temp = 0;
	
	Sorting(int[] givenArray){
		if(!(givenArray.length == 0) && !(givenArray == null))
			array = givenArray;
	}
	
	public int[] sortArray(String option){
		switch(option){
		 case "R":
			 for(int i=0 ;i<array.length;i++){
				 for(int j=1; j<(array.length); j++ ){
					 if(array[j-1] > array[j]){
						 temp = array[j-1];  
						 array[j-1] = array[j];  
						 array[j] = temp;  
					 }
				 } 
			 }
			 return array;

		 case "M":
			 for(int i=0 ;i<array.length;i++){
				 for(int j=1; j<(array.length); j++ ){
					 if(array[j-1] < array[j]){
						 temp = array[j-1];  
						 array[j-1] = array[j];  
						 array[j] = temp;  
					 }
				 }
			 }
			 return array;
			 			 
			 default:
			 throw new IllegalArgumentException("Given option is unknown!");
		}
	}
	public String showArray(){
		String message = "";
		for(int i=0; i<array.length; i++){
			message += array[i] + " ";
		}
		return message;
	}
	public boolean isSorted(String option){
		switch(option){
		case "R":
			boolean temp = true;
			for (int x=1; x<array.length; x++) { 
			    if (array[x-1] > array[x]) temp = false;
			}
			return temp;
			
		case "M":
			boolean temp2 = true;
			for (int i = 1; i < array.length; i++) { 
			    if (array[i-1] < array[i]) temp2 = false; 
			}
			return temp2;    
		}
		return false;
	}
}
