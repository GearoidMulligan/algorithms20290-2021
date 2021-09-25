
public class bruteForceSearch {
	 public static void search(String txt, String pat) 
	    {
	       int n=txt.length();
	       int m=pat.length();
	       //for loop iterates through string
	       for(int pos=0;pos<=n-m;pos++) {
	    	   int j;
	    	   for(j=0;j<m;j++) {
	    		   //runs until pattern doesnt match
	    		   if(txt.charAt(pos+j) != pat.charAt(j)) {
	    			   break;
	    		   }
	    	   }
	    	   //if the length of the pattern is reached i.e pattern was found, print index of pattern
	    		   if(j==m) {
	    			   System.out.println("Desired pattern found "+ "at index " + (pos));//match found
	    			  
	    		   }
	       }
	    	//time complexity: O(nm)
	       //return n
	        } 
	     
	  
	    public static void main(String[] args) 
	    { 
	        //alter to take text file in..
	        String txt = "ABABDABACDABABCABABCDASDSAABABDABACDABABCABABCDASDSAABABDABACDABABCABABCDASDSA"; 
		    String pat = "ABABCABAB"; 
	        search(txt, pat); 
	    } 

}
