package hashing;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class colourfull {

	public static void main(String[] args) {
		System.out.println(new colourfull().colorful(263));
	}
	
	 public int colorful(int A) {
	        
	        HashMap<Integer,Integer> map = new LinkedHashMap();
	        
	        while(A > 0){
	            int t = A%10;
	            if(map.get(t) == null) {
	            map.put(t, 1);
	            }else {
	            	System.out.println(t);
	            	return 0;
	            }
	            
	            A = A/10;
	        }
	        
	        Integer[] arr = map.keySet().toArray(new Integer[] {});
	        int prod = 1;
	        for(int i =0; i< arr.length ; i++) {
	        	prod = arr[i];
	        		for(int j = i+1; j < arr.length; j++) {
	        			
	        			prod = prod * arr[j];
	        			
	        			if(map.containsKey(prod)) {
	    	            	System.out.println(prod);
	        				return 0;
	        			}else {
	        				map.put(prod, 1);
	        			}
	        		}
	        }
	        
	        return 1;
	        
	       
	        
	        
	    }
}
