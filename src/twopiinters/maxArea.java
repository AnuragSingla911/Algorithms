package twopiinters;

import java.util.ArrayList;

import algo.Utilities;

public class maxArea {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list= Utilities.toList(new Integer[] {1,22,3,64,5,8,9,11,67,78});
		
		System.out.println(new maxArea().maxArea(list));
		
	}
	

	
	public int maxArea(ArrayList<Integer> A) {
		 
		 int x = 0;
		 int y = A.size()-1;
		 int result = -1;
		 while(x < y) {
			 int n1 = A.get(x);
			 int n2 = A.get(y);
			 boolean isfound = find(x,y,Math.min(n1, n2), A);
			 int r = (y-x) * Math.min(n1, n2);
			 if(result < r) {
				 result=r;
			 }
			 if(isfound) {
				 if(n1 > n2) {
					 y--;
				 }else {
					 x++;
				 }
			 }else {
				 int r1 = (y-x) * Math.min(n1, n2);
				 if(result < r1) {
					 result=r;
				 }
				 break;
			 }
		 }
		 
		 return result < 0 ? 0 : result;
		 
		 
		 
	 }
	 
	 private boolean find(int x,int y, int n1, ArrayList<Integer> list) {
		 
		 
		for(int i =0; i< list.size() ; i++) {
			if(i != x && i != y) {
				if(list.get(i) > n1) {
					return true;
				}
			}
		}
		 
		 return false;
		
		 
	 }
	 
	 
	 

}


