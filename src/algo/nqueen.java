package algo;

import java.util.ArrayList;

public class nqueen {
	
	public static void main(String[] args) {
		
		
		
		
		
		nqueen obj = new nqueen();
		obj.solveNQueens(4);
		Utilities.print2DArrayList(obj.result);
		
		
		
		
		
		
	}
	
	 public ArrayList<ArrayList<String>> solveNQueens(int a) {
		 
		 char[][] chess = new char[a][a];
		 
			 for(int k=0;k < chess.length ; k++) {
				 for(int l=0;l < chess.length ; l++) {
					 chess[k][l]='.';
				 }
			 }
			
			 boolean b = place(0, 0, chess, a);
			
		 
		 
		 return result;
	    }
	 ArrayList<ArrayList<String>> result = new ArrayList<>();

	
	boolean is_attacked(int i,int j, char[][] chess,int N) {

		for(int k=0;k < N;k++) {
			if(chess[i][k]=='Q') {
				return true;
			}
		}

		for(int k=0;k < N;k++) {
			if(chess[k][j]=='Q') {
				return true;
			}
		}

		int k =i,l=j;
		
		while(k < N && l < N && k >= 0 && l >= 0) {
			
			if(chess[k][l] == 'Q') {
				return true;
			}
			k++;
			l++;
		}
		
		k =i;
		l=j;
		
		while(k < N && l < N && k >= 0 && l >= 0) {
			
			if(chess[k][l] == 'Q') {
				return true;
			}
			k--;
			l--;
		}
		
		k =i;
		l=j;
		
		while(k < N && l < N && k >= 0 && l >= 0) {
			
			if(chess[k][l] == 'Q') {
				return true;
			}
			k++;
			l--;
		}
		
		k =i;
		l=j;
		
		while(k < N && l < N && k >= 0 && l >= 0) {
			
			if(chess[k][l] == 'Q') {
				return true;
			}
			k--;
			l++;
		}
			

		return false;
		
	}

	
	boolean place(int i,int j,char[][] chess, int no){
		
		if(no==0) {
			return true;
		}
		
		
		for(int k=0;k < chess.length ; k++) {
			for(int l=0;l < chess.length ; l++) {
				if(is_attacked(k, l, chess, chess.length)) {
					continue;
				}else {
					chess[k][l] = 'Q';
					no--;
					if(no == 0) {
						 ArrayList<String> row = new ArrayList<String>();
							for(int m=0;m< chess.length;m++) {
								
									row.add(String.copyValueOf(chess[m]));
									
								
							}
							result.add(row);
							chess[k][l]='.';
							no++;
						
					}else {
						if(place(k,l,chess, no)) {
							//return true;
							
						}else {
							chess[k][l]='.';
							no++;
						}
					}
				}
			}
		}
		
		return false;
		
	}

}
