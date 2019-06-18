package dpagain;

import java.util.ArrayList;

import algo.Utilities;

public class minsumpathtriangle {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A = Utilities.toList(new Integer[][] 
				{
			{3},{6,6},{7,8,4}
			 }
		);
		
		System.out.println(new minsumpathtriangle().minimumTotal(A));
	}
	
	public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
       
		int row = a.size();
		int col = row;
		
		int[][] dp = new int[row][col];
		
		for(int i = 0; i< col ; i++) {
			dp[row-1][i] = a.get(row-1).get(i);
		}
		
		for(int i = row-2 ; i>= 0 ; i--) {
			for(int j = i ; j>= 0 ; j--) {
				dp[i][j] = a.get(i).get(j)  + Math.min(dp[i+1][j], dp[i+1][j+1]);
			}
		}
		
		return dp[0][0];
    }
	
	public int minimumTotal0(ArrayList<ArrayList<Integer>> a) {
        return findMin(0,0,a);
    }
	
	private int findMin(int i,int j, ArrayList<ArrayList<Integer>> a) {
		
		if(i == a.size()-1) {
			return a.get(i).get(j);
		}
		
		
		int x = findMin(i+1,  j , a);
		int y = findMin(i+1,  j + 1, a);
		
		return a.get(i).get(j) + Math.min(x, y);
	}
}
