package treemaporheapify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import algo.Utilities;

public class distinctwindows {
	
	public static void main(String[] args) {
		ArrayList<Integer> l = Utilities.toList(new Integer[] {1, 2, 1, 3, 4, 3 });
		Utilities.printArrayList(new distinctwindows().dNums(l, 3));
	}
	public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {

		HashMap<Integer,Integer> map = new HashMap<>();

		int x = 0;
		int j = x;
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(x < A.size()-B+1) {

			while(j < x + B) {
				int no = A.get(j++);
				if(map.containsKey(no)) {
					map.put(no, map.get(no)+1);
				}else {
					map.put(no, 1);
				}
			}
			result.add(map.size());
			int remove = A.get(x++);
			if(map.containsKey(remove)) {
				int removeVal = map.get(remove);
				if(removeVal > 1) {
					map.put(remove, --removeVal);
				}else {
					map.remove(remove);
				}
			}
		}
		
		return result;
	}
}
