package bs;

import java.util.ArrayList;
import java.util.Collections;

import algo.Utilities;

public class insertInSortedArr {

	public static void main(String[] args) {
		ArrayList<Integer> list = Utilities.toList(new Integer[] {1,2,4,5,9});
		insertInSortedArr obj = new insertInSortedArr();
		System.out.println(obj.binarySearch(list, 6));
	}
	
	 public int searchInsert(ArrayList<Integer> a, int b) {
	        int index = binarySearch(a,b);
	        if(index > -1){
	            return index;
	        }else{
	            return Math.abs(index)-1;
	        }
	    }
	 
	 
	 public int binarySearch(ArrayList<Integer> list, int element) {
		 if(list.size() == 0) {
			 return -1;
		 }
		 return binarySearch0(list, element, 0, list.size()-1);
	 }
	 
	 private int binarySearch0(ArrayList<Integer> list, int element, int left, int right) {
		 int middle = (left+right)/2;
		 int no = list.get(middle);
		 
		 if(left> right) {
			 return -(left)-1;
		 }
		 
		 if(no == element) {
			 return middle;
		 }else {
			 if(no > element) {
				 return binarySearch0(list, element, left, middle-1);
			 }else {
				 return binarySearch0(list, element, middle+1, right);
			 }
		 }
		 
	 }
}
