package tree;

import java.util.ArrayList;
import java.util.Collections;

import algo.Utilities;

public class orderofheightoftree {
	
	public static void main(String[] args) {
		ArrayList<Integer> A = Utilities.toList(new Integer[] {5,3,2,6,1,4});
		ArrayList<Integer> B = Utilities.toList(new Integer[] {0,1,2,0,3,2});
		Utilities.printArrayList(new orderofheightoftree().order(A, B));
	}

	 public ArrayList<Integer> order(ArrayList<Integer> A, ArrayList<Integer> B) {
		 
		 ArrayList<Data> list = new ArrayList<>();
		 
		 for(int i =0; i< A.size() ; i++) {
			 Data d = new Data();
			 d.height = A.get(i);
			 d.inFront = B.get(i);
			 list.add(d);
		 }
		 
		 Collections.sort(list);
		 
		 
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 for(int i =0; i< A.size() ; i++) {
			 result.add(Integer.MAX_VALUE);
		 }
		 
		 for(int i =0; i< list.size() ; i++) {
			 Data d = list.get(i);
			 int index = d.inFront;
			 
			 int j = 0;
			 int k =0;
			 while(k < list.size()) {
				 
				 if(j == index && result.get(k) == Integer.MAX_VALUE) {
					 break;
				 }
				 if(result.get(k) == Integer.MAX_VALUE) {
					// System.out.println("incrementing j "+ j + " "+ k);
					 j++;
				 }
				 k++;
				
			 }
			// System.out.println(k + " "+ d.height);
			 result.set(k, d.height);
			 
			
		 }
		 
		 return result;
		 
	    }
	 
	 
	 class Data implements Comparable<Data>{
		 int height;
		 int inFront;
		 
		 @Override
		public int compareTo(Data o) {
			// TODO Auto-generated method stub
			return o.height > this.height ? -1: 1;
		}
	 }
}
