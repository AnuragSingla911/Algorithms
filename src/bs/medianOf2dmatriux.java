package bs;

import java.util.Arrays;

public class medianOf2dmatriux {

	public static void main(String[] args) {
		
		int[][] arr = new int[][] {{1,3,5},{2,6,9},{3,6,9}};
		medianOf2dmatriux obj = new medianOf2dmatriux();
		
		int ans = obj.findMedian(arr);
		System.out.println("ans :"+ ans);
		
		
	}
	
		   public int findMedian(int[][] A) {
		        
		        int min = Integer.MAX_VALUE;
		        int max = Integer.MIN_VALUE;
		        
		        int rowLength = A.length;
		        int coluLength = A[0].length;
		        
		        for(int i =0; i< rowLength ; i++) {
		                if(A[i][0] < min) {
		                    min = A[i][0];
		                }
		                
		                if(A[i][coluLength-1] > max) {
		                    max = A[i][coluLength-1];
		                }
		        }
		        
		        int desired = ((rowLength * coluLength)+1)/2;
		        
		        
		        while(min < max) {
		                int mid = (min+max)/2;
		                int total = 0;
		                int noOfSmallerElements = 0;
		                
		                for(int i =0; i< rowLength ; i++) {
		                     noOfSmallerElements = Arrays.binarySearch(A[i], mid);
		                    if(noOfSmallerElements < 0) {
		                        noOfSmallerElements = Math.abs(noOfSmallerElements)-1;
		                    }else {
		                        while(noOfSmallerElements < coluLength && A[i][noOfSmallerElements] == mid) {
		                            noOfSmallerElements++;
		                        }
		                    }
		                    
		                    total = total+ noOfSmallerElements;
		                    
		                   
		                }
		                
		                
		                
		                
		                 if(total < desired) {
		                        min = mid+1;
		                        
		                    }else {
		                        max = mid;
		                    }
		        }
		        
		        return min;
		   }
		        
		}
