package algo;

import java.util.ArrayList;

public class permutation {
	
	public static void main(String[] args) {
		
		permutation p= new permutation();
		
		ArrayList<Integer> list = Utilities.toList(new Integer[] {1,2,3});
		
		p.pair(list, new ArrayList<Integer>());
		
		Utilities.print2DArrayList(p.result);
		
		
	}
	
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	
	boolean pair(ArrayList<Integer> input_arr, ArrayList<Integer> pair) {
		for(int i = 0 ; i< input_arr.size() ; i++) {
			int no = input_arr.get(i);
			System.out.println("no is :"+ no);
			
			if(pair.contains(no)) {
				//donothing
			}else {
				pair.add(no);
				if(pair.size()==input_arr.size()) {
					result.add(new ArrayList<Integer>(pair));
					pair.remove((Integer)no);
					return true;
				}
				pair(input_arr,pair);
				pair.remove((Integer)no);
			}
			
			
		}
		
		return false;
		
	}

}
