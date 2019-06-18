package hashing;

import java.util.Arrays;
import java.util.HashMap;

public class foursum {

	public static void main(String[] args) {
		
		int[] arr = new int[] {-1,-1,-1,-1,0,0,0,0,1,1,1,1};
		
		new foursum().fourSum(arr, 0);
		
	}
	
	 public int[][] fourSum(int[] A, int B) {
		 
		 Arrays.sort(A);
		 int[][] result = new int[A.length][4];
		 int counter = 0;
		 HashMap<String,Boolean> remb = new HashMap<String, Boolean>();
		 for(int i =0; i< A.length ; i++) {
			 for(int j = i+1; j< A.length ; j++) {
					 
				 		int k = j + 1;
						int l = A.length - 1;
			 
						while (k < l) {
							int sum = A[i] + A[j] + A[k] + A[l];
			 
							if (sum > B) {
								l--;
							} else if (sum < B) {
								k++;
							} else if (sum == B) {
								
								String s = ""+A[i]+ A[j] + A[l] + A[k];
								 
								 if(remb.containsKey(s)) {
									 k++;
									 l--;
									 continue;
								 }
								 
								 remb.put(s, true);
								 
								 int[] arr = new int[] {A[i], A[j], A[l], A[k]};
								 result[counter] = arr;
								 counter++;
								 
								 if(counter == result.length) {
									 int[][] temp = new int[result.length* 2][4];
									 
									 for(int m =0; m < counter ; m++) {
										 temp[m] = result[m];
									 }
									 
									 result = temp;
									
									 
								 }
								k++;
								l--;
							}			
				 }
			 }
		 }
		 
		 int[][] finalresult = new int[counter][4];
		 
		 for(int i =0; i< counter ; i++) {
			 finalresult[i] = result[i];
		 }
		 
		 return finalresult;
	    }
}
