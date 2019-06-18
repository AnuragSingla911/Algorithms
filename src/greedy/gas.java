package greedy;

import java.util.ArrayList;
import java.util.List;

import algo.Utilities;

public class gas {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = Utilities.toList(new Integer[] {
				811, 753, 83, 451, 85, 753, 547, 898, 824, 717, 680, 364, 559, 128, 545, 272, 972, 299, 965, 957, 963, 449, 723, 989, 49, 57, 21, 253, 646, 817, 614, 309, 491, 7, 611, 343, 530, 341, 267, 591, 724, 563, 739, 959, 880, 718, 674, 873, 870, 536, 694, 625, 217, 522, 880, 498, 768, 17, 25, 359, 456, 324, 240, 936, 718, 295, 532, 156, 930, 485
		});		
		
		ArrayList<Integer> list1 = Utilities.toList(new Integer[] {
				273, 776, 627, 235, 813, 793, 344, 350, 775, 477, 702, 675, 482, 666, 898, 146, 704, 996, 882, 615, 408, 693, 144, 2, 250, 812, 114, 693, 717, 286, 135, 239, 591, 192, 850, 222, 283, 660, 87, 619, 233, 279, 932, 886, 409, 143, 834, 518, 529, 992, 177, 190, 171, 775, 294, 921, 904, 396, 185, 719, 848, 770, 117, 166, 317, 22, 74, 810, 50, 2 
		});		
		
		System.out.println(new gas().canCompleteCircuit(list, list1));
		
	}
	 public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
	     int sumgas = A.get(0);
	     
	     for(int a : A){
	         sumgas+= a;
	         
	     }
	     
	     
	     int sumCost = B.get(0);
	     
	     for(int b : B){
	         sumCost+= b;
	       
	     }
	     
	     if(sumCost > sumgas){
	         return -1;
	     }
	     
	     int totalDiff = sumgas - sumCost;
	    // System.out.println("total : "+ totalDiff);
	     sumgas = 0;
	     sumCost = 0;
	     int startpoint = 0;
	    
	     int balanceDiff = 0;
	    
	     for(int i = 0; i< A.size() ; i++){
	         sumgas+= A.get(i);
	         sumCost+= B.get(i);
	         int diff0 = sumgas - sumCost;
	         //int diff2 = A.get(i)-B.get(i);
	      
	         System.out.println(i + " "+sumgas + " "+ sumCost + " "+ diff0);
	         if(diff0 < 0){

	        	 //balanceDiff += diff0;
	        	 
	        	 sumgas=0;
	        	 sumCost=0;
	        
	             startpoint = i+1;
	            // System.out.println("start : "+ startpoint + " "+ balanceDiff);
	         }
	     }
	     //System.out.println("ex[ected was : "+ A.get(2) + " "+ B.get(2));
	     return startpoint;
	  
	    }
	
}
