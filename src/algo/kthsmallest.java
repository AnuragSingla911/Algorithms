package algo;

public class kthsmallest {

	public static void main(String[] args) {
		
		int[] x = new int[] {5,7,9,3,2,8,7,6};
		
		int element = new kthsmallest().kthsmallest(x, 6);
		System.out.println(element);
		
		
	}
	
public int kthsmallest(final int[] A, int B) {
        

	
		int min = A[0];

		int max = A[0];
		
		for(int i = 1; i < A.length ; i++) {
			if(min > A[i]) {
				min = A[i];
			}
			
			if(max < A[i]) {
				max = A[i];
			}
		}
		
		while(true) {
			System.out.println(min + " "+ max);
		int mid = (min+max)/2;
		
		
		int smaller = 0;
				int smallerEqual = 0;
		
		for(int i =0; i< A.length ; i++) {
			if(A[i] < mid) {
				smaller++;
			}
			if (A[i] <= mid){
				smallerEqual++;
			}
		}
		System.out.println(smaller + " "+ smallerEqual + " "+ mid);

			if(smaller < B && smallerEqual >= B) {
				return mid;
			}
			
			
			else if(smaller >= B) {
				max = mid-1;
			}
			
			else if(smallerEqual < B) {
				min = mid+1;
			}
		
		
		
		
		}
		
		

		
		
        
       
    }

 

}
