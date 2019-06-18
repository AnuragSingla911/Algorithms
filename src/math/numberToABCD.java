package math;

public class numberToABCD {

	public static void main(String[] args) {
		numberToABCD a = new numberToABCD();
		System.out.println(a.convertToTitle(52));
	}
	
public String convertToTitle(int A) {
        
        String s = "";
        while(A > 0){
            int reminder = A%26;
            if(reminder != 0) {
            char c  = (char)('A' + (char) (reminder-1));
            

            s =  c + s;
            A = A/26;
            }else {
            	s =  'Z' + s;
            	 A = A/26;
            	 A = A-1;
            }
          
        }
        
        
        
        return s;
    }
}
