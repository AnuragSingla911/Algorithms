package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumContiSubArray {
	
	public static void main(String[] args) {
		
		MaxSumContiSubArray array = new MaxSumContiSubArray();
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(-2,1,-3,4,-1,2,1,-5,4 ));
		System.out.println(array.maxSubArray(A));

				
		
	}
	
	
	 public int maxSubArray(final List<Integer> A) {
		 
		 if(A == null || A.size() == 0) {
			 return 0;
		 }
		 
		 int[] maxSum = new int[A.size()];
		 
		 maxSum[0] = A.get(0);
		 
		 for(int i =1; i <A.size() ; i++) {
			 maxSum[i] = Math.max(A.get(i), A.get(i)+ maxSum[i-1]);
		 }
		 
		 int max = Integer.MIN_VALUE;
		 
		 for(int i =0; i< A.size() ; i++) {
			 if(maxSum[i] > max) {
				 max = maxSum[i];
			 }
		 }
		 
		 return max;
		 
	    }

}
