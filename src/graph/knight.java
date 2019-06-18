package graph;

import java.util.LinkedList;
import java.util.Queue;

public class knight {
	
	public static void main(String[] args) {
		System.out.println(new knight().knight(4, 7, 2, 6, 2, 4));
	}

public int knight(int A, int B, int C, int D, int E, int F) {
	
	
	int[][] matrix = new int[A+1][B+1];
	
	for(int i =0; i< A+1; i++) {
		for(int j =0; j < B+1 ; j++) {
			matrix[i][j]= Integer.MAX_VALUE;
		}
	}
	
	matrix[C][D] = 0;
	
	Queue<Integer> xQueue = new LinkedList<Integer>();
	Queue<Integer> yQueue = new LinkedList<Integer>();
	xQueue.add(C);
	yQueue.add(D);
	
	while(!xQueue.isEmpty()) {
		int x = xQueue.poll();
		int y = yQueue.poll();

		System.out.println("noo "+x + " "+ y+ " " + matrix[x][y]);
		int[][] moves = new int[][] {{-2,1},{-1,2}, {1,2}, {2,1},{2, -1},{1,-2},{-1,-2},{-2,-1}};
		for(int i =0; i< moves.length ; i++) {
			int x0 = x + moves[i][0];
			int y0 = y + moves[i][1];
			
			if(x0 > 0 && y0 > 0 && x0 <= A && y0 <= B) {
				if(matrix[x0][y0] > Math.abs(matrix[x][y])+1) {
					matrix[x0][y0] = Math.abs(matrix[x][y])+1;
				}
				if(matrix[x0][y0] > 0) {
					xQueue.add(x0);
					yQueue.add(y0);
					matrix[x0][y0] = -1 * Math.abs(matrix[x0][y0]);
				}
			}
		}
		
	}
	
		return matrix[E][F] != Integer.MAX_VALUE ? Math.abs(matrix[E][F]) : -1;
      
    }

	
	


	
}
