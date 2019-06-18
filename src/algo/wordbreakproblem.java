package algo;

import java.util.ArrayList;

public class wordbreakproblem {
	
	public static void main(String[] args) {
		
		ArrayList<String> dic = Utilities.toList(new String[] {"mobile","samsung","sam","sung", 
                "man","mango", "icecream","and", 
                "go","i","love","ice","cream"});
		
		wordbreakproblem problem = new wordbreakproblem();
		System.out.println(problem.isPossible(dic, "iloveicecreamandmango", 0,""));
		
	}
    Boolean[] wb ;

	boolean wordBreak(String str,ArrayList<String> dic) 
	{ 
	    int size = str.length(); 
	    if (size == 0)   return true; 
	    
	    wb= new Boolean[size+1];
	  
	    // Create the DP table to store results of subroblems. The value wb[i] 
	    // will be true if str[0..i-1] can be segmented into dictionary words, 
	    // otherwise false. 
	    for(int i=0;i< wb.length;i++)
	    	wb[i] =false;
	   
	  
	    for (int i=1; i<=size; i++) 
	    { 
	        // if wb[i] is false, then check if current prefix can make it true. 
	        // Current prefix is "str.substr(0, i)" 
	        if (wb[i] == false && dic.contains(str.substring(0, i))) {
	        	System.out.println(str.substring(0,i) + " exist" + " "+ i);
	            wb[i] = true; 
	        }else if(wb[i]){
	        	System.out.println("skip for "+ i);
	        }else {
	        	System.out.println(str.substring(0, i) + "  not found");
	        }
	  
	        // wb[i] is true, then check for all substrings starting from 
	        // (i+1)th character and store their results. 
	        if (wb[i] == true) 
	        { 
	            // If we reached the last prefix 
	            if (i == size) 
	                return true; 
	  
	            for (int j = i+1; j <= size; j++) 
	            { 
	                // Update wb[j] if it is false and can be updated 
	                // Note the parameter passed to dictionaryContains() is 
	                // substring starting from index 'i' and length 'j-i' 
	                if (wb[j] == false && dic.contains(str.substring(i, j) )) {
	                  	System.out.println(str.substring(i,j) + " exist" + " "+ j + " inner");
	                    wb[j] = true; 
	                }else if(wb[j]){
	                		System.out.println(" skip for "+ j + " inner");
	                }else {
	    	        	System.out.println(str.substring(i, j) + "  not found inner");
	    	        }
	  
	                // If we reached the last character 
	                if (j == size && wb[j] == true) 
	                    return true; 
	            } 
	        } 
	    } 
	    
	    
	  
	    /* Uncomment these lines to print DP table "wb[]" 
	     for (int i = 1; i <= size; i++) 
	        cout << " " << wb[i]; */
	  
	    // If we have tried all prefixes and none of them worked 
	    return false; 
	} 
	
	boolean isPossible(ArrayList<String> dic, String s,int index,String result){

		if(s.length()==0) {
			System.out.println(result);
			return true;
		}
		boolean isPossible = false;
		for(int i=0;i<s.length() ;i++) {
			String first = s.substring(0, i+1);
			boolean f=  dic.contains(first);
			if(f) {
				String second = s.substring(i+1);
				 isPossible = isPossible(dic, second, i+1,result + first + " ");
				
			}

		}

		return isPossible;
	}
	
	
	

}
