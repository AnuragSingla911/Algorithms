package twopiinters;

import java.util.Arrays;

public class nooftrainhgles {

	public static void main(String[] args) {
		nooftrainhgles obj = new nooftrainhgles();
		int[] arr = new int[] {4, 6, 13, 16, 20, 3, 1, 12};
		Arrays.sort(arr);
		System.out.println(obj.nTriang(arr));
	}
	
	 public int nTriang(int[] A) {
		 
		 int count = 0;
		 
		 if(A.length < 3) {
			 return 0;
		 }
		 
		 int x = 0;
		 int y = 0;
		 
		 int z = A.length-1;
		 
		 while(z > 1) {
			 x = 0;
			 y = 1;
			 while(x <= z-2) {
				 y=x+1;
				 while(y <= z-1) {
				 if(A[x]+ A[y] > A[z]) {
					 count++;
					
				 }
					 y++;
				 }
				 x++;
				 
				 
			 }
			 z--;
		 }
		 
		 return count;
	    }
}
