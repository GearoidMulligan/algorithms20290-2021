public class InsertionSort {

	public static void insertionSort(int a[]) {
		   int n = a.length;  

		   //iterating through array
	        for (int j = 1; j < n; j++) {  
	            int key = a[j];  
	            int i = j-1;  
	            //Move elements  that are greater than key, to one position ahead of their current position 
	            while ( (i > -1) && ( a [i] > key ) ) {  
	                a [i+1] = a [i];  
	                i--;  
	            }  
	            a[i+1] = key;  
	        }  

	}
}
