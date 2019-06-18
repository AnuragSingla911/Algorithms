package math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import algo.Utilities;

public class LengthLAndValueC {

	public static void main(String[] args) {
		
		LengthLAndValueC obj = new LengthLAndValueC();
		
		ArrayList<Integer> list = Utilities.toList(new Integer[] { 0, 1, 3, 4, 6, 7});
		
		System.out.println(obj.solve(list, 4, 59172));
		
	}
	
	    public int solve(ArrayList<Integer> A, int B, int C) {
	        
	        if(B > A.size()){
	            return 0;
	        }
	        
	        int temp = C;
	        int length = 0;
	        while(temp > 0){
	            length++;
	            temp = temp/10;
	        }
	        
	       
	        
	        if(B > length){
	            return 0;
	        }else if(B < length){
	        	    if(A.contains(0)){
	            return (int)Math.pow(A.size() , B) * (A.size()-1)/A.size();
	        	    }else {
	        	    	return (int)Math.pow(A.size() , B);
	        	    }
	        }
	        
	        Queue<String> queue = new LinkedList<String>();

	        int counter = B;
	        for(int i =0;i < A.size();i++){
	            queue.add(""+A.get(i));
	        }
	        counter--;
	        while(counter > 0){
	            
	            int count = queue.size();
	            
	            if(Integer.parseInt(queue.peek()) == 0 && B > 1) {
	            		queue.poll();
	            		count--;
	            }
	            
	            while(count > 0){
	                String no = queue.remove();
	                
	                
	                for(int i =0; i < A.size(); i++){
	                    queue.add(no+ A.get(i));
	                }
	                
	                count--;
	                
	                
	            }
	            
	            counter--;
	            
	        }
	        
	        int result =0;
	        while(!queue.isEmpty()){
	            int no = Integer.parseInt(queue.remove());
	            System.out.println(no);
	            if(no < C){
	                result++;
	            }
	        }
	        
	        return result ;
	    }
	

}
