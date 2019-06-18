package string;

import java.util.ArrayList;

public class zingzag {
	
	public static void main(String[] args) {
		System.out.println(new zingzag().convert("sddsadad", 1));
	}

public String convert(String A, int B) {
	
		if(B == 1) {
			return A;
		}
        
        ArrayList<StringBuilder> list = new ArrayList<>();
        
        for(int i =0; i< B ; i++){
            list.add(new StringBuilder());
        }
        
        int x =0;
        int j =0;
        boolean isincrease = true;
        while(x < A.length()) {
        		list.get(j).append(A.charAt(x));
        		x++;
        		if(isincrease) {
        			j++;
        			if(j == B-1) {
        				isincrease = false;
        			}
        		}else {
        			j--;
        			if(j == 0) {
        				isincrease = true;
        			}
        		}
        		
        }
        
        StringBuilder result = new StringBuilder();
        
        for(StringBuilder item : list) {
        		result.append(item);
        }
        
        return result.toString();
        
        
    }
}
