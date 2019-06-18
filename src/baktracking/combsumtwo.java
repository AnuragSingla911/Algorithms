package baktracking;

import java.util.ArrayList;
import java.util.Collections;

import algo.Utilities;

public class combsumtwo {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = Utilities.toList(new Integer[] {
				15, 8, 15, 10, 19, 18, 10, 3, 11, 7, 17 
		});
		
		Utilities.print2DArrayList(new combsumtwo().combinationSum(list, 33));
	}
	
	 public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
		 
		 result = new ArrayList<>();
		 Collections.sort(a);
		 for(int i=0;i < a.size();i++) {
			 
			 find(0,b,a,i,new ArrayList<Integer>());
			 while(i+1 < a.size() && a.get(i) == a.get(i+1)) {
				 i++;
			 }
		 }
		 
		 return result;
		 
	    }
	 
	 ArrayList<ArrayList<Integer>> result;
	 void find(int sum, int target, ArrayList<Integer> list, int index, ArrayList<Integer> current) {
		 int no = list.get(index);
		 if(sum + no == target) {
			 current.add(no);
			 result.add(current);
			 return;
		 }else if(sum + no > target) {
			 return;
		 }else {
			 current.add(no);
			 for(int i=1;i+index < list.size();i++) {
				 find(sum+no,target, list, index+i, (ArrayList<Integer>)current.clone());
				 while(i+index+1 < list.size() && list.get(i+index) == list.get(i+1+index)) {
					 i++;
				 }
			 }
		 }
	 }
}
