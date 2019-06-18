package string;

public class poweroftwo {

	public static void main(String[] args) {
		System.out.println(new poweroftwo().multipleBytwo("512"));
	}
	
	 public int power(String A) {
		 
		 String start = "1";
		 int i = 0;
		 while(start.length() <= A.length()) {
			 if(start.equalsIgnoreCase(A)) {
				 return i;
			 }
			 start = multipleBytwo(start);
			 System.out.println(start);
			 i++;
		 }
		 
		 return i;
	    }
	 
	 
	 public String multipleBytwo(String a) {
		 int carry = 0;
		 StringBuilder result = new StringBuilder();
		 for(int i = a.length()-1; i>= 0; i--) {
			 Integer x = Integer.parseInt(String.valueOf(a.charAt(i)));
			 int temp = x* 2 + carry;
			 
			 if(temp >= 10) {
				 carry = temp/10;
			 }else {
				 carry =0;
			 }
			 
			 result.append(temp%10);
		 }
		 
		 if(carry != 0) {
			 result.append(carry);
		 }
		 return result.reverse().toString();
	 }
	 
	 
	
	    
}
