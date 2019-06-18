package dpagain;

import java.util.HashMap;
import java.util.List;

import algo.Utilities;

public class lengthoflongestincdescsequence {

	public static void main(String[] args) {
		List<Integer> A = Utilities.toList(new Integer[] {
			1,1,1,1,1
				});
		System.out.println(new lengthoflongestincdescsequence().longestSubsequenceLength1(A));
	}
	
	

	 public int longestSubsequenceLength1(final List<Integer> A) {
	        
	        
	        if(A.size() < 2){
	            return A.size();
	        }
	        int[][] dp = new int[A.size()][2];
	        
	        dp[A.size()-1][0] = 1;
	        dp[A.size()-1][1] = 1;
	        
	      
	         for (int i = A.size() - 2; i >= 0; i--) {
	            for (int j = 0; j <= 1; j++) {
	                dp[i][j] = 1;
	            }
	        }
	        
	        for(int i =A.size()-2;i >= 0 ; i--) {
	            for(int j=0; j<=1  ; j++) {
	                
	                int max = 0;
	                for(int k = i; k < A.size()-1 ; k++) {
	                    
	                    int max0 = 0;   
	                   
	                    if (j==0 && A.get(i) < A.get(k + 1)) {
	                        max0 = Math.max(max0, 1+dp[k+1][0]);
	                    } 
	                    if (A.get(i) > A.get(k + 1)) {
	                        max0 = Math.max(max0, 1+dp[k+1][1]);
	                    } 
	                    if (max0 > max) {
	                        max = max0;
	                    }
	                    
	                }
	                
	                dp[i][j] = Math.max(max, dp[i][j]);
	            }
	        }
	        
	        int max = dp[0][0];
	        
	        for(int i = 1; i< dp.length-1;i++){
	            max = Math.max(max, dp[i][0]);
	        }
	        
	        return max;
	        
	        
	    }

	public int longestSubsequenceLength0(final List<Integer> A) {
		int max = 0;
		for (int i = 0; i < A.size(); i++) {
			max = Math.max(max, func(A, i, true));
		}
		return max;
	}
	
	HashMap<String,Integer> mem = new HashMap<>();
	private int func(List<Integer> A, int index, boolean isincreasing) {

		if (index == A.size() - 1) {
			System.out.println("called for " + A.get(index) + " " + isincreasing);
			return 1;
		}

		String key = index + " "+ isincreasing;
		if(mem.containsKey(key)) {
			return mem.get(key);
		}
		int max = 1;
		for (int i = index; i < A.size() - 1; i++) {
			int max0 = 1;
			
			if (isincreasing && A.get(index) < A.get(i + 1)) {
				max0 = Math.max(max0, 1 + func(A, i + 1, true));
			}
			
			if (A.get(index) > A.get(i + 1)) {
				max0 = Math.max(max0, 1 + func(A, i + 1, false));
			}
		
			if (max0 > max) {
				max = max0;
			}
		}
		mem.put(key, max);
		System.out.println(A.get(index) + " " + max + " " + isincreasing);
		return max;
	}
}
