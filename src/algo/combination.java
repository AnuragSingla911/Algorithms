package algo;

import java.util.ArrayList;

public class combination {

public static void main(String[] args) {
		
	combination p= new combination();
		
		ArrayList<Integer> list = Utilities.toList(new Integer[] {1,2,3,4});
		
		p.pair(list, new ArrayList<Integer>(), 0,2);
		
		Utilities.print2DArrayList(p.result);
		
		
	}
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	
	boolean pair(ArrayList<Integer> input_arr, ArrayList<Integer> pair, int index,int expected_size) {
		for(int i = index ; i< input_arr.size() ; i++) {
			int no = input_arr.get(i);
			
			if(pair.contains(no)) {
				//donothing
			}else {
				pair.add(no);
				if(pair.size()==expected_size) {
					result.add(new ArrayList<Integer>(pair));
					pair.remove((Integer)no);
					
				}else {
				pair(input_arr,pair,i+1, expected_size);
				pair.remove((Integer)no);
				}
			}
			
			
		}
		
		return false;
		
	}
}
