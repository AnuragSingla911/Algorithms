package math;

import java.util.List;

import algo.Utilities;

public class hamDis {
	
	public static void main(String[] args) {
		hamDis obj = new hamDis();
		List<Integer> A = Utilities.toList(new Integer[] { 96, 96, 7, 81, 2, 13 });
		System.out.println(obj.hammingDistance(A));
	}

	 public int hammingDistance(final List<Integer> A) {
	        
	        int sum =0;
	        
	        for(int i =0; i< A.size(); i++){
	            for(int j=0; j < A.size(); j++){
	                sum+= hamDis(A.get(i), A.get(j));
	            }
	        }
	        return sum;
	    }
	    
	    public int hamDis(int x,int y){
	    	System.out.print(" diff btn "+ x + " and "+ y + " is ");
	        int no = 0;
	        while(x > 0 || y > 0){
	            if(x > 0 && y > 0){
	                if(x % 2 != y % 2){
	                    no++;
	                }
	                x = x/2;
	                y = y/2;
	            }else{
	                x = x/2;
	                y = y/2;
	                no++;
	            }
	        }
	    	System.out.println(no);
	        return no;
	    }
}
