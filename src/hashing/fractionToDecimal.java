package hashing;

import java.util.HashMap;

public class fractionToDecimal {

	public static void main(String[] args) {
		System.out.println(new fractionToDecimal().fractionToDecimal(0, 1));
		
		
	//	1 999   0.(001)
		//1 45 0.0(2)
		
		
	}
	
	  public String fractionToDecimal(int A0, int B0) {
		  
		  if(A0==0) {
			  return "0";
		  }
		  
		  
		  boolean isNagative = false;
		  
		  if((A0 < 0 && B0 >= 0 ) || (B0 < 0 && A0 >= 0)) {
			  isNagative = true;
		  }
		  
		  long A = Math.abs((long)A0);
		  long B = Math.abs((long)B0);
		  
		  
		  
		  HashMap<Integer, Integer> visited = new HashMap<>();
		  
		  boolean isDecimalStarted = false;
		  
		  StringBuilder result = new StringBuilder();
		  while(true) {
			  if(A < B && !isDecimalStarted) {
				  isDecimalStarted = true;
				  if(result.length() == 0) {
					  result.append("0");
				  }
				  result.append(".");
				  A = A * 10;
			  }
			 
			  else {
				  if(!isDecimalStarted) {
					  result.append(A/B);
					  System.out.println(result);

					  A = A%B;
				  }else {
					  long no = A/B;
					  
					  if(visited.containsKey((int)(A))) {
						  
						  result.append(")");
//						  System.out.println(result);
						  result.replace(visited.get((int)(A))-1, visited.get((int)(A)), "("+ no);
						  break;
						  
					  }else {
						  result.append(no);
//						  System.out.println(result);
						  visited.put((int)A, result.length());
						  A = A%B;
					  }
					  A = A* 10;
					  
				  }
				  
				  if(A == 0) {
					  break;
				  }
			  }
		  }
		  
		  return isNagative ? "-"+result.toString() : result.toString();
		  
	    }
}
