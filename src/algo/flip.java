package algo;

import java.util.ArrayList;

public class flip {
	
	public static void main(String[] args) {
		
		flip oj = new flip();
		String s = "1101010001";
		
		Utilities.printArrayList(oj.flip(s));
		
		
	}
	
	    public ArrayList<Integer> flip(String A) {
	        
	        int finalLeft = -1;
	        int finalRight = -1;
	        
	        int finalNoOfZero = 0;
	        
	        
	        int left =0;
	        int right =0;
	        
	        int noOfZero = 0;
	        boolean isAvialable = true;
	        for(int i =0; i< A.length() ; i++){
	            
	            int no = Integer.parseInt(""+ A.charAt(i));
	            
	            if(no == 0){
	                noOfZero++;
	                if(noOfZero == 1 && isAvialable){
	                	isAvialable = false;
	                    left = i;
	                    right = i;
	                }{
	                    right = i;
	                }
	                
	                
	            }else{
	            		
	                noOfZero--;
	                
	                if(noOfZero < 0) {
	                	isAvialable = true;
	                	noOfZero =0;
	                }
	            }
	            
	            if(finalNoOfZero < noOfZero){
	                finalLeft = left;
	                finalRight = right;
	                finalNoOfZero = noOfZero;
	            }
	            
	            
	            
	            
	            
	            
	        }
	        
	        
	        if(finalLeft > -1) {
	        ArrayList<Integer> result = new ArrayList<>();
	        result.add(finalLeft);
	        result.add(finalRight);
	        return result;
	        }
	        return new ArrayList<>();
	    }
	
	    


}
