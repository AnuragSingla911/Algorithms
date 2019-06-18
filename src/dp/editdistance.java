package dp;

import java.util.ArrayList;

import algo.Utilities;

public class editdistance {
	
	
	public static void main(String[] args) {
		
		System.out.println(new editdistance().minDistance("abaabbbbabaabaa", "aaaababa"));
		
	}
	
	
	 public int minDistance(String A, String B) {
		 
		 int first = A.length();
		 int second = B.length();
		 
		 int[][] matrix = new int[first][second];
		 
		 for(int i =0; i< second ; i++) {
			 char a = A.charAt(0);
			 char b = B.charAt(i);
			 boolean same = a==b && same(a,b,0,i,A,B);
			 if(i > 0)
			 matrix[0][i] = same ? matrix[0][i-1] : matrix[0][i-1]+1;
			 else
				 matrix[0][i] = same ? 0 : 1;
		 }
		 
		 for(int i =0; i< first ; i++) {
			 char a = A.charAt(i);
			 char b = B.charAt(0);
			 boolean same = a==b && same(a,b,i,0,A,B);
			 if(i > 0)
			 matrix[i][0] = same ? matrix[i-1][0] : matrix[i-1][0]+1;
			 else
				 matrix[i][0] = same ? 0 : 1;
		 }
		 
		 for(int i =1; i< first ; i++) {
			 for(int j =1;j < second ; j++) {
				 
				 
				 char a = A.charAt(i);
				 char b = B.charAt(j);
				 
				 boolean same = a==b && (i==j || same(a,b,i,j,A,B));
				
				 
					int f = same ? matrix[i-1][j-1] : matrix[i-1][j-1]+1;
					int s = same && i==j? matrix[i-1][j]-1: i==j ? matrix[i-1][j] : matrix[i-1][j]+1;
					int t = 1+ matrix[i][j-1];
				 
				 
				 matrix[i][j] = Math.min(f, Math.min(s, t));
				 
				 
				 
				 
			 }
		 }
		 
		 return matrix[first-1][second-1];
		 
		 
	    }
	 
	 private boolean same(char a,char b, int i1,int j1,String f, String s) {
		 int c1 = 0;
		 for(int i =0; i< i1 ; i++) {
			 if(f.charAt(i) == a) {
				 c1++;
			 }
		 }
		 int c2 = 0;
		 for(int i =0; i< j1 ; i++) {
			 if(s.charAt(i) == b) {
				 c2++;
			 }
		 }
		 return c1==c2;
	 }
	
	
	 
	 
	 
		
    				
   
     
}
