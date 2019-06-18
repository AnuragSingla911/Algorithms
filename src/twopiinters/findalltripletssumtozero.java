package twopiinters;

import java.util.Arrays;

public class findalltripletssumtozero {

	public static void main(String[] args) {
		findalltripletssumtozero obj = new findalltripletssumtozero();
		int[] arr = new int[] {
				 1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3
		};
		System.out.println(obj.threeSum(arr));
	}
	
	//-5, -4,-4,-4,-3,-2,-1,-1,-1,0,0,0,1,1,1,3,4,5 
		public int[][] threeSum(int[] A) {
		        int[][] result = new int[A.length][3];
		        if(A.length < 3) {
		            return result;
		        }
		        Arrays.sort(A);
		        
		        int counter = 0;
		        int B = 0;
		        long resultSum =0;
		        long diffSum=Integer.MAX_VALUE;
		         int x =0;
		         int y =1;
		            int z = A.length-1;
		        for(int i=0;i < A.length-2;i++) {
		            
		           
		             y =x+1;
		             z = A.length-1;
		            
		            
		            while(y < z) {
		                long sum = (long)A[x]+ (long)A[y]+ (long)A[z];
		                if(sum == 0) {
		                        result[counter][0] = A[x];
		                        result[counter][1] = A[y];
		                        result[counter][2] = A[z];
		                        counter++;
		                    
		                    resultSum = sum;
		                
		                 while(y+1<z&&A[y]==A[y+1]){
		                        y++;
		                    }
		                    while(z-1>y&&A[z]==A[z-1]){
		                        z--;
		                    }
		                    y++;z--;
		                }else
		                if(sum > B) {
		                    z--;
		                }else {
		                    y++;
		                }
		            }
		             while(x+1<A.length&&A[x]==A[x+1]){
		                x++;
		            }
		             x++;
		        }
		        
		        
		        

		    
		        int[][] resultFinal = new int[counter][3];
		        for(int i =0; i< resultFinal.length ; i++) {
		            resultFinal[i] = result[i];
		        }
		        return resultFinal;
		        
		    }

		

		
   
}
