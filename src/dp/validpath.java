package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import algo.Utilities;

public class validpath {
	
	
	
	public static void main(String[] args) {
		ArrayList<Integer> list = Utilities.toList(new Integer[] {
				40,6,36,38,23,54
					});		
		
		ArrayList<Integer> lis1t = Utilities.toList(new Integer[] {
				88,14,50,10,15,5
					});		
		
		System.out.println(new validpath().solve(58, 91, 6, 8, list, lis1t));
	}

	 public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
		 
		 
		HashMap<Point, Boolean> map = new HashMap<Point, Boolean>();
		
		int A0 = A;
		A = A+1;
		int B0 = B;
		B = B+1;
		
		for(int i =0; i<C ; i++) {
			int x = E.get(i);
			int y = F.get(i);
			
			for(int k = x-D; k <= x+D ; k++) {
				for(int l = y-D; l <= y+D ; l++) {
					if(k >= 0 && k < A && l >= 0 && l < B) {
						map.put(new Point(k,l),true);
					}
				}
			}
		}
		
		Point zero = new Point(0,0);
		
		if(map.get(zero) != null && map.get(zero)) {
			return "NO";
		}
		
		 Stack<Point> xQueue = new Stack<Point>();
		 
		 xQueue.add(zero);
		 
		 
		 
		 while(!xQueue.isEmpty()) {
			 Point point = xQueue.pop();
			 System.out.println(point.x + " "+ point.y);
			 if(point.x == A0 && point.y == B0) {
				 return "YES";
			 }
		 
			 map.put(point, true);
			 if(point.x > 0) {
				 Point p0 = new Point(point.x-1,point.y);
				  if(map.get(p0) == null || !map.get(p0)) {
					  if(!xQueue.contains(p0)) {
						  xQueue.add(p0);
					  }
				  }
			 }
			 
			 int x = point.x;
			 int y = point.y;
			 if(point.y > 0) {
				 Point p0 = new Point(x,y-1);
				 if(map.get(p0) == null || !map.get(p0)) {
					 if(!xQueue.contains(p0)) {
						  xQueue.add(p0);
					  }
				 }	 
			 }
			
			 
			 if(x > 0 && y > 0) {		 
				 Point p0 = new Point(x-1,y-1);
				 if(map.get(p0) == null || !map.get(p0)) {
					 if(!xQueue.contains(p0)) {
						  xQueue.add(p0);
					  }
				 }
			 }
			 
			 if(x > 0 && y < B-1) {
				 Point p0 = new Point(x-1,y+1);
				 if(map.get(p0) == null || !map.get(p0)) {
					 if(!xQueue.contains(p0)) {
						  xQueue.add(p0);
					  }
				 }
			 }
			 
			 if(y > 0 && x < A-1 ) {
				 Point p0 = new Point(x+1,y-1);
				 
				 if(map.get(p0) == null || !map.get(p0)) {
					 if(!xQueue.contains(p0)) {
						  xQueue.add(p0);
					  }
				 }
			 }
			 
			 if(y < B-1) {
				 Point p0 = new Point(x,y+1);
				 
				 if(map.get(p0) == null || !map.get(p0)) {
					 if(!xQueue.contains(p0)) {
						  xQueue.add(p0);
					  }
				 }
			 }
			 
			 if(x < A-1) {
				 Point p0 = new Point(x+1,y);
				 
				 if(map.get(p0) == null || !map.get(p0)) {
					 if(!xQueue.contains(p0)) {
						  xQueue.add(p0);
					  }
				 }
			 }
			 
			 if(x < A-1 && y < B-1) {
				 Point p0 = new Point(x+1,y+1);
				 
				 if(map.get(p0) == null || !map.get(p0)) {
					 if(!xQueue.contains(p0)) {
						  xQueue.add(p0);
					  }
				 }
			 }
			 }
		 
		 return "NO";
		 
		 
	 
	 
		 }
	
		 
}
	 
	  class Point {
		 int x;
		 int y;
		 
		 Point(int x,int y){
			 this.x = x;
			 this.y = y;
		 }
		 
		 @Override
		public int hashCode() {
			return (x+y) * x * y;
		}
		 
		 @Override
		public boolean equals(Object obj) {
			if(obj instanceof Point) {
				return ((Point) obj).x == this.x && ((Point) obj).y == this.y ? true : false;
			}
			return false;
		}
	 }
	
	 
