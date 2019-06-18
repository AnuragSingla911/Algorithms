package twopiinters;

public class absoluteDiff {
	
	
	public static void main(String[] args) {
		absoluteDiff obj = new absoluteDiff();
		int[] a = new int[] {1, 4, 5, 8, 10};
		int[] b = new int[] {6, 9, 15};
		int[] c = new int[] {2, 3, 6, 6};
		
		System.out.println(obj.solve(a, b, c));
	}

	 public int solve(int[] A, int[] B, int[] C) {
	        
	        int x = 0;
	        int y = 0;
	        int z = 0;
	        
	        int diff = Integer.MAX_VALUE;
	        
	        while(x < A.length && y < B.length && z < C.length) {
	        		int max = max(A[x], B[y], C[z]);
	        		int min = min(A[x], B[y], C[z]);
	        		
	        		int diff0 = Math.abs(max-min);
	        		
	        		if(diff0 < diff) {
	        			diff = diff0;
	        		}
	        		
	        		if(A[x] > B[y]) {
	        			if(B[y] < C[z]) {
	        				y++;
	        			}else if(A[x] > C[z]){
	        				z++;
	        			}else {
	        				x++;
	        			}
	        		}else {
	        			if(A[x] < C[z]) {
	        				x++;
	        			}else if(B[y] > C[z]){
	        				z++;
	        			}else {
	        				y++;
	        			}
	        		}
	        		
	        		
	        		
	        }
	        
	        return diff;
	    }
	 
	 
	 private int max(int a,int b,int c) {
		 return Math.max(Math.max(a, b), c);  
	 }
	 
	 private int min(int a,int b,int c) {
		 return Math.min(Math.min(a, b), c);  
	 }
}
