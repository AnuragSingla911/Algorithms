package baktracking;

import java.util.ArrayList;

import algo.Utilities;

public class palindromepartition {

	public static void main(String[] args) {
		
		Utilities.print2DArrayList(new palindromepartition().partition("efe"));
	}

	ArrayList<ArrayList<String>> result = new ArrayList<>();
	public ArrayList<ArrayList<String>> partition(String a) {

		for(int i =0; i< a.length() ; i++) {
			if(isPalinDrome(a.substring(0, i+1)))
			find(i+1, a, new ArrayList<String>(), a.substring(0,i+1));
			
			
		}
		
		return result;
	}
	
	private void find(int start, String a, ArrayList<String> list, String current) {
		
		
		
		if(isPalinDrome(current)) {
			list.add(current);
			current="";
			if(start >= a.length()) {
				result.add(list);
				return;
			}
		}
		
		
	for(int i = 0; i+start< a.length() ; i++) {	
		if(isPalinDrome(current + a.substring(start, start+i+1)))
		find(start+1+i, a, (ArrayList<String>) list.clone(), current + a.substring(start, start+i+1));
	
	}
	
		
		
	}

	private boolean isPalinDrome(String s) {
		int x = 0;
		int y = s.length()-1;

		while(x <= y) {
			if(s.charAt(x) != s.charAt(y)) {
				return false;
			}
			x++;
			y--;
		}
		return true;
	}
}
