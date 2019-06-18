package baktracking;

import java.util.ArrayList;
import java.util.Collections;

import algo.Utilities;

public class subset {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = Utilities.toList(new Integer[] {1,2,2 });
		
		Utilities.print2DArrayList(new subset().subsets(list));
	}

	  public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
		  
		  result = new ArrayList<>();
		  Collections.sort(A);
		  result.add(new ArrayList<Integer>());
		  for(int i =0; i< A.size() ; i++) {
			  save(i, new ArrayList<Integer>(), A);
		  }
		  
		  return result;
		  
		  
	    }
	  
	  ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	  void save(int start, ArrayList<Integer> list, ArrayList<Integer> A){
		  
		  int no = A.get(start);
		  
		  list.add(no);
		  result.add(list);
		  if(start == A.size()-1) {
			  
			  return;
		  }
		  for(int i =1; start+i< A.size() ; i++) {
		  save(start+i, (ArrayList<Integer>) list.clone(), A);
		  }
	  }
}
