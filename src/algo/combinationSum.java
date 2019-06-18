package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class combinationSum {
	
	public static void main(String[] args) {
		
		combinationSum obj = new combinationSum();
		ArrayList<Integer> list = Utilities.toList(new Integer[] {1,1,1,1,1});
		obj.combinationSum(list, 5);
		
		
	}
	private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
		
		result = new ArrayList<>();
		Collections.sort(A);
		HashMap<Integer,Integer> count = new HashMap<Integer,Integer>();
		int i=0;
		while(i<A.size()) {
			if(count.containsKey(A.get(i))) {
				A.remove(i);
				
			}else {
				count.put(A.get(i), 1);
				i++;
			}
		}
		
		Utilities.printArrayList(A);
		
		
		
		pair(B,0,new ArrayList<Integer>(), A,0);
		
		Utilities.print2DArrayList(result);
		
		return result;
		
		
    }
	
	
	void pair(int expectedNo, int currentSum , ArrayList<Integer> pair, ArrayList<Integer> input,int index) {
		
		for(int i = index; i< input.size() ; i++) {
			int no = input.get(i);
			if(no + currentSum > expectedNo) {
				break;
			}else if(no + currentSum == expectedNo) {
				pair.add(no);
				result.add(new ArrayList<Integer>(pair));
				pair.remove((Integer)no);
			}else {
				pair.add(no);
				pair(expectedNo, currentSum+no, pair,input,i);
				pair.remove((Integer)no);
			}
		}
		
	}

}
