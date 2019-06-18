package graph;

import java.util.ArrayList;

import graph.connectingislands.set;

public class possiblefinishallcourses {
	
	public static void main(String[] args) {
		
	}
	
	 public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
		 set[] set = new set[A+1];
			
			for(int i =0; i< set.length ; i++) {
				set s = new set();
				s.rank = 0;
				s.parent = (i);
				set[i]=s;
			}
			

			int count = 0;
			for(int i = 0; i < B.size() ; i++) {
				if(find(set,B.get(i)) == find(set,C.get(i))) {
					return 0;
				}
				
			
				union(set, B.get(i), C.get(i));
				count++;
				//System.out.println(sum);
				
			}
			
			return 1;
	        
	    }

	private void union(set[] set, int m, int n) {
		int x = find(set,m);
		int y = find(set,n);
		if(set[x].rank < set[y].rank) {
			set[x].parent = y;
		}else if(set[x].rank > set[y].rank) {
			set[y].parent = x;
		}else {
			set[y].parent = x;
			set[x].rank++;
		}
	}
	
	private int find(set[] set, int node) {
		if(set[node].parent != node) {
			set[node].parent = find(set, set[node].parent);
		}
		//System.out.println("find : "+ set[node].parent + " node + "+node);
		return set[node].parent;
	}
	
	class set{
		int rank;
		int parent;
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return rank + " "+ parent;
		}
	}
}
