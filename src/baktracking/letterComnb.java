package baktracking;

import java.util.ArrayList;

import algo.Utilities;

public class letterComnb {

	public static void main(String[] args) {
		
		Utilities.printArrayList(new letterComnb().letterCombinations("1219"));
		
	}
	
	public ArrayList<String> letterCombinations(String A) {
		
		find(0, A, "");
		
		
		return result;
    }
	ArrayList<String> result = new ArrayList<>();
	
	private void find(int start, String A, String current) {
		
		if(start == A.length()) {
			result.add(current);
			return;
		}
		
		char c  = A.charAt(start);
		String s = getMapping(c);

		for(int i =0; i < s.length() ; i++) {
			
			find(start+1, A, current + s.charAt(i));
		}
		
		
	}
	
	
	private String getMapping(char c) {
		StringBuilder builder = new StringBuilder();
		if(c == '0' || c == '1') {
			builder.append(c);
		}else if(c == '2') {
			builder.append("abc");
		}else if(c == '3') {
			builder.append("def");
		}else if(c == '4') {
			builder.append("ghi");
		}else if(c == '5') {
			builder.append("jkl");
		}else if(c == '6') {
			builder.append("mno");
		}else if(c == '7') {
			builder.append("pqrs");
		}else if(c == '8') {
			builder.append("tuv");
		}else if(c == '9') {
			builder.append("wxyz");
		}
		return builder.toString();
	}
}
