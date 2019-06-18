package dp;

import java.util.ArrayList;
import java.util.HashMap;

import algo.Utilities;

public class maxcoincalu {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = Utilities.toList(new Integer[] {
				10, 500, 100, 1
		});
		
		System.out.println(new maxcoincalu().maxcoin(list));
	}

	public int maxcoin(ArrayList<Integer> A) {
		
		
		return dp(A);
		
		
		
    }
	
	
	private int dp(ArrayList<Integer> A) {
		int size = A.size();
		
		int[][] dp = new int[size][size];
		
		for(int i = dp.length-1; i>= 0 ; i--) {
			for(int j =0;j < dp.length ; j++) {
				if(i < j) {
					int first = A.get(i);
					if(A.get(i+1) > A.get(j)) {
						if(i+2 < size)
						first += dp[i+2][j];//find(A, i+2, j);
					}else {
						first += dp[i+1][j-1];//find(A, i+1, j-1);
					}
					
					int second = A.get(j);
					if(A.get(i) > A.get(j-1)) {
						if(i+1 < size)
						second+= dp[i+1][j-1];//find(A, i+1, j-1);
					}else {
						if(j-2 >= 0)
						second+= dp[i][j-2];//find(A, i, j-2);
					}
					int v = Math.max(first,second);
					dp[i][j] = v;
				}
			}
		}
		
		return dp[0][size-1];
	}
	
	HashMap<String, Integer> mem = new HashMap<>();
	
	private int find(ArrayList<Integer> A, int start, int end) {
		
		if(start>end) {
			return 0;
		}
		
		String key = start + " "+ end;
		
		if(mem.containsKey(key)) {
			return mem.get(key);
		}
		
		int first = A.get(start);
		if(A.get(start+1) > A.get(end)) {
			first += find(A, start+2, end);
		}else {
			first += find(A, start+1, end-1);
		}
		
		int second = A.get(end);
		if(A.get(start) > A.get(end-1)) {
			second+= find(A, start+1, end-1);
		}else {
			second+= find(A, start, end-2);
		}
		int v = Math.max(first,second);
		mem.put(key, v);
		return v;
	}
}
