package algo;

import java.util.ArrayList;
import java.util.List;

public class firstrepeatingnumber {
	
	
	public static void main(String[] args) {
		
	}
	
	 public int repeatedNumber(final List<Integer> A) {
		 
		 ArrayList<Integer> a = new ArrayList<Integer>(A);
		 
		 for(int i =0; i < a.size() ; i++) {
			 int no = Math.abs(a.get(i));
			 
			 a.set(no-1, -1 * a.get(no-1));
		 }
		 
		 
		 
		 for(int i =0; i< a.size() ; i++) {
			 int no = a.get(i);
			 
			 if(no > 0) {
				 return i + 1;
			 }
		 }
		 
		 return -1;
	    }

}
