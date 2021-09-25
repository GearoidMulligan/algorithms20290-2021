public class RLE {

	public static String rle(String str) {
		//shortened string initialisation 
		String s= new String();
		int j=1;
		//for loop iterating through array
		for(int i=1;i<str.length();i++) {
			//count how many times the same letter appears
			if(str.charAt(i)==str.charAt(i-1)) {
				j++;
			}else {
				//if only 1 then don't add number
				if(j==1) {
					s=s+str.charAt(i-1);
				}
				else{
				//add letter and number
				s=s+str.charAt(i-1)+j;
				//j back to 1
				j=1;
				}
			}
		}
		//adding last element
		if(j==1) {
			s=s+str.charAt(str.length()-1);
		}
		else{
		s=s+str.charAt(str.length()-1)+j;
		j=1;
		}
		return s;
	}
	
	 public static void main(String args[]) {
		 String str="aaaabbbbbccdcdddddddddddddddddddddddd    eeeeeeeeeeeeeesssssssssssssssssssssssddddddddddddeeeeeee          ";
		 
		 System.out.print(rle(str));
	 }
}
