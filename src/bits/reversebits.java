package bits;

public class reversebits {

	public static void main(String[] args) {
		reversebits obj = new reversebits();
		System.out.println(obj.toggleBit(0,31));
	}
	
	  public long reverse(long a) {
		  
		  for(int i =0; i< 16; i++) {
			  long bit = getnthbit(a, i);
			  long bitlast = getnthbit(a, 32-i-1);
			  System.out.println(bit + " "+ bitlast);
			  if(bit != bitlast) {
				  a=toggleBit(a, i);
				  System.out.println(a);
				  a=toggleBit(a, 32-i-1);
				  System.out.println(a);
			  }
		  }
		  
		  return a;
	        
		  
	    }
	  
	  public long toggleBit(long a, int index) {
		  return (a ^ (1L << index));
	  }
	  
	  public long getnthbit(long no, int index) {
			return ((no >> index)&1);
		}
}
