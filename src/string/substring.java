package string;

public class substring {
	
	public static void main(String[] args) {
		System.out.println(new substring().strStr("bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba", "babaaa"));
	}
	
	 public int strStr(final String A, final String B) {
	        int x = 0;
	        int y = 0;
	        
	        int z = 0;
	        
	        while(x < A.length()){
	            char c = A.charAt(x);
	            char d = B.charAt(y);
	            
	            if(c == d){
	                x++;
	                y++;
	                if(y == B.length()){
	                    return x-B.length();
	                }
	            }else{
	                
	                x = ++z;
	                z=x;
	                y = 0;
	            }
	        }
	        
	        return -1;
	    }

}
