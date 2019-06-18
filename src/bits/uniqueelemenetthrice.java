package bits;

public class uniqueelemenetthrice {
	
	public static void main(String[] args) {
		int[] x = new int[] {1,1,3,1,2,4,2,4,2,4};
		System.out.println(new uniqueelemenetthrice().singleNumber(x));
	}
	
	public int getnthbit(int no, int index) {
		return (no >> index)&1;
	}
	
	

	 public int singleNumber(final int[] A) {
		 
		
		 int[] count = new int[32];
		 
		 for(int i =0 ; i< A.length ; i++) {
			for(int j = 0; j < count.length ; j++) {
				count[j] += getnthbit(A[i], j);
			}
		 }
		 
		 int x = 0;
		 for(int j = 0; j < count.length ; j++) {
				if(count[j] % 3 != 0) {
					x = count[j];
				}
			}
		 
		 return x;
	    }
}
