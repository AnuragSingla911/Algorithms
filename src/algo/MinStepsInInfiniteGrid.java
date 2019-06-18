package algo;

import java.util.ArrayList;
import java.util.Arrays;

public class MinStepsInInfiniteGrid {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4, 8, -7, -5, -13, 9, -7, 8));
		ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(4, -15, -10, -3, -13, 12, 8, -8));

		System.out.println(new MinStepsInInfiniteGrid().coverPoints(list, list1));
	}
	
	   public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
		   
		   int x = A.get(0);
		   int y = B.get(0);
		   
		   int currentPointCovering = 0;
		   
		   int steps = 0;
		   
		   while(currentPointCovering < A.size()) {
			   int coveringX = A.get(currentPointCovering);
			   int coveringY = B.get(currentPointCovering);
			   int stepsForthis = 0;
			   while(true) {
				   if(coveringX == x && coveringY == y) {
					   currentPointCovering++;
					   break;
				   }else {
					   stepsForthis++;
					   if(coveringX > x) {
						   x++;
					   }else if(coveringX < x) {
						   x--;
					   }
					   
					   if(coveringY > y) {
						   y++;
					   }else if(coveringY < y) {
						   y--;
					   }
				   }
				   
				  
				  
			   }
			   steps = steps + stepsForthis;
		   }
		   
		   return steps;
		   
		   
		   
	    }
	   
	   public void movePointer(int x, int y, int coveringX,int coveringY) {
		   
		  
	   }

}
