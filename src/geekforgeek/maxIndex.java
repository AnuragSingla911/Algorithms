package geekforgeek;

import java.util.Scanner;

public class maxIndex {
	/*package whatever //do not write package name here */

	
	    
	/*package whatever //do not write package name here */

	    
	    private static int func(int[] arr){
	        int low = arr[0];
	        int i = 0;
	        int j = 0;
	       
	        int jmax = 0;
	        int max = 0;
	        while(i < arr.length){
	            
	            
	            while(i < arr.length && arr[i] > low){
	                i++;
	            }
	            
	            if(i >= arr.length){
	                break;
	            }
	            
	            low = arr[i];
	           
	            j = jmax;
	          
	            
	            while(j < arr.length){
	                if(arr[j] >= arr[i] && j-i > max){
	                    max = j-i;
	                  jmax = j;
	                }
	                j++;
	            }
	            
	            i++;
	            
	            
	        }
	        
	        return max;
	    }
		
		public static void main (String[] args) {
			Scanner sc = new Scanner(System.in);
			
			int t = sc.nextInt();
			
			for(int i =0;i < t; i++){
			    int size = sc.nextInt();
			    int[] arr = new int[size];
			    
			    for(int k =0; k < size ; k++){
			        arr[k] = sc.nextInt();
			    }
			    
			    int result = func(arr);
			    
			    System.out.println(result);
			}
		}
	
}
