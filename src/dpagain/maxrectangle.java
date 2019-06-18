package dpagain;

import java.util.ArrayList;

public class maxrectangle {
	
	public static void main(String[] args) {
		
	}
	
	public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
		
		int row = A.size();
		int col = A.get(0).size();
		int max = 0;
		
		int[][][][] dp = new int[row][col][row][col];
		for(int i =0; i< row; i++) {
			for(int j =0;j < col; j++) {
				for(int m =0; m < row; m++) {
					for(int n =0;n < col; n++) {
						int val = func(i,j,m,n,A,dp);
						
						if(val > max) {
							max = val;
						}
					}
				}
			}
		}
		
		return max;
		
		
    }
	
	private int func(int i,int j,int m,int n, ArrayList<ArrayList<Integer>> A, int[][][][] dp) {
		int val = 0;
		for(int k = i;k <= m; k++) {
			for(int l = j;l <= n ; l++) {
				if(A.get(k).get(l) == 1) {
					val++;
				}else {
					return 0;
				}
			}
		}
		dp[i][j][m][n] = val;
		return val;
	}

}
