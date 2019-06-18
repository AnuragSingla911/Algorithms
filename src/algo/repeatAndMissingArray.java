package algo;

import java.util.ArrayList;
import java.util.Arrays;

public class repeatAndMissingArray {
	
	public static void main(String[] args) {
		final ArrayList<Integer> A = new ArrayList<>(Arrays.asList(4,2,3,4,5 ));
		
		int expectedSum = A.size() * (A.size()+1) / 2;
		
		
		int sum = 0;
		
		for(int i =0; i< A.size() ; i++) {
			sum+= A.get(i);
		}
		
		
		for(int i = 1; i<= A.size() ; i++) {
			int no = A.get(Math.abs(i-1));
			A.set(Math.abs(no)-1, -1 * A.get(Math.abs(no)-1));
		}
		
		
		
		int positiveNumber1 = -1, positiveNumber2 = -1;
		
		for(int i =0; i< A.size() ; i++) {
			if(A.get(i)> 0) {
				if(positiveNumber1 == -1) {
					positiveNumber1 = i+1;
				}else if(positiveNumber2 == -1) {
					positiveNumber2 = i+1;
					break;
				}
			}
		}
		
		A.clear();
		
		if(sum > expectedSum) {
			if(positiveNumber1 > positiveNumber2) {
				A.add(positiveNumber1);
				A.add(positiveNumber2);
			}else {
				A.add(positiveNumber2);
				A.add(positiveNumber1);
			}
		}else {
			if(positiveNumber1 < positiveNumber2) {
				A.add(positiveNumber1);
				A.add(positiveNumber2);
			}else {
				A.add(positiveNumber2);
				A.add(positiveNumber1);
			}
		}
		
		Utilities.printArrayList(A);
		
		
		
		
		
		

	}
	
	

}
