package string;

import java.util.HashMap;

public class romantonumber {

	public static void main(String[] args) {
		
	}
	
	 public String intToRoman(int A) {
	        
	        String result = "";
	        
	        int noOfM = A/1000;
	        
	        for(int i=0;i< noOfM ; i++){
	            result+= "M";
	        }
	        
	        int rest = A%1000;
	        
	        if(rest >= 900) {
	        		result+= "CM";
	        		rest -= 900;
	        }
	        
	        if(rest >= 500) {
	        		result+= "D";
	        		rest-= 500;
	        }
	        
	        if(rest >= 400) {
	        		result+= "CD";
	        		rest-= 400;
	        }
	        
	        int noOfC = rest/100;
	        
	        for(int i=0;i< noOfC; i++){
	            result+= "D";
	        }
	        
	        rest = rest%100;
	        
	        if(rest >= 90) {
	        		result+= "XC";
	        		rest-= 90;
	        }
	        
	        if(rest >= 50) {
	        		result+= "L";
	        		rest-= 50;
	        }
	        
	        if(rest>= 40) {
	        		result+= "XL";
	        		rest-= 40;
	        }
	        
	        int noOfX = rest/10;
	        
	        for(int i=0;i< noOfX; i++){
	            result+= "X";
	        }
	        
	        rest = rest%10;
	        
	        if(rest>= 9) {
	        		result+= "IX";
	        		rest-= 9;
	        }
	        
	        if(rest >= 5) {
	        		result+= "V";
	        		rest-= 5;
	        }
	        
	        if(rest >= 4) {
	        		result+= "IV";
	        		rest-= 4;
	        }
	        
	       
	        
	        for(int i=0;i< rest; i++){
	            result+= "I";
	        }
	        
	        return result;
	        
	        
	       
	    }
	
	 public int romanToInt(String A) {
		 
		HashMap<Character, Integer> mapper = new HashMap<Character, Integer>();
		 
		mapper.put('I', 1);
		mapper.put('V', 5);
		mapper.put('X', 10);
		mapper.put('L', 50);
		mapper.put('C', 100);
		mapper.put('D', 500);
		mapper.put('M', 1000);
		 
		 
		 char c = A.charAt(A.length()-1);
		 int no = mapper.get(c);
		 for(int i = A.length()-2 ; i>= 0; i--) {
			
			 char c1 = A.charAt(i);
			 
			 int noo = mapper.get(c1);
			 
			 if(noo >= mapper.get(c)) {
				 no+= noo;
			 }else {
				 no-= noo;
			 }
			 
			 c = c1;
			 
			 
		 }
		 
		 return no;
		 
	    }
}
