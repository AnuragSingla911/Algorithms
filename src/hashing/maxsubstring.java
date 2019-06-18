package hashing;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class maxsubstring {
	
	public static void main(String[] args) {
		System.out.println(new maxsubstring().lengthOfLongestSubstring("abccdbcbcbdcbcbd"));
	}

	
	 public int lengthOfLongestSubstring(String A) {
	        
	        int length = 0;
	        
	        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
	        
	        
	        int i =0;
	        int finalLength = length;
	        while(i< A.length()){
	            char c = A.charAt(i);
	            
	            if(!map.containsKey(c)){
	                length++;
	                if(length > finalLength) {
	                	finalLength = length;
	                }

	                map.put(c, i);
	                i++;
	            }else{
	            	    
	                int index  = map.get(c);
	                
	                
	                
	                
	                length = i-index;
	                if(length > finalLength) {
	                	finalLength = length;
	                }
	                Character[] keys = map.keySet().toArray(new Character[] {});
	                
	                int keysSize = map.size()-length;
	                int ii =0;
	                while(keysSize >= 0) {
	                		map.remove(keys[ii++]);
	                		keysSize--;
	                }
	                
	                
	                
	                map.put(c, i);
	                i++;
	            }
	        }
	        
	        return finalLength;
	        
	        
	    }
}
