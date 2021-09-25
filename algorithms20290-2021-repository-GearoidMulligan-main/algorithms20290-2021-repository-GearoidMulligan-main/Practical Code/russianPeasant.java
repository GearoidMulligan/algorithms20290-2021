import java.math.BigInteger;  

public class russianPeasant {
	
	//used for smaller numbers up to 64 bits
	public static long RP (long a,long b) {
		long res =0;
		
		while(b >0) {
			//while b is more than 0..
			if(b%2 != 0) {
				//if b is odd then the result is added
				res=res+a;
			}
			//a is doubled and b is halved
			a=a*2;
			b=b/2;
		}
		return res;
	}
	
	//used for larger numbers
	public static BigInteger RPbigInt (BigInteger a,BigInteger b) {
		//same basis as the method above just manipulated to accept BigInteger numbers
		BigInteger res = BigInteger.valueOf(0);
		
		while(b.compareTo(BigInteger.valueOf(0)) >0) {
			if(b.remainder(BigInteger.valueOf(2)) != (BigInteger.valueOf(0))) {
				res=res.add(a);
			}
			a=a.multiply(BigInteger.valueOf(2));
			b=b.divide(BigInteger.valueOf(2));
		}
		return res;
	}

	
	 public static void main(String[] args) {

		// long a =9223372036854775807L;
		 //long b=77580L;

		  String input1 
          = "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"; 
      String input2 
          = "2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222"; 

      // Convert the string input to BigInteger 
      BigInteger a 
          = new BigInteger(input1); 
      BigInteger b 
          = new BigInteger(input2); 
		 
		 Stopwatch timer = new Stopwatch();
		 //long total= RP(a,b);
		 BigInteger total=RPbigInt(a,b);
		 
		 System.out.print(total);
		 System.out.print("\nElapsed Time: "+ timer.elapsedTime());
	 }

}
