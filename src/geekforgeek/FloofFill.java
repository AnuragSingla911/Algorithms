package geekforgeek;

import java.util.Scanner;

import algo.Utilities;

public class FloofFill {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int nooftestcase = sc.nextInt();
		
		for(int k = 0 ; k < nooftestcase ; k++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			
			int[][] matrix = new int[m][n];
			
			for(int i =0; i< m; i++) {
				for(int j =0; j < n; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}
			
			int pixelRow = sc.nextInt();
			int pixelCol = sc.nextInt();
			
			int color = sc.nextInt();
			
			fill(matrix, pixelRow, pixelCol, color, m, n);
			
			for(int i =0; i< m; i++) {
				for(int j =0; j < n; j++) {
					System.out.print(matrix[i][j] + " ");
				}
				
			}
			System.out.println();
			
		}
	}
	static int[][] dir = new int[][] {{-1,0},{1,0}, {0,-1}, {0,1}};
	
	private static void fill(int[][] matrix, int x,int y, int color, int m, int n) {
		
		int val = matrix[x][y];
		
		matrix[x][y] = color;
		
		for(int i =0; i< dir.length ; i++) {
			int x1 = x + dir[i][0];
			int y1 = y + dir[i][1];
			
			if(x1 >= 0 && x1 < m && y1 >= 0 && y1 < n) {
			
			if(matrix[x1][y1] == val) {
				fill(matrix, x1, y1, color, m, n);
			}
			}
		}
		
		
	}
}
