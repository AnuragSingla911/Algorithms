package twopiinters;

import java.util.ArrayList;

import algo.Utilities;

public class setcolors {
	
	public static void main(String[] args) {
		setcolors obj = new setcolors();
		ArrayList<Integer> list = Utilities.toList(new Integer[] {0});
		obj.sortColors(list);
		
		Utilities.printArrayList(list);
	}

	 public void sortColors(ArrayList<Integer> a) {
	        int[] count = new int[3];
	        
	        
	        for(int i =0; i< a.size(); i++){
	            count[a.get(i)]++;
	        }
	        
	       
	        int counter = 0;
	        
	        while(counter < a.size()){
	            
	            while(counter < count[0]){
	                a.set(counter++, 0);
	            }
	            while(counter < count[0] + count[1]){
	                a.set(counter++, 1);   
	            }
	            
	            while(counter < count[0] + count[1] + count[2]){
	                a.set(counter++, 2);
	            }
	             
	            
	        }
	       
	    }
}
