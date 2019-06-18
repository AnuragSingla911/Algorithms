package hackerrank;

import java.util.HashMap;

public class NonDivisibleSubArray {
	public static void main(String[] args) {
		// 19 10 12 22 24 25
		// 4
		//  3  2  0  2  0  1
		// 278 576 496 727 410 124 338 149 209 702 282 718 771 575 436
		// 7 
		//  6   2   6   6    4  5   2   2   6   2   2   4   1   1   2
		
		//6 6 6 6  2 2 2 2 2 
		// 1 1 2 2 2 2 2 
		
		int[] input = new int[] {1,2,3,4,5,6,7,8,9,10};
		
		System.out.println(nonDivisibleSubset(4, input));
		
	}
	
	static int nonDivisibleSubset(int k, int[] S) {

        for(int i =0; i< S.length ; i++) {
        		S[i] = S[i] % k;
        }
        
        HashMap<Integer, Integer> count = new HashMap<>();
        
        for(int i =0; i< S.length ; i++) {
        		if(count.containsKey(S[i])) {
        			count.put(S[i], count.get(S[i]) + 1);
        		}else {
        			count.put(S[i], 1);
        		}
        }
        int total = 0;
        for(int i = 1; i<= k/2 ; i++) {
        	
        		if(i != k-i) {
        		int v1 = count.get(i);
        		int v2 = count.get(k-i);
        		
        		total+= Math.max(v1, v2);
        		}
        }
        
        
        if(count.containsKey(0)) {
        		total++;
        }
        for(int i =0; i< S.length ; i++) {
        		if(S[i] % k/2 == 0 && S[i] != 0) {
        			total++;
        			break;
        		}
        }
        
        return total;

    }
	
	
}
