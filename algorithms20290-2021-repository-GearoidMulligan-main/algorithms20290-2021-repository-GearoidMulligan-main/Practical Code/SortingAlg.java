public class SortingAlg {
	//wrote code from scratch

	public static void SelectionSort(int[] a) {
		int count=0;
		int num=0;

		//iterating through array
		for(int i=0;i<a.length-1;i++) {
			int curr=a[i];
			
			for(int j=count;j<a.length;j++) 
				//finding the next smallest number in the array
				if(a[j]<curr) {
					curr=a[j];
					num=j;
				}
			//putting the next smallest number into the correct spot
			a[num]=a[count];
			a[count]=curr;
			count++;
		}
		System.out.print("Sorted Array: ");
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+", ");
		}
	}
	
	public static void InsertionSort(int a[]) {
		   int n = a.length;  
		   System.out.print("Sorted Array: ");
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
	        for(int i=0;i<a.length;i++) {
				System.out.print(a[i]+", ");
			}
	}
	
	 public static void BogoSort(int[] a){

	        // if array is not sorted then shuffle the
	        // array again
	        while (isSorted(a) == false) {
	            shuffle(a);
	        }
	        
	        System.out.print("Sorted Array: ");
	        for(int i=0;i<a.length;i++) {
				System.out.print(a[i]+", ");
			}
	    }
	  
	    // To generate permuatation of the array
	    public static void shuffle(int[] a)
	    {
	        // Math.random() returns a double positive
	        // value, greater than or equal to 0.0 and
	        // less than 1.0.
	        for (int i = 0; i < a.length; i++)
	            swap(a, i, (int)(Math.random() * i));
	    }
	  
	    // Swapping 2 elements
	    public static void swap(int[] a, int i, int j)
	    {
	        int temp = a[i];
	        a[i] = a[j];
	        a[j] = temp;
	    }
	  
	    // To check if array is sorted or not
	    public static boolean isSorted(int[] a)
	    {
	        for (int i = 1; i < a.length; i++)
	            if (a[i] < a[i - 1])
	                return false;
	        return true;
	    }
	
	    //randomly generates an array given a specific array size
	public static int[] GenerateArray(int size) {
		int[] a = new int[size];
		
		for(int i=0;i<size;i++) {
			a[i]=(int) ((Math.random()*(10000-1))+1);
		}
		System.out.print("Random Array: ");
		for(int i=0;i<size;i++) {
			System.out.print(a[i]+", ");
		}
		System.out.println("");
		return a;
	}
	
	public static void main(String []args){
		int[] a = GenerateArray(10);
		Stopwatch timer = new Stopwatch();
		SelectionSort(a);
		System.out.print("\nElapsed Time: "+ timer.elapsedTime());
		
	}
}
