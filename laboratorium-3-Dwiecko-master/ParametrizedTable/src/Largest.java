public class Largest {
	
	public static int largest(int[] table) {
		int first = table[0];
		for (int i=0; i<table.length-1; i++) {
			if(first < table[i]) {
				first = table[i];
			}
		}
		
		return first;
	}
	
}