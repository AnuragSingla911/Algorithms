package dpagain;

import java.util.ArrayList;

import algo.Utilities;

public class queenAttack {
	
	public static void main(String[] args) {
		ArrayList<String> list = Utilities.toList(new String[] {
				"010", "100", "001"
		});
		
		Utilities.print2DArrayList(new queenAttack().queenAttack(list));
	}

	public ArrayList<ArrayList<Integer>> queenAttack(ArrayList<String> A) {
		
		int row = A.size();
		int col = A.get(0).length();
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		int[][][] dp = new int[row+1][col+1][row+1];
		for(int i =0; i< row ; i++) {
			
			for(int j =0; j < col; j ++) {
				for(int k = 0; k < row  ; k++) {
					dp[i][j][k] = -1;
				}
			}
			
			}
		
		for(int i =0; i< row ; i++) {
			ArrayList<Integer> row1 = new ArrayList<>();
			for(int j =0; j < col; j ++) {
				
				row1.add(noofqueens(i, j, A, 1, dp));
			}
			result.add(row1);
		}
		
		return result;
		
    }
	
	private int noofqueens(int i,int j,ArrayList<String> A, int k, int[][][] dp) {
		
		//23 may ki raat sade 10 bje
		//25 may ki bandikui raat 9 bje.
		int c = 0;
		
		if(k == A.size()) {
			return 0;
		}
		
		c+= noofqueensLeft(i, j, A, k, dp);
		c+= noofqueensRight(i, j, A, k, dp);
		c+= noofqueensBottom(i, j, A, k, dp);
		c+= noofqueensTop(i, j, A, k, dp);
		c+= noofqueensLeftBottom(i, j, A, k, dp);
		c+= noofqueensRightBottom(i, j, A, k, dp);
		c+= noofqueensRightTop(i, j, A, k, dp);
		c+= noofqueensTopLeft(i, j, A, k, dp);
		
	
		return c;
		
		
		
	}
	
	private int noofqueensLeft(int i,int j,ArrayList<String> A, int k,int[][][] dp){
		int c = 0;
		if(i-k >= 0 && A.get(i-k).charAt(j) == '1') {
			c++;
			dp[i][j][k] = 1;	
		}else {
			if(k == A.size()) {
				return 0;
			}
			
			dp[i][j][k] = 1;
		}
		return c;
	}
	
	private int noofqueensTop(int i,int j,ArrayList<String> A, int k,int[][][] dp){
		int c = 0;
		if(j-k >= 0 && A.get(i).charAt(j-k) == '1') {
			c++;
			dp[i][j][k] = 1;	
		}else {
			if(k == A.size()) {
				return 0;
			}
			
			dp[i][j][k] = 1;
		}
		return c;
	}
	
	private int noofqueensRight(int i,int j,ArrayList<String> A, int k,int[][][] dp){
		int c = 0;

		if(i+ k < A.size()  && A.get(i+k).charAt(j) == '1') {
			c++;
			dp[i][j][k] = 1;	
		}else {
			if(k == A.size()) {
				return 0;
			}
			
			c+= dp[i][j][k+1];
		}
		return c;
	}
	
	private int noofqueensBottom(int i,int j,ArrayList<String> A, int k,int[][][] dp){
		int c = 0;

		if(j+k < A.get(0).length() && A.get(i).charAt(j+k) == '1') {
			c++;
			dp[i][j][k] = 1;
		}else {
			if(k == A.size()) {
				return 0;
			}
			
			c+= dp[i][j][k+1];
		}
		return c;
	}
	
	private int noofqueensTopLeft(int i,int j,ArrayList<String> A, int k,int[][][] dp){
		int c = 0;

		if(i-k >= 0 && j-k >= 0 && A.get(i-k).charAt(j-k) == '1') {
			c++;
			dp[i][j][k] = 1;
		}else {
			if(k == A.size()) {
				return 0;
			}
			
			c+= dp[i][j][k+1];
		}
		return c;
	}
	
	private int noofqueensRightBottom(int i,int j,ArrayList<String> A, int k,int[][][] dp){
		int c = 0;

		if(i+k < A.size() && j+k < A.get(0).length() && A.get(i+k).charAt(j+k) == '1'){
			c++;
			dp[i][j][k] = 1;
		} else {
			if(k == A.size()) {
				return 0;
			}
			
			c+= dp[i][j][k+1];
		}
		return c;
	}
	
	private int noofqueensLeftBottom(int i,int j,ArrayList<String> A, int k,int[][][] dp){
		int c = 0;

		if(i-k >= 0 && j+k < A.get(0).length() && A.get(i-k).charAt(j+k) == '1') {
			c++;
			dp[i][j][k] = 1;
		} else {
			if(k == A.size()) {
				return 0;
			}
			
			c+= dp[i][j][k+1];
		}
		return c;
	}
	
	private int noofqueensRightTop(int i,int j,ArrayList<String> A, int k,int[][][] dp){
		int c = 0;

		if(i+k < A.size() && j-k >= 0 && A.get(i+k).charAt(j-k) == '1') {
			c++;
			dp[i][j][k] = 1;
		} else {
			if(k == A.size()) {
				return 0;
			}
			
			c+= dp[i][j][k+1];
		}
		return c;
	}
	
	
}
