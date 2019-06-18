package bits;

public class divide {
	
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(new divide().divide(Integer.MIN_VALUE, -3));
	}
    
    public int clearnthbit(int no,int index) {
        return (~(1 << index)) & no;
    }
    
     public long toggleBit(long a) {
          return (~a + 1);
      }
     
     public int getnthbit(int no, int index) {
            return (no >> index)&1;
        }
        

     public int divide(int A0, int B0) {
    	 
    	 		long A = A0;
    	 		long B = B0;
            
            if(B == 0){
                return Integer.MAX_VALUE;
            }
            
            if(B == 1){
                return (int)A;
            }
            
            if(B == -1){
                    long r = toggleBit((long)A);
                return r > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)(r);
            }
            
            boolean isNagative = false;
            int Abit = getnthbit(A0, 31);
            int BBit = getnthbit(B0, 31);
            
            if((Abit ^ BBit) == 1) {
                    isNagative = true;
            }
            
            if(Abit==1) {
            A =  toggleBit((long)A);
            }
            
            if(BBit==1) {
                B =  toggleBit(B);
                }
            long result = 0;
            for(long i =1 ; i< A; i++){
                long m = multiply(B, i);
                if(m <= A){
                    result = i;
                }else{
                    break;
                }
            }
            
            if(isNagative) {
                    result = toggleBit(result);
            }
            return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
        }
        
        static long multiply(long n, long m) 
        {  
            long ans = 0, count = 0; 
            while (m > 0) 
            { 
                // check for set bit and left  
                // shift n, count times 
                if (m % 2 == 1)              
                    ans += n << count; 
          
                // increment of place  
                // value (count) 
                count++; 
                m /= 2; 
            } 
              
            return ans; 
        } 
}
