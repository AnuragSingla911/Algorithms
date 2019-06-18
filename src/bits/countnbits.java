package bits;

public class countnbits {

	public static void main(String[] args) {
		countnbits obj = new countnbits();
		int[] arr = new int[] {1,3,5};
		
		System.out.println(obj.cntBits(arr));
	}
	
	public int cntBits(int[] A) {
		
		long count = 0;
		
		for(int i =0; i< A.length ; i++) {
			for(int j =0; j < A.length ; j++) {
				count += count(A[i], A[j]);
			}
		}
		
		return (int)(count % 1000000007L);
    
	
	}
	
	
	public long count(int x,int y) {
		long count = 0;
		for(int i=0; i< 32; i++) {
			if(getnthbit(x, i) != getnthbit(y, i)) {
				count++;
			}
		}
		
		return count;
	}
	
	public int getnthbit(int no, int index) {
		return (no >> index)&1;
	}
	
	
}
