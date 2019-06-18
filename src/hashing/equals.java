package hashing;

import java.util.ArrayList;
import java.util.HashMap;

import algo.Utilities;

public class equals {

	public static void main(String[] args) {
		ArrayList<Integer> list = Utilities.toList(new Integer[] {
				 0, 0, 1, 0, 2, 1});
		
		Utilities.printArrayList(new equals().equal(list));
	}
	
	
	 public ArrayList<Integer> equal(ArrayList<Integer> A) {
         
	        
         ArrayList<Integer> result = new ArrayList<>();
         
         HashMap<Integer,Point> sumMap = new HashMap<>();
         for(int i =0; i< A.size() ; i++) {
             for(int j =i + 1; j < A.size() ; j++) {
                 
                 int sum = A.get(i) + A.get(j);
                 
                 if(sumMap.containsKey(sum)) {
                	 	Point point = sumMap.get(sum);
                	 	
                	 	if(point.x == i || point.x == j || point.y == i || point.y == j) {
                	 		continue;
                	 	}
                	 	
                	 	int l = point.x;
                	 	int k = point.y;
                	 	
                	 	
                	 	 if(!result.isEmpty()){
                             int tempI = l;
                             int tempJ = k;
                             int tempL = i;
                             int tempK = j;
                             
                             if( (tempI < result.get(0)) ||
                                    ( tempI == result.get(0) && tempJ < result.get(1)) ||
                                    ( tempI == result.get(0) && tempJ == result.get(1) && tempL < result.get(2) )||
                                             (tempI == result.get(0) && tempJ == result.get(1) && tempL == result.get(2) && tempK < result.get(3)) 
                                ) {
                                 result.clear();
                             }else {
                                 continue;
                             }
                         }
                             
                         result.add(l);
                         result.add(k);
                         result.add(i);
                         result.add(j);
                     }else {
                    	 Point point = new Point();
                    	 point.x  = i;
                    	 point.y = j;
                    	 sumMap.put(sum, point);
                 
                 
                 }
                 
                
                
                 
             }
         }
         
         return result;
        }

	
}

class Point {
	int x;
	int y;
}
