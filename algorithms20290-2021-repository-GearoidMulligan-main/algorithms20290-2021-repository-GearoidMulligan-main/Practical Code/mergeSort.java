
public class mergeSort {
	
	public static int CUTOFF =10;
	
	public static void merge(int a[], int lo, int mid, int hi) {
    
 
        // Create the two aux arrays 
        int L[] = new int[mid-lo+1];
        int R[] = new int[hi-mid];
 
        //copy the array a to the two aux arrays
        for (int i = 0; i < mid-lo+1; ++i)
            L[i] = a[lo + i];
        for (int j = 0; j < hi-mid; ++j)
            R[j] = a[mid + 1 + j];
 
        //merge back to a[]
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = lo;
        //while loop to merge into a[]
        while (i < mid-lo+1 && j < hi-mid) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            }
            else {
                a[k] = R[j];
                j++;
            }
            k++;
        }
        
     // Copy remaining elements of L[] if any
        while (i < mid-lo+1) {
            a[k] = L[i];
            i++;
            k++;
        }
 
        // Copy remaining elements of R[] if any 
        while (j < hi-mid) {
            a[k] = R[j];
            j++;
            k++;
        }
	}
	
	public static void sort(int a[], int l, int r) {
		if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
 
            // Sort first and second halves
            sort(a, l, m);
            sort(a, m + 1, r);
 
            // Merge the sorted halves
            merge(a, l, m, r);
        }
	
	}
	
	public static void improvedSort(int a[], int l, int r) {
		
		if(r<=l+CUTOFF-1) {
			InsertionSort.insertionSort(a);
			return;
		}
		if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
 
            // Sort first and second halves
            sort(a, l, m);
            sort(a, m + 1, r);
            
            if(a[m+1]<a[m]) {
            	return;
            }
            else {
 
            // Merge the sorted halves
            merge(a, l, m, r);
            }
        }
	
	}
	
	public static int[] GenerateArray(int size) {
		int[] a = new int[size];
		
		for(int i=0;i<size;i++) {
			a[i]=(int) ((Math.random()*(1000000-1))+1);
		}
		
		return a;
	}
	
	static void printArray(int a[])
    {
        for (int i = 0; i < a.length; ++i)
            System.out.print(a[i] + " ");
        System.out.println();
    }

	public static void main(String[] args) {
		int[] arr = GenerateArray(1000);
		
		System.out.println("Given Array");
        printArray(arr);
        Stopwatch timer = new Stopwatch();
		improvedSort(arr,0,arr.length-1);
		System.out.println("\nElapsed Time: "+ timer.elapsedTime());
		System.out.println("\nSorted array");
        printArray(arr);

	}

}
