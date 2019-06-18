package hashing;

import java.util.HashMap;

public class subsequencesumtozero {

	public static void main(String[] args) {
		int[] arr = new int[] {-19, 8, 2, -8, 19, 5, -2, -23};
		
		new subsequencesumtozero().lszero(arr);
	}
	
	
		
	  public int[] lszero(int[] A) {
	        
	        int[] sum = new int[A.length];
	        
	        sum[0] = A[0];
	        int start = -1;
	        int end = -1;
	        for(int i =1; i< A.length  ; i++) {
	            sum[i] = sum[i-1] + A[i];
	            if(sum[i] == 0) {
	                start = 0;
	                end = i;
	            }
	            
	        }
	        
	        int finalstart = start;
	        int finalend = end;
	        
	        HashMap<Integer,Integer> map = new HashMap<>();
	        
	        for(int i = 0; i < sum.length ; i++) {
	            if(map.containsKey(sum[i])) {
	                start = map.get(sum[i]);
	                end = i;
	                
	                if(finalstart == -1 || (end-(start+1) > finalend-finalstart)) {
	                    finalstart = start+1;
	                    finalend = end;
	                }
	            }else {
	                map.put(sum[i], i);
	            }
	        }
	        
	        int[] result = new int[finalend-finalstart];
	        
	        for(int i = finalstart ; i<= finalend ; i++) {
	            result[i-(finalstart)] = A[i];
	        }
	        
	        return result;
	  }
	
	
	
}
