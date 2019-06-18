package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import algo.Utilities;

public class lengthoflongsequence {

	public static void main(String[] args) {
		ArrayList<Integer> list = Utilities.toList(new Integer[] {});
		System.out.println(new lengthoflongsequence().longestSubsequenceLength(list));
	}
	
	 public int longestSubsequenceLength(final List<Integer> A) {
	        

		 int[] a = new int[A.size()];
		 
		 
		 
		 return max;
		 	
	        
	    }
	 
	 private void findIncreasing(List<Integer> A, int start, int curLength) {
		 
		// System.out.println("find incr : "+ A.get(start) + " l "+ curLength);
		
		 int startNumber = A.get(start);
		 for(int i = start+1 ; i < A.size() ; i++) {
			
			 int second = A.get(i);
			 if(second > startNumber) {
				 findIncreasing(A, i, curLength+1);
			 }else {
				// findDescreasing(A,i, i, curLength+1);
			 }
			
		 }
	 }
	 
	 int max = -1;
	 
	 HashMap<Integer, Integer> map = new HashMap<>();
	 
	 private void findDescreasing(List<Integer> A,int startIndex, int start, int curLength) {
		 
		// System.out.println("find dec : "+ A.get(start) + " l "+ curLength);
		 
		 if(map.containsKey(startIndex)) {
			 curLength = map.get(startIndex);
			 if(curLength > max) {
				 max = curLength;
			 }
			 return;
		 }
		 
		 if(curLength > max) {
			 max = curLength;
			 map.put(startIndex, curLength);
			 
		 }
		 int startNumber = A.get(start);
		 for(int i = start+1 ; i < A.size() ; i++) {
			
			 int second = A.get(i);
			 if(second < startNumber) {
				 findDescreasing(A, startIndex,i, curLength+1);
			 }
			
		 }
	 }
}
