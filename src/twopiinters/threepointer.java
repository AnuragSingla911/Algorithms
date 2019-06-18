package twopiinters;

import java.util.List;

public class threepointer {

	 public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
		 
		 
		 if(A.size() == 0 || B.size() == 0 || C.size() == 0) {
			 return Integer.MAX_VALUE;
		 }
		 
		 
		 int x =0,y=0, z =0;
		 
		 int min = Integer.MAX_VALUE;
		 int first = -1;
		 int second = -1;
		 int third = -1;
		 while(x < A.size() || y < B.size() || z < C.size()) {
			 if(x  <A.size()) {
			  first= A.get(x);
			 }
			 if(y < B.size()) {
			 second = B.get(y);
			 }
			 if(z < C.size()) {
			 third = C.get(z);
			 }
			 
			 int max = max(first,second,third);
			 if(max < min) {
				 min = max;
			 }
			 
			 if(first > second) {
				 if(second > third && z < C.size()-1) {
					 z++;
				 }else if(y < B.size()-1){
					 y++;
				 }else if(x < A.size()-1){
					 x++;
				 }else {
					 break;
				 }
			 }else {
				 if(first > third && z < C.size()-1) {
					 z++;
				 }else if(x < A.size()-1){
					 x++;
				 }else if(y < B.size()-1){
					 y++;
				 }else {
					 break;
				 }
			 }
			 
			 
		 }
		 
		 return min;
	    }
	 
	
	 private int max(int x,int y,int z) {
		 int first= Math.abs(x-y);
		 int second = Math.abs(y-z);
		 int third = Math.abs(z-x);
		 
		 return Math.max(first, Math.max(second, third));
	 }
}
