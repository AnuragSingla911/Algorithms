package bits;

public class numberofonebi {
	
	public static void main(String[] args) {
		System.out.println(new numberofonebi().numSetBits(7));
	}

	 public int numSetBits(long a) {
	        
	        int count = 0;
	        while(a > 0){
	            
	           count+= ( a >> 0)&1;
	           a = (a >> 1);
	        }
	        
	        return count;
	    }
}
