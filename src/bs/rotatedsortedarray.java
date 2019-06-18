package bs;

import java.util.List;

import algo.Utilities;

public class rotatedsortedarray {

	public static void main(String[] args) {
		rotatedsortedarray obj = new rotatedsortedarray();
		List<Integer> a = Utilities.toList(new Integer[] {
				1,2,3,4,5,6
				});
		System.out.println(obj.search(a, 1));
	}
	
	
	    // DO NOT MODIFY THE LIST
	    public int search(final List<Integer> a, int b) {
	        
	        return search0(a,0,a.size()-1,b);
	    }
	    
	    private int search0(List<Integer> a, int left,int right,int b){
	        
	        
	        if(left > right){
	            return -1;
	        }
	        
	        int middle = (left+right)/2;
	        
	        int no = a.get(middle);
	        
	        if(no == b){
	            return middle;
	        }else {
	        int last = a.get(right);
	        int first = a.get(left);
	        if(b == first) {
	        	return left;
	        }else
	        if(no < first){
	            if(b > first || b < no){
	                return search0(a,left,middle-1, b);
	            }else if(b > no){
	                return search0(a,middle+1,right,b);
	            }
	        }else{
	            if(b > first && b < no){
	               return search0(a,left,middle-1, b);
	            }else if(b > first && b > no){
	                return search0(a,middle+1,right,b);
	            }else if(b < first && b < no){
	                return search0(a,middle+1,right,b);
	            }
	        }
	        }
	      return -1;  
	    }
	

}
