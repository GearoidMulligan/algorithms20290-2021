import java.util.Random;

public class Quicksort {
	
	private static int CUTOFF =10;
	
	public static void quickSort(int array[],int start,int end) {
		//base case for this recursive function
		if(start<end) {
			 /* piv is the partitioning index */
			int piv=partition(array, start,end);
			// sort before piv
			quickSort(array,start,piv-1);
			// sort after piv
			quickSort(array,piv+1,end);
		}
	}

	public static int partition(int array[], int start,int end) {
		//pivot (element to be placed the correct position)
		int pivot=array[end];
		int pi=start;
		
		//if array is less than pivot, swap places
		for(int i=start;i<=end-1;i++) {
			if(array[i]<=pivot) {
				int tmp=array[pi];
				array[pi]=array[i];
				array[i]=tmp;
				pi++;
			}
		}
		int tmp=array[pi];
		array[pi]=array[end];
		array[end]=tmp;
		
		return pi;
	}
	
	public static int[] GenerateArray(int size) {
		int[] a = new int[size];
		
		for(int i=0;i<size;i++) {
			a[i]=(int) ((Math.random()*(10000000-1))+1);
		}
		
		return a;
	}
	
	static void printArray(int a[])
    {
        for (int i = 0; i < a.length; ++i)
            System.out.print(a[i] + " ");
        System.out.println();
    }
	
	public static void enhancedQuickSort(int array[],int start,int end) {
		//use insertion sort for small values of n
		if(end<=(start+CUTOFF)) {
			InsertionSort.insertionSort(array);
			return;
		}
		//use median of 3 values to get a more balanced median 
		int median=medianOf(array,start,start+(end-start)/2,end);
		
		//swap median with start
		int tmp= array[start];
		array[start]=median;
		array[start+(end-start)/2]=tmp;
		
		if(start<end) {
			int piv=partition(array, start,end);
			// sort before piv
			quickSort(array,start,piv-1);
			// sort after piv
			quickSort(array,piv+1,end);
		}
	}
	
	static void shuffleArray(int[] ar)
	  {
	   
	    Random rnd = new Random();
	    for (int i = ar.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      int a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	    }
	  }
	
	public static int medianOf(int[] arr, int start,int mid, int end) {
		int[] array= {arr[start],arr[mid], arr[end]};
		InsertionSort.insertionSort(array);
		return array[1];
		
	}
	
	public static void main (String args[]) {
		int[] arr = GenerateArray(10000000);
		//shuffleArray(arr);
		System.out.println("Given Array");
        //printArray(arr);
        Stopwatch timer = new Stopwatch();
		quickSort(arr,0,arr.length-1);
        //enhancedQuickSort(arr,0,arr.length-1);
		System.out.println("\nElapsed Time: "+ timer.elapsedTime());
		System.out.println("\nSorted array");
        //printArray(arr);
	}
}
