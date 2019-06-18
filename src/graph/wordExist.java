package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import algo.Utilities;

public class wordExist {

	public static void main(String[] args) {
		ArrayList<String> list=Utilities.toList(new String[] {
				"CDGCG", 
				"CDAAA", 
				"ECDDB",
				"FBGEC", 
				"BEBBF", 
				"DFGEF", 
				"CGGAD", 
				"AACGG", 
				"BDGGB"

		});
		
		System.out.println(new wordExist().exist(list, "BABABC"));
	}

	public int exist(ArrayList<String> A, String B) {



		for(int i =0; i< A.size() ; i++) {
			for(int j =0; j < A.get(i).length() ; j++) {
				if(A.get(i).charAt(j) == B.charAt(0)) {
					System.out.println("hunt for : "+ i + " "+ j);
					int m = find(A,B,i,j);
					if(m == 1) {
						return 1;
					}
				}
			}
		}
		
		return 0;


	}

	private int find(ArrayList<String> A, String B, int i, int j) {
		ArrayList<ArrayList<Boolean>> visited = new ArrayList<>();

		for(String s : A) {
			ArrayList<Boolean> l = new ArrayList<Boolean>();
			for(int k =0; k< s.length() ; k++) {
				l.add(false);
			}
			visited.add(l);
		}

		Queue<Integer> xQueue = new LinkedList<>();
		xQueue.add(i);
		Queue<Integer> yQueue = new LinkedList<>();
		yQueue.add(j);
		Queue<Integer> indexQueue = new LinkedList<>();
		indexQueue.add(0);
		visited.get(i).set(j, true);

		while(!xQueue.isEmpty()) {
			
			int x = xQueue.poll();
			int y = yQueue.poll();
			
			int index = indexQueue.poll();
			
			if(A.get(x).charAt(y) == B.charAt(index)) {
				if(index == B.length()-1) {
					return 1;
				}
				
				if(x > 0 && A.get(x-1).charAt(y) == B.charAt(index+1) && !visited.get(x-1).get(y)) {
					//visited.get(x-1).set(y, true);
					xQueue.add(x-1);
					yQueue.add(y);
					indexQueue.add(index+1);
				}
				
				if(y > 0 && A.get(x).charAt(y-1) == B.charAt(index+1) && !visited.get(x).get(y-1)) {
					//visited.get(x).set(y-1, true);
					xQueue.add(x);
					yQueue.add(y-1);
					indexQueue.add(index+1);
				}
				
				if(x < A.size()-1 && A.get(x+1).charAt(y) == B.charAt(index+1) && !visited.get(x+1).get(y)) {
					//visited.get(x+1).set(y, true);
					xQueue.add(x+1);
					yQueue.add(y);
					indexQueue.add(index+1);
				}
				
				if(y < A.get(x).length()-1 && A.get(x).charAt(y+1) == B.charAt(index+1) && !visited.get(x).get(y+1)) {
					//visited.get(x).set(y+1, true);
					xQueue.add(x);
					yQueue.add(y+1);
					indexQueue.add(index+1);
				}
				
			}

		}
		
		return -1;



	}
}
