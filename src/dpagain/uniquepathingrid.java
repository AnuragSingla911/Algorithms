package dpagain;

import java.util.ArrayList;

public class uniquepathingrid {

	public static void main(String[] args) {
		
	}
	
	public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
		return find(0,0,A,A.size(),A.get(0).size());
    }
	
	private int find(int i, int j, ArrayList<ArrayList<Integer>> A, int row, int col) {
		if(i == row-1 && j == col-1) {
			return 0;
		}
		
		
		if(i == row-1) {
			if(A.get(i).get(j+1) == 0)
			return find(i, j+1, A, row, col);
			else
				return 0;
		}
		
		if(j == col-1) {
			if(A.get(i+1).get(j) == 0) {
			return find(i+1, j, A, row, col);
			}else {
				return 0;
			}
		}
		int x = 0;
		if(A.get(i).get(j+1) == 0) {
			x+=find(i, j+1, A, row, col);
		}
		if(A.get(i+1).get(j) == 0) {
			x+=find(i+1, j, A, row, col);
		}
		return x;
	}
}
