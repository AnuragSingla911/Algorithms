package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class countblackshapes {
	public static void main(String[] args) {

	}

	public int black(ArrayList<String> A) {
		
		if(A == null || A.size() == 0) {
			return 0;
		}

		int[][] matrix = new int[A.size()][];
		int k = 0;
		for(String s : A) {
			for(int i =0; i < s.length(); i++) {
				if(s.charAt(i) != 'X') {
					matrix[k][i] = 0;
				}else {
					matrix[k][i] = 1;
				}
			}
			k++;
		}
		int shapes = 0;
		for(int i =0; i< matrix.length ; i++) {
			for(int j =0; j < matrix[i].length ; j++) {
				if(matrix[i][j] == 1) {
					shapes++;
					matrix[i][j] = 2;
					traceShape(matrix, i , j);
				}
			}
		}
		
		return shapes;


	}

	private void traceShape(int[][] matrix, int x,int y) {
		Queue<Integer> xqueue = new LinkedList<Integer>();
		Queue<Integer> yqueue = new LinkedList<Integer>();


		xqueue.add(x);
		yqueue.add(y);

		while(!xqueue.isEmpty()) {
			int[][] moves = new int[][] {{-1,0},{0,1},{0,-1},{1,0}};
			
			int x0 = xqueue.poll();
			int y0 = yqueue.poll();
			
			
			
			for(int i =0; i< moves.length ; i++) {
				int x00 = x0 + moves[i][0];
				int y00 = y0 + moves[i][1];
				
				if(x00 >= 0 && y00 >= 0 && x00 < matrix.length && y00 < matrix[0].length && matrix[x00][y00] == 1) {
					xqueue.add(x00);
					yqueue.add(y00);
					matrix[x00][y00] = 2;
				}
			}
		}
	}
}
