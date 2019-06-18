package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import algo.Utilities;

public class tusharbrdaybombs {

	public static void main(String[] args) {
		ArrayList<Integer> list  = Utilities.toList(new Integer[] {
				8,7,6,5,4
		});
		
		System.out.println(new tusharbrdaybombs().solve(14, list));
	}
	
	
		  
	    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
	        
	        
	        int min = B.get(0);
	        
	        for(int i = 0 ; i < B.size() ; i++){
	            if(min > B.get(i)){
	                 min = B.get(i);
	            }
	        }
	        
	        int possibleCount = A/min;
	        
	        ArrayList<Integer> B0 = new ArrayList<>(B);
	        
	        Collections.sort(B0);
	        
	        B0 = (ArrayList<Integer>) B0.subList(0, possibleCount);
	        
	        
	        
	        
	        
	        
	        int[] dp = new int[A+1];
	        
	        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	        
	        for (int j = 0; j < dp.length; j++) {
	            list.add(new ArrayList<Integer>());
	        }
	        
	        
	        
	        
	        
	            for (int j = 1; j < dp.length; j++) {
	                ArrayList<Integer> list0 = list.get(j);
	                for (int i = 1; i < B0.size() + 1; i++) {
	                if (B0.get(i - 1) <= j) {
	                    int first = dp[j];
	                    int second = 1 + dp[j - B0.get(i - 1)];
	                    
	                    if(first >= second) {
	                        continue;
	                    }
	                    dp[j] = Math.max(first, second);
	                    list0 = new ArrayList<>(list.get(j - B0.get(i-1)));
	                    list0.add(B.indexOf(B0.get(i-1)));
	                      
	                    
//	                    System.out.println(" max is "+ dp[j]);
//	                    Utilities.printArrayList(list0);
	                    
	                }
	        
	            }
	                
	            list.set(j, list0);
	        }
	        
//	        System.out.println(dp[A]);
	        

	        
	        
	        Collections.reverse(list.get(A));
	        
	        
	        return list.get(A)    ;
	    }
	

}
