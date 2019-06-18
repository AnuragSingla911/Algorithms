package dp;

import java.util.ArrayList;

import algo.Utilities;

public class maxSumwithoutadjacentelements {
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A = Utilities.toList(new Integer[][] {
			{16, 5, 54, 55, 36, 82, 61, 77, 66, 61},{31, 30, 36, 70, 9, 37, 1, 11, 68, 14}
		});
		System.out.println(new maxSumwithoutadjacentelements().adjacent(A));
	}

	public int adjacent(ArrayList<ArrayList<Integer>> A) {

		int row = A.size();
		int col = A.get(0).size();

		

		int[][] sum = new int[row][col];
		for(int j =0; j< col; j++) {
			for(int i =0; i< row; i++) {

				int max = 0;

				for(int l = 0; l < j-1 ; l++) {
					for(int k = 0 ; k< row; k++) {

						if(max < sum[k][l]) {
							max = sum[k][l];
						}
						
					}
				}

				sum[i][j] = A.get(i).get(j) + max;

			}
		}
		
		int max = 0;
		for(int i =0; i< row; i++) {
			for(int j =0; j< col; j++) {
				if(max < sum[i][j]) {
					max = sum[i][j];
				}
			}
		}
		
		
		return max;
    }
}
