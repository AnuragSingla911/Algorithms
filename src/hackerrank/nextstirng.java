package hackerrank;

import java.util.Arrays;

public class nextstirng {

	
	public static void main(String[] args) {
		System.out.println(biggerIsGreater("abdc"));
	}

	    // Complete the biggerIsGreater function below.
	    static String biggerIsGreater(String w) {

	        int index = w.length()-1;
	        for(int i = w.length()-1 ; i> 0 ; i--){
	            char c = w.charAt(i);
	            char c1 = w.charAt(i-1);

	            if(c > c1){
	                index = i-1;
	                break;
	            }

	        }
	        int swap = w.length()-1;
	        for(int i = w.length()-1 ; i> index ; i--){
	              char c = w.charAt(i);
	            char c1 = w.charAt(index);

	            if(c > c1){
	                swap = i;
	                break;
	            }
	        }

	        StringBuilder result = new StringBuilder();
	        result.append(w.substring(0,index));
	        result.append(w.charAt(swap));

	        String rest = swap < w.length() ? w.substring(index,swap) + w.substring(swap+1)
	                : w.substring(index,swap);
	        char[] restArr = rest.toCharArray();
	        Arrays.sort(restArr);
	        
	        result.append(new String(restArr));
	        
	        return result.toString().equals(w) ? "no answer" : result.toString();

	        







	    }

	  

}
