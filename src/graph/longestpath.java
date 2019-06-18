package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import algo.Utilities;

public class longestpath {

	public static void main(String[] args) {
		ArrayList<Integer> list=Utilities.toList(new Integer[] {
				-1,0
				});
		System.out.println(new longestpath().solve(list));
	}
	
	    public int solve(ArrayList<Integer> A) {
	    	
	    	HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
	    	
	    	for(int i =0 ; i< A.size() ; i++) {
	    		 
	    		 ArrayList<Integer> t = graph.get(A.get(i));
	    		 if(t == null) {
	    			 graph.put(A.get(i), new ArrayList<Integer>());
	    		 }
	    		 
	    		 graph.get(A.get(i)).add(i);
	    	}
	    	
	    	Stack<sum> stack = new Stack<sum>();
	    	Stack<Integer> stackNo = new Stack<Integer>();
	    	stackNo.add(0);
	    	
	    	while(!stackNo.isEmpty()) {
	    		int no = stackNo.peek();
	    		
	    		
	    		  for(int i =0; i< graph.get(no).size() ; i++) {
	    			  stackNo.push(graph.get(no).get(i));
	    		  }
	    	}
	    	
	   // 	sum s = find(graph, 0);
	    	return value;
	    	
	    	
	  }
	    
	    int value = 0;
	    
	   private sum find(HashMap<Integer, ArrayList<Integer>> map, int node) {
		  
		   if(map.get(node) == null) {
			   return new sum();
		   }
		   int max = -1;
		   int secondmax = max;
		   
		   for(int i =0; i< map.get(node).size() ; i++) {
			   sum f = find(map, map.get(node).get(i));
			//   System.out.println("f : "+ f);
			   if(f.max >= max) {
				   secondmax = max;
				   max = f.max;
			   }else if(f.max >= secondmax) {
				   secondmax = f.max;
			   }
			   
			   
		   }
		  
		  
		   sum s = new sum();
		   if(max > -1) {
			   s.max= max+1;
		   }
		   if(secondmax > -1) {
			   s.secondmax = secondmax+1;
		   }
		   if(s.max+s.secondmax > value) {
			   value = s.max+s.secondmax;
		   }
		  System.out.println("find "+ node + " return : "+ s);
		   return s;
	   }
	   
	   class sum {
		   int max;
		   int secondmax;
		   
		   @Override
		public String toString() {
			// TODO Auto-generated method stub
			return max+ " "+ secondmax;
		}
	   }
	    
	  
	

}
