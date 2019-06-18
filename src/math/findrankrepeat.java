package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class findrankrepeat {

	public static void main(String[] args) {
		System.out.println(new findrankrepeat().findRank("bbbbaaaa"));
	}

    HashMap<Integer,Long> childMap = new HashMap<Integer,Long>();
	
	 public int findRank(String A) {
		   childMap = new HashMap<Integer,Long>();
	        childMap.put(0,0L);
	        childMap.put(1,1L);
	        long result = 0;
	        
	        for(int i = 0; i <A.length();i++ ){
	            
	        
	            char c = A.charAt(i);
	            char[] arr = A.substring(i).toCharArray();
	            
	            Arrays.sort(arr);
	            
	           String s = new String(arr);
	           
	           int index= s.indexOf(c);
	            
	          
	            long input = index > 0 ? countChild(index-1) : 0;
	            System.out.println(input);
	            
	            result += checkDuplicates(arr, input,c);
	            System.out.println("aft "+result);
	        }
	        
	        return (int)((result+1L) % 1000003L);
	    }
	 
	 private long checkDuplicates(char[] c, long input, char c0) {
		 
		 HashMap<Character, Integer> count = new HashMap<>();
		 boolean is=false;
		 for(int i =0;i <  c.length ; i++) {
			 
			
			 if(count.containsKey(c[i])) {
				 count.put(c[i], count.get(c[i])+1);
			 }else {
				 if(c[i]==c0)
				 count.put(c[i], 0);
				 else
					 count.put(c[i], 1);
					 
			 }
			 
		 }
		 
		 long divide = 1L;
		 
		 for(Integer intt : count.values()) {
			 if(intt>0)
			 divide *= countChild(intt);
		 }
		 System.out.println("div "+ divide);
		 return input/divide;
		 
	 }

	 private long countChild(int no){
	        
	        if(childMap.get(no) != null){
	            return childMap.get(no);
	        }
	        
	        long result = (long)no * countChild(no-1);
	        childMap.put(no, result);
	        return result;
	    }
	 
	 
}
