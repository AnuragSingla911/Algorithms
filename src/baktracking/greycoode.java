package baktracking;

import java.text.DecimalFormat;
import java.util.ArrayList;

import algo.Utilities;

public class greycoode {

	public static void main(String[] args) {
		Utilities.printArrayList(new greycoode().grayCode(3));
	}
	ArrayList<Integer> result = new ArrayList<>();

	public ArrayList<Integer> grayCode(int a) {

		find(a, "", false);
		
		return result;

	}

	private void find(int currentIndex, String current, boolean isReverse) {
		
		if(currentIndex == 1) {
			if(!isReverse) {
				result.add(Integer.parseInt(current + "0", 2));
				result.add(Integer.parseInt(current + "1", 2));
			}else {
				result.add(Integer.parseInt(current + "1", 2));	
				result.add(Integer.parseInt(current + "0", 2));
			}
			return;
		}
		
		if(!isReverse) {
		find(currentIndex-1 , current + "0", false);
		find(currentIndex-1, current+ "1", true);
		}else {
			find(currentIndex-1, current+ "1", false);
			find(currentIndex-1 , current + "0", true);
		}
		
		
		
		
		
		
		
		

	
		

		
	}



}
