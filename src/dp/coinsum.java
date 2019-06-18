package dp;

import java.util.ArrayList;
import java.util.HashMap;

import algo.Utilities;

public class coinsum {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = Utilities.toList(new Integer[] {
				1,2,3
		});
		
		System.out.println(new coinsum().coinchange2(list, 4));
	}
	
	public int coinchange2(ArrayList<Integer> A, int B) {
        int[] dp = new int[B+1];
        
        dp[0]=1;
        
        for(int i=0;i<A.size();i++){
            for(int j=A.get(i);j<=B;j++)
            {
                dp[j]=(dp[j]+dp[j-A.get(i)])%1000007;
                System.out.println(dp[j]);
            }
        }
        return dp[B];
    }
	
	 public int coinchange24(ArrayList<Integer> A, int B) {
		 
		 long[][] count = new long[A.size()+1][B+1];
		 
		 for(int i =1; i< count.length ; i++) {
			 
			 for(int j = 1; j < count[i].length ; j++) {
				 
				 if(j == A.get(i-1)) {
					 count[i][j]++;
				 }
				 
				 count[i][j] += count[i-1][j];
				 
				 if(j > A.get(i-1)) {
					 count[i][j] += count[i][j-A.get(i-1)];
				 }
				 
				 
			 }
		 }
		 
		 return (int)(count[A.size()][B]% 1000007);
	 }
	
	HashMap<String, Integer> map = new HashMap<>();
	 public int coinchange23(ArrayList<Integer> A, int B) {
	        return find(A,B,A.size());
	    }
	    
	    private int find(ArrayList<Integer> A, int remainSum, int index) {
	    	
	    	if(remainSum == 0) {
	    		return 1;
	    	}
	    	
	    	if(remainSum < 0) {
	    		return 0;
	    	}
	    	
	    	if(index < 1) {
	    		return 0;
	    	}
	    	
	    	String key = remainSum + " "+ index;
	    	
	    	if(map.containsKey(key)) {
	    		return map.get(key);
	    	}
	    	
	    	int c = find(A, remainSum, index-1) + find(A, remainSum-A.get(index-1), index);
	    	c= c%1000007;
	    	map.put(key, c);
	    	
	    	return c;
	    	
	    		
	    }
}
