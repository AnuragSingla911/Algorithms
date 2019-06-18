package dp;

import java.util.HashMap;

public class waystodecode {

	public static void main(String[] args) {
		
		System.out.println(new waystodecode().numDecodings("3"));
	}
	
	 public int numDecodings(String A) {
		 for(int i = A.length()-1 ; i > 0; i--) {
			 if(A.charAt(i) == '0' && (A.charAt(i-1) > '2' || A.charAt(i-1) < '1')) {
				 return 0;
			 }
		 }
		 return find(A, 0);
	    }
	 
	 HashMap<Integer,Integer> mem = new HashMap<>();
	 
	 private int find(String current, int offset) {
		 
		 
		 
		 if(current == null || current.length() < 1) {
			 return 0;
		 }
		 
		 if(mem.containsKey(offset)) {
			 return mem.get(offset);
		 }
		 
		 if(offset > current.length()) {
			 return 0;
		 }
		 
		 if(offset == current.length()-1) {
			 return 1;
		 }
		 
		 char c = current.charAt(offset);
		 
		 int wayFirst = find(current, offset+1);
		 
		 if(c > '0' && c < '3' && offset < current.length()-1) {
			 char c1 = current.charAt(offset+1);
			 if(c1 < '7' && c1 > '0') {
				 wayFirst+= find(current, offset+2);
			 }
		 }
		 mem.put(offset, wayFirst);
		 return wayFirst;
		 
	 }
}
