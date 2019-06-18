package algo;

import java.util.ArrayList;
import java.util.Collections;

public class waveArray {
	
	public static void main(String[] args) {
		ArrayList<Integer> A = Utilities.toList(new Integer[] {1,2,3,4});
		
		Collections.sort(A);
		
		for(int i =0; i< A.size() ; i = i+ 2) {
			if(i < A.size()-1) {
				int first = A.get(i);
				int second = A.get(i+1);
				
				if(first < second) {
					A.set(i, second);
					A.set(i+1, first);
				}
			}
		}
		
		Utilities.printArrayList(A);
	}

}
