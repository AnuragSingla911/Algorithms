package dp;

import java.util.ArrayList;
import java.util.List;

import algo.Utilities;

public class maxProfit {

	public static void main(String[] args) {
		ArrayList<Integer> list = Utilities.toList(new Integer[] {
				2, 4, 6, 8, 6, 5, 3, 5, 7, 1 
		});
		
		System.out.println(new maxProfit().maxProfit(list));
	}
	
	 public int maxProfit(final List<Integer> A) {
	             
	        
	        int profit = 0;
	        int min = A.get(0);
	        int totalProfit = 0;
	        for(int i = 1; i< A.size() ; i++) {
	        	
	                if(A.get(i) <= A.get(i-1)) {
	                    min = A.get(i);
	                    totalProfit += profit;
	                    profit = 0;
	                }
	                
	                if(A.get(i)- min > profit) {
	                    profit = A.get(i)-min;
	                }
	        }
	        return totalProfit;
	    }
	
	public int maxProfit0(final List<Integer> A) {
        
        
        
        int profit = 0;
        int min = A.get(0);
        for(int i = 1; i< A.size() ; i++) {
        		if(A.get(i) <= min) {
        			min = A.get(i);
        		}
        		
        		if(A.get(i)- min > profit) {
        			profit = A.get(i)-min;
        		}
        }
        return profit;
    }
}
