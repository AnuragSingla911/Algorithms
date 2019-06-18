package twopiinters;

import java.util.ArrayList;
import java.util.List;

import algo.Utilities;

public class removeGivnElement {
	
	public static void main(String[] args) {
		removeGivnElement obj = new removeGivnElement();
		ArrayList<Integer> list = Utilities.toList(new Integer[] {0});
		System.out.println(obj.removeElement(list, 0));
	}

	  private void swap(List<Integer> x, int y,int z) {
	         int temp = x.get(y);
	         x.set(y, x.get(z));
	         x.set(z, temp);
	     }
	     
	    public int removeElement(ArrayList<Integer> a, int b) {
	        
	        if(a.size() == 0){
	            return 0;
	        }
	        
	       
	        int x = 0;
	        int y = 0;
	        
	        
	        while(x < a.size() && y < a.size()) {
	        		
	        		while(x < a.size()-1 && a.get(x) != b) {
	        			x++;
	        		}
	        		
	        		y = x;
	        		
	        		while(y < a.size()-1 && a.get(y) == b) {
	        			y++;
	        		}
	        		
	        		swap(a, x, y);
	        		x++;y++;
	        		
	        		
	        }
	       
	        
	        int counter = a.size()-1;
	        
	        while(counter >= 0  && a.get(counter) == b) {
	        	a.remove(counter);
	        	counter--;
	        }
	            
	            return a.size();
	        
	    }
}
