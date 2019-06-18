package dpagain;

import java.util.ArrayList;

import algo.Utilities;

public class w2arkingdom {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A = Utilities.toList(new Integer[][] {
			{-5,-5,100},{-5,-5,105},{100,105,110}
		});
		System.out.println(new w2arkingdom().solve(A));
	}

	int solve(ArrayList<ArrayList<Integer>> A) {
		int row = A.size();
	 	int col = A.get(0).size();
	 	int max = A.get(row-1).get(col-1);
	 	
	 	
	 	
	 	int sum = 0;
	 	
	 	for(int i =row-1 ; i >= 0 ; i--) {
	 		sum+= A.get(i).get(col-1);
	 		if(sum > max) {
	 			max = sum;
	 		}
	 	}
	 	
	 	sum =0;
	 	
	 	for(int i = col-1; i>=0; i--) {
	 		sum+= A.get(row-1).get(i);
	 		if(sum > max) {
	 			max = sum;
	 		}
	 	}
	 	
	 	int[][] sumArr = new int[row][col];
	 	
	 	for(int i = row-1; i >= 0 ; i--) {
	 		for(int j = col-1; j>= 0 ; j--) {
	 				int val = A.get(i).get(j);
	 				if(i < row-1 && j < col-1) {
	 					val+= sumArr[i+1][j] + sumArr[i][j+1] - sumArr[i+1][j+1];
	 				}else
	 				if(i < row-1) {
	 					val+=  sumArr[i+1][j] ;
	 				}
	 				else
	 				if(j < col-1) {
	 					val+= sumArr[i][j+1];
	 				}
	 				
	 				
	 				sumArr[i][j] = val;
	 				
	 				if(sumArr[i][j] > max) {
	 					max = sumArr[i][j];
	 				}
	 		}
	 	}
	 	
	 	return max;
	}
	 int solve0(ArrayList<ArrayList<Integer>> A) {
		 
		 	int row = A.size();
		 	int col = A.get(0).size();

	        int[][] sumRight = new int[row+1][col+1];
	        int[][] sumDown = new int[A.size()+1][A.get(0).size()+1];
	        int[][] sumT = new int[A.size()+1][A.get(0).size()+1];
	        
	        for(int i =0 ; i<= row ; i++) {
        		for(int j = 0; j<= col ; j++) {
        			sumRight[i][j] = -1000000;
        			sumDown [i][j] = -100000;
        			sumT[i][j] = -1000000;
        		}
	        }
	        
	        for(int i =1 ; i<= A.size() ; i++) {
	        		for(int j = 1; j<= A.get(i-1).size() ; j++) {
	        			int val = A.get(i-1).get(j-1);
	        			sumRight[i][j] = Math.max(val, sumRight[i-1][j] + val);
	        			sumDown[i][j] = Math.max(val, sumDown[i][j-1] + val);
	        			sumT[i][j] = Math.max(val, val + sumT[i-1][j-1] + sumDown[i][j-1]+ sumRight[i-1][j] );
	        		}
	        }
	        
	      
	        
	        
	       

	        return Math.max(sumRight[row][col], Math.max(sumDown[row][col], sumT[row][col]));

	    }
}
