package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class noble {

	public static void main(String[] args) {
		ArrayList<Integer> A = Utilities.toList(new Integer[] {  7
				,7
				,7
				,7
				,7
				,7
				,7
				,7
				,7
				,8
				,8
				,8
				,8
				,8
				,9
				,9
				,9
				,9
				,9
				,9
				,9
				,9
				,9
				,9

		}
);
		
		Collections.sort(A);
		
		Utilities.printArrayList(A);

		
		HashMap<Integer,Integer> count = new HashMap<>();
		
		for(int i = 0; i< A.size() ; i++) {
			int no = A.get(i);
			
			if(no == 9) {
				System.out.println();
			}
			
			Integer value = count.get(no);
			if(value == null) {
				count.put(no, 1);
			}else {
				count.put(no, ++value);
			}
			
		}
		
		boolean isFound = false;
		Integer prevNo = null;
		for(int i = 0; i< A.size() ; i++) {
			
			
			int no = A.get(i);
			
			
			if(prevNo == null) {
				prevNo = no;
			}else if(no == prevNo) {
				continue;
			}
			prevNo = no;
			if(i == (A.size() - no-1 - (count.get(no)-1))) {
				isFound = true;
				System.out.println(" isFound "+ no + " "+ A.size() + " "+ count.get(no)+" " + ((A.size() - no-1 - (count.get(no)-1))));
				break;
			}
		}
		
		
		
	}

}
