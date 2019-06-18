package algo;

import java.util.ArrayList;

public class MaxAbsoluteDiff {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = Utilities.toList(new Integer[] {1, 3, -1});
		System.out.println(new MaxAbsoluteDiff().maxArr(list));
	}
	
	public int maxArr(ArrayList<Integer> A) {
		
		
		
		int firstMax = Integer.MIN_VALUE;
		int firstMin = Integer.MAX_VALUE;
		
		for(int i =0; i< A.size() ; i++) {
			
			int no = A.get(i) + i;
			
			if(no > firstMax) {
				firstMax = no;
			}
			
			if(no < firstMin) {
				firstMin = no;
			}
		}
		
		int secondMax = Integer.MIN_VALUE;
		int secondMIN = Integer.MAX_VALUE;
		
		for(int i =0; i< A.size() ; i++) {
			
			int no = A.get(i) - i;
			
			if(no > secondMax) {
				secondMax = no;
			}
			
			if(no < secondMIN) {
				secondMIN = no;
			}
		}
		
		int firstDiff = firstMax - firstMin;
		
		int secondDiff = secondMax - secondMIN;
		
		return firstDiff > secondDiff ? firstDiff : secondDiff;
		
		
		
		
		
    }
	
	
}
