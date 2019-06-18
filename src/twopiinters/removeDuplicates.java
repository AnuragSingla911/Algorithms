package twopiinters;

import java.util.ArrayList;
import java.util.List;

import algo.Utilities;

public class removeDuplicates {
	
	public static void main(String[] args) {
		removeDuplicates obj = new removeDuplicates();
		ArrayList<Integer> list = Utilities.toList(new Integer[] {0,1,1,1,2});
		System.out.println(obj.removeDuplicates(list));
	}

	 public int removeDuplicates(ArrayList<Integer> a) {
	        
	        if(a.size() < 3){
	            return a.size();
	        }
	        
	        
	        int x = 0;
	        int y = 1;
	        int z = 2;
	        int isDuplicate = 0;
	        int count = 0;
	        while(z < a.size()){
	            int no = a.get(x);
	            int no0 = a.get(y);
	            int no1 = a.get(z);
	            if(no == no0 && no0 == no1){
	            	count++;
	                isDuplicate++;
	                z++;
	            }
	            else {
	                isDuplicate--;
	                x++;
	                y++;
	                swap(a, y, z);
	                z++;
	                
	            }
	            
	        }
	        while(count > 0) {
	        		a.remove(a.size()-1);
	        		count--;
	        }
	        return a.size();
	    }
	 
	 private void swap(List<Integer> x, int y,int z) {
		 int temp = x.get(y);
		 x.set(y, x.get(z));
		 x.set(z, temp);
	 }
}
