package dpagain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import algo.Utilities;

public class rodcutting {
	
	
	public static void main(String[] args) {
		ArrayList<Integer> list = Utilities.toList(new Integer[] {
				1, 2,3
		});
		System.out.println(new rodcutting().rodCut(4, list));
	}
	 public ArrayList<Integer> rodCut(int A, ArrayList<Integer> B) {
		
		 
		 int[][] dp = new int[A+1][A+1];
		 int[][] kp = new int[A+1][A+1];
		 
		 for(int i = A ; i>= 0; i--) {
			 for(int j =0; j < A+1 ; j++) {
				 if(i < j) {
					 int max = Integer.MAX_VALUE;
					 kp[i][j] = -1;
					 for(int k = 0; k < B.size() ; k++) {
						
						 if(B.get(k) <= i || B.get(k) >= j) {
							 kp[i][j] = k;
							 continue;
						 }
						 int force = j-i;
						 int left = dp[i][B.get(k)];
						 int right = dp[B.get(k)][j];
						 System.out.println(i + " "+ j + " "+ B.get(k) + " "+ (force + left+ right));
						 if(force + left+ right < max) {
							 max = force + left + right;
							 kp[i][j] = k;
						 }
						 
						 
						 
					 }
					 
					  dp[i][j] = max == Integer.MAX_VALUE ? 0 : max;
				 }
			 }
		 }
		 
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 
		
		 Queue<Integer> leftQueue = new LinkedList<Integer>();
		 leftQueue.add(0);
		 Queue<Integer> rightQueue = new LinkedList<Integer>();
		 rightQueue.add(A);
		 while(result.size() < B.size()) {
			 int left = leftQueue.poll();
			 int right = rightQueue.poll();
			 if(left < right && kp[left][right] > -1) {
			 result.add(B.get(kp[left][right]));
			 leftQueue.add(left);
			 rightQueue.add(B.get(kp[left][right]) -1);
			 leftQueue.add(B.get(kp[left][right]) +1);
			 rightQueue.add(right);
			 }
			 
		 }
		 
		 return result;
	    }
	 
	 private int find(ArrayList<Integer> B, int start, int end) {
		 System.out.println(start + " "+ end );
		 if(end <= start) {
			 return 0;
		 }
		 
		int max = 100000;
		 
		 for(int i = 0; i < B.size() ; i++) {
			 if(B.get(i) < start || B.get(i) > end) {
				 continue;
			 }
			 int force = end-start+1;
			 int left = find(B, start, B.get(i)-1);
			 int right = find(B, B.get(i)+1, end);
			 
			 if(force + left+ right < max) {
				 max = force + left + right;
			 }
			 
			 
			 
		 }
		 System.out.println(start + " "+ end + " "+ max);
		 return max == 100000 ? 0 : max;
		 
	 }
	 
	
}
