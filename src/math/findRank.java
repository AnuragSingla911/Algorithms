package math;

import java.util.Arrays;

public class findRank {

	public static void main(String[] args) {
		findRank obj = new findRank();
		System.out.println(Integer.MAX_VALUE);
		System.out.println((long)Integer.MAX_VALUE * (long)Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
	}
	
	public int findRank(String A) {
		
		
        long result = 0;
        for(int i =0; i <A.length();i++ ){
        	
        
            char c = A.charAt(i);
            char[] arr = A.substring(i).toCharArray();
    		Arrays.sort(arr);
    		String s = new String(arr);
            int index= s.indexOf(c) ;
            result += (index) * countChild(s.length()-1);
        }
        
        return (int)(result % 1000003L);
    }
    
    private long countChild(int no){
        if(no == 0){
            return 0;
        }
        if(no == 1){
            return 1;
        }
        return (long)no * countChild(no-1);
    }
}
