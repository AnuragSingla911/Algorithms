package dpagain;

import java.util.ArrayList;
import java.util.HashMap;

import algo.Utilities;

public class kingqueenresque {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A = Utilities.toList(new Integer[][] 
				{
			{-2,-3,3},{-5,-10,1},{10,30,-5}
			 }
		);
		
		System.out.println(new kingqueenresque().calculateMinimumHP(A));
	}
	
	 public int calculateMinimumHP(ArrayList<ArrayList<Integer>> A) {
	        int m = A.size(), n = A.get(0).size();
	        int[][] dp = new int[m][n];
	        for(int i=m-1;i>=0;i--){
	            for(int j =n-1;j>=0;j--){
	                if(i==m-1 && j==n-1) dp[i][j]= Math.max(1,1-A.get(i).get(j));
	                else if(i==m-1) dp[i][j]=Math.max(1,dp[i][j+1]-A.get(i).get(j));
	                else if(j==n-1) dp[i][j]=Math.max(1,dp[i+1][j]-A.get(i).get(j));
	                else dp[i][j]=Math.max(1, Math.min(dp[i+1][j],dp[i][j+1])-A.get(i).get(j));
	            }
	        }
	        return dp[0][0];
	    }
	
	public int calculateMinimumHP2(ArrayList<ArrayList<Integer>> A) {

		int row = A.size();
		int col = A.get(0).size();

		int[][] dp = new int[row][col];
		int[][] pr = new int[row][col];

		if (A.get(0).get(0) >= 1) {
			dp[0][0] = 0;
			pr[0][0] = A.get(0).get(0);
		} else {
			dp[0][0] = 1 - A.get(0).get(0);
			pr[0][0] = 1;
		}
		
		for(int i = 1 ; i <= row-1 ; i++) {
			if(pr[i-1][0] + A.get(i).get(0) > 0) {
				dp[i][0] = dp[i-1][0];
				pr[i][0] = pr[i-1][0] + A.get(i).get(0);
			}else {
				dp[i][0] = dp[i-1][0] + 1 - (pr[i-1][0] + A.get(i).get(0));
				pr[i][0] = 1;
			}
		}
		
		for(int i = 1; i <= col-1; i++) {
			if(pr[0][i-1] + A.get(0).get(i) > 0) {
				dp[0][i] = dp[0][i-1];
				pr[0][i] = pr[0][i-1] + A.get(0).get(i);
			}else {
				dp[0][i] = dp[0][i-1] + 1 - (pr[0][i-1] + A.get(0).get(i));
				pr[0][i] = 1;
			}
		}
		
		for(int i = 1 ; i <= row-1 ; i++) {
			for(int j = 1 ; j <= col-1 ; j++) {
				
				
				int x = 0;
				int xpr = 0;
				
					if (pr[i-1][j] + A.get(i).get(j) > 0) {
						x= dp[i-1][j];
						xpr = pr[i-1][j] + A.get(i).get(j);
					} else {
						x = dp[i-1][j] + 1 - (pr[i-1][j] + A.get(i).get(j));
						xpr = 1;
					}
				
				int y = 0;
				int ypr = 0;
				
					if (pr[i][j-1] + A.get(i).get(j) > 0) {
						y = dp[i][j-1];
						ypr = pr[i][j-1] + A.get(i).get(j);
					} else {
						y = dp[i][j-1] + 1- (pr[i][j-1] + A.get(i).get(j));
						ypr = 1;
					}
				
				
				if(x < y) {
					dp[i][j] = x;
					pr[i][j] = xpr;
				}else if(y < x){
					dp[i][j] = y;
					pr[i][j] = ypr;
				}else {
					dp[i][j] = x;
					pr[i][j] = Math.max(xpr, ypr);
				}
			}
		}
		return dp[row-1][col-1];
	}
	
	  public int calculateMinimumHP0(ArrayList<ArrayList<Integer>> A) {
		  
		  int row = A.size();
		  int col = A.get(0).size();
		  
		  return powerRequired(0, 0, A, row, col, 0);
		  
		  
		  
		  
	    }
	  
	  HashMap<String,Integer> mem  = new HashMap<>();
	  
	  
	private int powerRequired(int i, int j, ArrayList<ArrayList<Integer>> A, int row, int col, int powerremaining) {
		
		String key = i + " "+ j + " "+ powerremaining;

		if (i == row - 1 && j == col - 1) {
			if(powerremaining + A.get(i).get(j) >= 1) {
				return 0;
			}else {
				return 1-(powerremaining + A.get(i).get(j));
			}
		}
		
		if(mem.containsKey(key)) {
			return mem.get(key);
		}

		if (i == row - 1) {
			if (powerremaining + A.get(i).get(j) > 0) {
				return powerRequired(i, j + 1, A, row, col, powerremaining + A.get(i).get(j));
			} else {
				return 1 - (powerremaining + A.get(i).get(j)) + powerRequired(i, j + 1, A, row, col, 1);
			}
		}

		if (j == col - 1) {
			if (powerremaining + A.get(i).get(j) > 0) {
				return powerRequired(i+1, j, A, row, col, powerremaining + A.get(i).get(j));
			} else {
				return 1 - (powerremaining + A.get(i).get(j)) + powerRequired(i+1, j, A, row, col, 1);
			}
		}
		
		int x = 0;
		if(i < row-1) {
			if (powerremaining + A.get(i).get(j) > 0) {
				x= powerRequired(i, j + 1, A, row, col, powerremaining + A.get(i).get(j));
			} else {
				x= 1 - (powerremaining + A.get(i).get(j)) + powerRequired(i, j + 1, A, row, col, 1);
			}
		}
		int y = 0;
		if(j < col-1) {
			if (powerremaining + A.get(i).get(j) > 0) {
				y= powerRequired(i+1, j, A, row, col, powerremaining + A.get(i).get(j));
			} else {
				y= 1 - (powerremaining + A.get(i).get(j)) + powerRequired(i+1, j, A, row, col, 1);
			}
		}
		mem.put(key, Math.min(x, y));
		return Math.min(x, y);
 
	  }
}
