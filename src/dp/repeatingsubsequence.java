package dp;

import java.util.HashMap;

public class repeatingsubsequence {
	
	public static void main(String[] args) {
		System.out.println(new repeatingsubsequence().anytwo("aabb"));
	}
	
	 public int anytwo(String A) {
	       return find(A,0,1) ? 1: 0;
	    }
	 
	 HashMap<String,Boolean> map = new HashMap<>(); 
	 
	 private boolean find(String A, int start, int end) {
		 if(end >= A.length()) {
			 return false;
		 }
		 
		 String key = A + " "+ start + " "+ end;
		 
		 if(map.containsKey(key)) {
			 return map.get(key);
		 }
		 
		 if(isRepeat(A, start, end)) {
			 return true;
		 }
		 
		 
		 boolean b =  find(A, start, end+1) || find(A, start+1, end+1) || 
				 find(A.charAt(start) + A.substring(end+1),0,1);
		 map.put(key, b);
		 
		 return b;
	 }
	 
	 
	 private boolean isRepeat(String A, int start,int end) {
		 String sub = A.substring(start, end+1);
		 System.out.println(sub);
		 int i = 0;
		 int j =0;
		 
		 while(i < A.length() && j < sub.length()) {
			 if(A.charAt(i) == sub.charAt(j)) {
				 i++;
				 j++;
				 if(j == sub.length()) {
					 return true;
				 }
			 }else {
				 i++;
				 
			 }
		 }
		 return false;
	 }
}
