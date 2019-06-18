package algo;

import java.util.ArrayList;

public class subString {
	
	public static void main(String[] args) {
		String s = "abb";
		
		subString obj = new subString();
		
		ArrayList<String> list = Utilities.toList(new String[] {"abc", "abcd"});
		
		System.out.println(obj.longestCommonPrefix(list));
		
		
		
		
		
	}
	
public String longestPalindrome(String A) {
        
        String reverse = "";
        
        for(int i = A.length()-1;i>=0;i--){
            reverse+= ""+ A.charAt(i);
        }
        
        return commonSubStringLength(A,reverse);
        
        
        
    }

public String longestCommonPrefix(ArrayList<String> A) {
    
    int minLength = Integer.MAX_VALUE;
    
    for(int i=0;i < A.size();i++){
        if(minLength > A.get(i).length()){
            minLength = A.get(i).length();
        }
    }
    
    String result = "";
    
    int i=0;
    while(i< minLength){
    char c = A.get(0).charAt(i);
    boolean isMatch =true;
    for(int j = 1 ; j < A.size();j++){
        char str = A.get(j).charAt(i);
        if(str!=c){
            isMatch=false;
            break;
        }
        
    }
    
    if(isMatch){
        result+= ""+c;
    }else{
        break;
    }
    i++;
    }
    
    System.out.println(result);
    
    return result;
    
    
}
	
	 private static String commonSubStringLength(String first,String second){
	        int[][] state = new int[first.length()+1][second.length()+1];
	        
	        int maxLength=0;
	        int k=0;
	        
	        for(int i=0;i < first.length()+1;i++){
	            for(int j=0;j < second.length()+1;j++){
	                
	                if(i==0 || j==0){
	                    state[i][j]=0;
	                }else if(first.charAt(i-1)== second.charAt(j-1)){
	                    state[i][j]= state[i-1][j-1]+1;
	                    
	                    if(maxLength < state[i][j]){
	                        maxLength= state[i][j];
	                        k=i;
	                    }
	                }else{
	                    state[i][j]=0;
	                }
	            }
	        }
	        return first.substring(k-maxLength, k);
	        
	    }
	
	void hasPattern(String pattern, String str) {
		
		Integer[] patternArr = new Integer[pattern.length()];
		
		computeLPSArray(pattern, pattern.length(), patternArr);
		
		int m = 0;
		int n=0;
		
		while(m < str.length()) {
			if(str.charAt(m)== pattern.charAt(n)) {
				System.out.println("aage badho "+  m + " "+n);
				m++;
				n++;
				if(n== pattern.length()) {
					System.out.println("pattern mil gya");
					break;
				}
			}else {
				if(n>0) {
				n = patternArr[n-1];
				System.out.println(n);
				}else
				{
					n=0;
					m++;
					
				}
				
			}
			
			
			
			
			
			
		}
	}

	 void computeLPSArray(String pat, int M, Integer[] lps) 
	    { 
	        // length of the previous longest prefix suffix 
	        int len = 0; 
	        int i = 1; 
	        lps[0] = 0; // lps[0] is always 0 
	  
	        // the loop calculates lps[i] for i = 1 to M-1 
	        while (i < M) { 
	            if (pat.charAt(i) == pat.charAt(len)) { 
	                len++; 
	                lps[i] = len; 
	                i++; 
	            } 
	            else // (pat[i] != pat[len]) 
	            { 
	                // This is tricky. Consider the example. 
	                // AAACAAAA and i = 7. The idea is similar 
	                // to search step. 
	                if (len != 0) { 
	                    len = lps[len - 1]; 
	  
	                    // Also, note that we do not increment 
	                    // i here 
	                } 
	                else // if (len == 0) 
	                { 
	                    lps[i] = len; 
	                    i++; 
	                } 
	            } 
	        } 
	    } 
	  
	  
}
