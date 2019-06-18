package hashing;

import java.util.ArrayList;
import java.util.List;

import algo.Utilities;

public class substringconcat {

	public static void main(String[] args) {
		String a="bcabbcaabbccacacbabccacaababcbb";
		
		ArrayList<String> list = Utilities.toList(new String[] { 
				 "c", "b", "a", "c", "a", "a", "a", "b", "c"});
		
		new substringconcat().findSubstring(a, list);
		
		System.out.println(new substringconcat().hasCodeString("ab"));
		System.out.println(new substringconcat().hasCodeString("ba"));
	}
	
	 public ArrayList<Integer> findSubstring(String A, final List<String> B) {
	        
		 int length = B.get(0).length() * B.size();
		 int hasCode = hasCode(B);
		 
		 int x =0;
		 ArrayList<Integer> result = new ArrayList<>();
		 while(x+ length < A.length()) {
			 int has=0;
			 for(int y=0;y < B.size();y++) {
			 String subStr = A.substring(x+(y*B.get(0).length()), x+ (y*B.get(0).length() + B.get(0).length()));
			  has += hasCodeString(subStr);
			 System.out.println(subStr + " "+ has);
			 }
			 if(has == hasCode) {
				 System.out.println("yes"+ " "+ A.substring(x, x+length));
				 result.add(x);
			 }
			 x++;
		 }
		 
		 return result;
	        
	    }
	 
	 public int hasCode(final List<String> B) {
		 
		int hasCode = 0;
		
		for(String s: B) {
			hasCode+= hasCodeString(s);
			 System.out.println(hasCode + " "+ s);
		}
		return hasCode;
		 
	 }
	 
	 public int hasCodeString(String s) {
		 int hasSum=0;
			int hasMul=1;
			for(int i =0; i< s.length() ; i++) {
				char c = s.charAt(i);
				
				hasSum += (c-'A') + (i+1);
				hasMul *= (c-'A') + (i+1);
				
			}
			
			 return hasMul * hasSum * s.hashCode();
	 }
}
