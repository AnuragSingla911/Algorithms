package bs;

import java.util.ArrayList;
import java.util.Collections;

import algo.Utilities;

public class searchin2dsortedmatrix {
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> a = Utilities.toList(new Integer[][] {{1},{4,7},{8}});
		
		searchin2dsortedmatrix obj = new searchin2dsortedmatrix();
		System.out.println(obj.searchMatrix(a, 0));
		
	}
	
	 public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
	        
	        ArrayList<Integer> x = new ArrayList<Integer>();
	        for(int i =0; i< a.size(); i++){
	            x.add(a.get(i).get(0));
	        }
	        
	        int index = Collections.binarySearch(x, (Integer)b);
	        
	        if(index > -1){
	            return 1;
	        }else{
	            int pos = Math.abs(index + 1);
	            System.out.println(pos);
	            
	            
	            int index2 = Collections.binarySearch(a.get(pos-1), (Integer)b);
	            if(index2 > -1){
	                return 1;
	            }
	        }
	        return 0;
	    }

}
