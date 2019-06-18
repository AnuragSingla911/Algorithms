package bs;

import java.util.Collections;
import java.util.List;

import algo.Utilities;

public class medianinsortedarrays {
	
	public static void main(String[] args) {
		medianinsortedarrays obj = new medianinsortedarrays();
		List<Integer> a = Utilities.toList(new Integer[] { -50, -41, -40, -19, 5, 21, 28});
		List<Integer> b = Utilities.toList(new Integer[] { -50, -21, -10});
		System.out.println(obj.findMedianSortedArrays(a, b));

	}

	 
	  public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
	        
	        int[] merge = new int[a.size() + b.size()];
	        
	        int x = 0;
	        int y = 0;
	        int z = 0;
	        while(x < a.size() && y < b.size()){ 
	            if(a.get(x) <= b.get(y)){
	                merge[z++] = a.get(x++);
	            }else{
	                merge[z++] = b.get(y++);
	            }
	        }
	        
	        while(x < a.size()){
	             merge[z++] = a.get(x++);
	        }
	        
	        while(y < b.size()){
	             merge[z++] = b.get(y++);
	        }
	        
	        if(merge.length == 1){
	            return merge[0];
	        }
	        
	        if(merge.length % 2 == 0){
	        	System.out.println(merge[merge.length/2]);
	        	System.out.println(merge[(merge.length/2)+1]);
	            return (merge[(merge.length/2)-1]+ merge[merge.length/2])/2;
	        }
	        
	        
	        return merge[(merge.length/2)+1];
	        
	    }
	 private void find(final List<Integer> a, final List<Integer> b) {
		 int desired = (a.size() + b.size())/2;
		 
		 int max = a.get(a.size()-1) > b.get(b.size() -1) ? a.get(a.size()-1) :  b.get(b.size() -1);
		 int min = a.get(0) < b.get(0) ? a.get(0) : b.get(0);
		 
		 int middle = (min+max)/2;
		 
		 int noofElements = Collections.binarySearch(a, middle);
		 
		 if(noofElements < 0) {
			 noofElements = Math.abs(noofElements) -1;
		 }
		 
		 int x = Collections.binarySearch(b, middle);
		 
		 if(x < 0) {
			 x = Math.abs(x)-1;
		 }
		 
		 int total = noofElements + x;
		 
		 if(total < desired) {
			 
		 }
		 
	 }
}
