package dpagain;

import java.util.ArrayList;

import algo.Utilities;

public class minSumPathMatrix {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A = Utilities.toList(new Integer[][] {
			{2,-3,3},{-5,-10,1},{10,30,-5}
		});
		
		System.out.println(new minSumPathMatrix().minPathSum(A));
	}
	
	public int minPathSum(ArrayList<ArrayList<Integer>> A) {
		int row = A.size();
		int col = A.get(0).size();
		
		int[][] dp = new int[row][col];
		
		dp[row-1][col-1] = A.get(row-1).get(col-1);
		
		for(int i =row-2; i >= 0; i--) {
			dp[i][col-1] = dp[i+1][col-1] + A.get(i).get(col-1);
		}
		
		for(int i =col-2; i >=0; i--) {
			dp[row-1][i] = dp[row-1][i+1] + A.get(row-1).get(i);
		}
		
		for(int i = row-2 ; i>= 0 ; i--) {
			for(int j = col-2 ; j>= 0 ; j--) {
				
				dp[i][j]= A.get(i).get(j) + Math.min(dp[i+1][j], dp[i][j+1]);
			}
		}
		
		return dp[0][0];
		
		
    }
	
	
	public int minPathSum0(ArrayList<ArrayList<Integer>> A) {
		int row = A.size();
		int col = A.get(0).size();
		
		return func(0,0,A,row,col);
    }
	
	private int func(int i, int j, ArrayList<ArrayList<Integer>> A, int row, int col) {
		
		int sum = A.get(i).get(j);
		
		if(i == row-1 && j == col-1) {
			return sum;
		}
		
		if(i == row-1) {
			return sum+= func(i, j+1 , A, row, col);
		}
		
		if(j == col-1) {
			return sum+= func(i +1, j , A, row, col);
		}
		
		int x = 0;
		if(i < row-1) {
			x = func(i +1, j , A, row, col);
		}
		int y = 0;
		if(j < col-1) {
			y = func(i, j+1 , A, row, col);
		}
		
		return sum+= Math.min(x, y);
	}
}
