public class Practical3{

static int fibonacciIterative(int n){
	
  if (n<=1) {
      return 1; 
  }

  //ints for previous and current number
  int fib = 1;
  int prevFib =  1;
//i starts at 2 as 1st and 2nd numbers in fib is 1 and 1
  for (int i = 2; i < n; i++) {
   int temp = fib;
   fib = fib + prevFib;
   prevFib = temp;
  }
  return fib;
 }


static int  fibonacciRecursive(int n){
	//base case
	if(n==0) {
		return 0;
	}
	//second base case
	if(n==1) {
		return 1;
	}
	//recursive case
	else {
		return fibonacciRecursive(n-1)+fibonacciRecursive(n-2);
	}
}

static void towersOfHanoi(int disk, char source, char dest, char auxiliary){
	if (disk==0){
		System.out.println("move "+disk+" from "+ source+" to "+dest);
	}
	else {
		towersOfHanoi(disk-1,source,auxiliary,dest);
		System.out.println("move "+disk+" from "+ source+" to "+dest);
		towersOfHanoi(disk-1,auxiliary,dest,source);
	}
	
}

 public static void main (String args[]) 
    { 
    //int n = 45; 
    //Stopwatch timer = new Stopwatch();
    //System.out.println(fibonacciRecursive(n)+"\nElapsed Time: "+ timer.elapsedTime()); 
    //System.out.println(fibonacciIterative(n)+"\nElapsed Time: "+ timer.elapsedTime()); 
    towersOfHanoi(3,'A','B','C');
    } 
 }