package algo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class largestNumber {

	public static void main(String[] args) {

		ArrayList<Integer> list = Utilities.toList(new Integer[] { 12, 121});
		largestNumber large = new largestNumber();
		System.out.println(large.largestNumber(list));


	}


	public String largestNumber(final List<Integer> A) {



		Collections.sort(A, new Comparator<Integer>() {

			@Override
			public int compare(Integer first, Integer second) {
				
				
				String first1 = ""+first+ second;
				String second1 = ""+second + first;
				
				return second1.compareTo(first1);



			}
		});



		String result = "";

		for(int i =0; i< A.size() ; i++) {
			result += A.get(i);
		}
		
		
		BigInteger big = new BigInteger(result);
		
		
		
		
		
//		int index = 0;
//		while(true) {
//			
//			if((index < result.length()-1) && result.charAt(index) =='0') {
//				result = result.substring(index+1);
//			}else {
//				break;
//			}
//			
//		}

		return String.valueOf(big);

	}
}
