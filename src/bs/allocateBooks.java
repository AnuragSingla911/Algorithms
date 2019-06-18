package bs;

public class allocateBooks {

	public static void main(String[] args) {
		
		allocateBooks obj = new allocateBooks();
		int[] arr = new int[] {
				97, 26, 12, 67, 10, 33, 79, 49, 79, 21, 67, 72, 93, 36, 85, 45, 28, 91, 94,
				57, 1, 53, 8, 44, 68, 90, 24 
				 };
		System.out.println(obj.books(arr, 26));
		
	}
	
	 public int books(int[] A, int B) {
	        int len = A.length;
	        if(len < B) return -1;
	        int total =0 ; int max = Integer.MIN_VALUE;
	        for(int i=0;i<len;i++){
	            total += A[i];
	            max = Math.max(max,A[i]);
	        }
	        
	        int lo = max;int hi = total;
	        while(lo < hi) {
	            int mid = lo + (hi-lo)/2;
	            int requiredReaders = getRequiredReaders(A, mid);
	            System.out.println(requiredReaders);
	            if(requiredReaders <= B) {
	                hi = mid;
	            }else {
	                lo = mid + 1;                
	            }
	        }
	        return lo;
	    }
	    
	    private int getRequiredReaders(int[] a, int maxLengthPerReader) {
	        int total = 0;
	        int readers = 1;
	        for(int i = 0; i < a.length; i++) {
	            total += a[i];
	            if(total > maxLengthPerReader) {
	                total = a[i];
	                readers++;
	            }
	        }
	        return readers;
	    }
	
	private int min = Integer.MAX_VALUE;
	
//	 public int books(int[] A, int B) {
//		 
//		 int sum = 0;
//		 int max = Integer.MIN_VALUE;
//		 for(int a : A) {
//			 sum+= a;
//			 if(max < a) {
//				 max =a;
//			 }
//		 }
//		 
//		getMin(A, max, sum, B);
//		
//		return this.min;
//		
//		 
//	    }
	 
	 private void getMin(int[] A, int low,int high, int B) {
		 while(low < high) {
			
		
		 int desired = (low+high)/2;
		 int count = noofstudents(A, desired, B);
		 System.out.println(" desired : "+ desired + " count : "+ count + " "+ low + " "+ high);
		 if(count == B && desired < min) {
			 min = desired;
		 }
		 if(count > B) {
			 low = desired+1;
		 }else {
			high = desired;
		 }
		 }
		 
	 }
	 
	 private int noofstudents(int[] A, int desired, int B) {
		 int temp = 0;
		 int count = 0;
		 for(int a : A) {
			 if(temp+a > desired) {
				 count++;
				 temp=0;
			 }
			 temp+= a;
			 
		 }
		 
		 
		 
		 
		 return count;
	 }
}
