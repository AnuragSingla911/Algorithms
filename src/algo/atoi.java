package algo;

public class atoi {
	
	public static void main(String[] args) {
		atoi obj = new atoi();
		
		System.out.println(obj.atoi("-54332872018247709407"));
	}
	
public int atoi(final String AB) {
        
        String A = new String(AB);
        
        if(A == null || A.length()==0){
            return 0;
        }
        
        A = A.trim();
        
        char c = A.charAt(0);
        
        boolean isNagativeNumber= false;
        int i=0;
        if(c == '-'){
            isNagativeNumber = true;
            i++;
        }else if(c == '+'){
            isNagativeNumber = false;
            i++;
        }
        

        String s = 
        "";
        long value = 0;
        while(i<A.length()){
            char ch= A.charAt(i);
            if(ch >= '0' && ch <= '9'){
                s+= ""+ch;
                value=Long.parseLong(s);
                if(value > Integer.MAX_VALUE && !isNagativeNumber) {
            		value = Integer.MAX_VALUE;
            		break;
            }
            
            else if(isNagativeNumber && -value < Integer.MIN_VALUE) {
            		value = Integer.MIN_VALUE;
            		break;
            }
            }else{
                break;
            }
            i++;
        }
        
        
        
       if(s.length()==0) {
    	   return 0;
       }
       
       if(value > Integer.MIN_VALUE && isNagativeNumber) {
    	   	
       }
        
        return (int)value ;
    }

}
