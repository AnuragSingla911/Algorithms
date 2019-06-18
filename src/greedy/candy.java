package greedy;

import java.util.ArrayList;
import java.util.Arrays;

import algo.Utilities;

public class candy {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = Utilities.toList(new Integer[] {
				 104, -460, 206, -391, 112, 455, -287, 140, 140, 422, 482, -335, -348
					});		
		System.out.println(new candy().candy0(list));
		
	}
	
	 public int candy(ArrayList<Integer> A) {
	        int n=A.size();
	        int[] candies=new int[n];
	        Arrays.fill(candies,1);
	        for(int i=0;i<n-1;i++){
	            if(A.get(i+1)>A.get(i))
	                candies[i+1]=candies[i]+1;
	        }
	        for(int i=n-1;i>0;i--){
	            if(A.get(i-1)>A.get(i) && candies[i-1]<=candies[i])
	                candies[i-1]=candies[i]+1;
	        }
	        int sum=0;
	        for(int i=0;i<n;i++){
	            sum+=candies[i];
	        }
	        return sum;
	    }
	    

	 public int candy0(ArrayList<Integer> A) {
	     
	     int noofcandies = 1;
	     int current = 1;
	     int[] candies = new int[A.size()];
	     
	     candies[0] = 1;
	     
	     for(int i =1; i< A.size() ; i++){
	         if(A.get(i) > A.get(i-1)){
	             current++;
	             noofcandies+= current;
	            
	         }else{
	             if(current == 1){
	                for(int j = i; j > 0 ; j--){
	                    if(candies[j-1] - candies[j] == 0 || candies[j-1] - candies[j] == 1){
	                    	 	
	                        noofcandies++;
	                        
	                        if(j == 1) {
	                        	
	                    			candies[0]++;
	                    		
	                        }
	                    }else{
	                    		for(int k = i-1; k > j-1 ; k--) {
	                    			candies[k]++;
	                    		}
	                        break;
	                    }
	                }
	             }
	             current=1;
	            
	             noofcandies+= current;
	         }
	         candies[i] = current;
	     }
	     return  noofcandies;
	    }
}
