package algo;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumNonNagativeSubArray {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1967513926, 1540383426, -1303455736, -521595368));
		ArrayList<Integer> maxSet = maxset(list);
		for(int i =0; i< maxSet.size(); i++) {
			System.out.println(maxSet.get(i));
		}
	}

	    public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
	        int start = 0;
	        int end = 0;
	        long sum = 0;
	        int tempStart = 0;
	        int tempEnd = 0;
	        long tempSum = 0;
	        
	        for(int i =0; i< A.size() ; i++){
	            if(A.get(i) >= 0) {
	                tempSum+= A.get(i);
	                tempEnd++;
	                if(i == A.size()-1) {
	                	if(tempSum > sum) {
		                	sum = tempSum;
		                	start = tempStart;
		                	end = tempEnd;
		                }
	                }
	            }else{
	                if(tempSum > sum) {
	                	sum = tempSum;
	                	start = tempStart;
	                	end = tempEnd;
	                }else if(tempSum == sum) {
	                		if(tempEnd-tempStart > end - start) {
	                		 	sum = tempSum;
	    	                	start = tempStart;
	    	                	end = tempEnd;
	                		}
	                }
	                tempSum =0;
	                tempStart = i + 1;
	                tempEnd = i + 1;
	            }
	        
	        }
	        
	        return new ArrayList<Integer>(A.subList(start, end));
	    }
	

}
