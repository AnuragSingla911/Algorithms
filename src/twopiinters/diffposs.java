package twopiinters;

import java.util.ArrayList;

import algo.Utilities;

public class diffposs {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = Utilities.toList(new Integer[] {
				1,2,2,3,4
		});
		
		System.out.println(new diffposs().diffPossible(list, 0));
	}
	 public int diffPossible(ArrayList<Integer> A, int B) {
	        
	        if(A.size() < 2){
	            return 0;
	        }
	        
	        int x = 0;
	        int y = 1;
	        
	        while(y < A.size()){
	            int diff = A.get(y) - A.get(x);
	            
	            if(diff == B){
	                return 1;
	            }else if(diff > B){
	                if(x < y-1){
	                    x++;
	                }else{
	                    y++;
	                }
	            }else{
	                y++;
	            }
	        }
	        
	        return 0;
	    }
}
