package greedy;

import java.util.ArrayList;
import java.util.Collections;

import algo.Utilities;

public class seats {
	
	public static void main(String[] args) {
		//x.x.xx.x.xxx.......x..x.xxx..x.xxx
        	  	
		System.out.println(new seats().seats("....x..xx...x.."));

	}
	
	 public int seats(String A) {
		 
		
		 int sum = 0;
		 int no = 0;
		 for(int i =0; i< A.length() ; i++) {
			 char c = A.charAt(i);
			 if(c == 'x') {
				 sum+= i;
				 no++;
			 }
		 }
		 
		 if(no<2){
             return 0;
         }
		 
		 int median = no%2 == 0 ? no/2+1 : no/2;
		
		 
		 
		 int left =median-1 ;
		 int targetLeft = left;
		 int right =  median;
		 int targetright = right;
		 int result = 0;
		 
		 while(left >= 0) {
			 char c = A.charAt(left);
			 if(c == 'x') {
				 result+= (targetLeft-left);
				 System.out.println(result);
					targetLeft--;
			 }
			 left--;
		 }
		 
		 while(right < A.length()) {
			 char c = A.charAt(right);
			 if(c == 'x') {
				 result+= (right-targetright);
				System.out.println(result);
					targetright++;
			 }
			 right++;
		 }
		 
		 
		 return result;
		
	    }

}
