package algo;

import java.util.ArrayList;
import java.util.List;

public class searchRange {
	
	public static void main(String[] args) {
		
		
		
		ArrayList<Integer> t = Utilities.toList(new Integer[] {
1,1,2	,2,3,4,5,9,10,10,10			});
		
		
		
		searchRange obj = new searchRange();
		obj.searchRange(t, 1);
		
		
		

		
	}
	
	   public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
		   
		   
		   ArrayList<Integer> result= new ArrayList<Integer>();
		   startIndex=-1;
		   endIndex=-1;
		   search(a, b,0,a.size()-1);
		   if(startIndex==-1||endIndex==-1) {
			   result.add(-1);result.add(-1);
		   }else {
			   result.add(startIndex);
			   result.add(endIndex);
		   }
		   
		   Utilities.printArrayList(result);
		   
		   return result;
	        
	       
	    }
	   
	   public void search(List<Integer> a,int b,int left,int right) {
           if(a.size()==0) {
               return;
           }

            
            if(left > right){
                return;
            }
           int middle = (right+left)/2;
           
           if(a.get(middle) == b){
               if(middle > 0 && a.get(middle-1) == b){
                   search(a,b,left,middle-1);
               }else{
                   startIndex = middle;
               }
               
               if(middle < a.size()-1 && a.get(middle+1) == b){
                   search(a,b,middle+1, right);
               }else{
                   endIndex = middle;
               }
           }else if(a.get(middle) > b){
               search(a,b,left,middle-1);
           }else{
               search(a,b,middle+1, right);
           }
       }
	   
	    
	    private int startIndex = -1;
	    private int endIndex = -1;

}
