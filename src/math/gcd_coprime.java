package math;

public class gcd_coprime {

	public static void main(String[] args) {
		gcd_coprime obj = new gcd_coprime();
		System.out.println(obj.cpFact(64,6));
	}
	    public int cpFact(int A, int B) {
	    	
	    	if(gcd(A,B) == 1) {
	    		return A;
	    	}
	      
	        int i =2;
	        while(i<= A && i <= B){
	            if(A % i ==0 && B % i == 0){
	                A = A / i;
	            }else{
	                i++;
	            }
	        }
	        
	        return cpFact(A,B);
	        
	        
	      
	       
	    }
	    
	    public int gcd(int A, int B) {
	        if(A == 0 || B == 0){
	            if(A > 0){
	                return A;
	            }else{
	                return B;
	            }
	        }
	        int no = 1;
	        int gcm = 1;
	        while(no <= A && no <= B){
	            if(A % no == 0 && B % no == 0){
	                gcm = no;
	            }
	            no++;
	            
	        }
	        return gcm;
	    }
}
