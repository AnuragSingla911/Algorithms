package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

public class allplaindromesubstrings {
	
	public static void main(String[] args) {
		
		allplaindromesubstrings obj = new allplaindromesubstrings();
		obj.checkAllPlinDromes("abaaa");
		LinkedHashSet<String> set = new LinkedHashSet<>(obj.allStrings);
		obj.allStrings = new ArrayList<>(set);
		Collections.sort(obj.allStrings);
		Utilities.printArrayList(obj.allStrings);
		
	}
	
	void checkAllPlinDromes(String s){
		for(int i=0;i <s.length();i++) {
			oldPalinDrome(i, s);
			evenPalinDrome(i, s);
		}
	}
	
	ArrayList<String> allStrings = new ArrayList<>();
	
	void oldPalinDrome(int index, String s) {
		int length =0;
		
		while(index - length >= 0 && index + length < s.length()) {
			char left = s.charAt(index-length);
			char right = s.charAt(index+length);
			if(left == right) {
				allStrings.add(s.substring(index-length, index+length+1));
				length++;
			}else {
				break;
			}
		}
	}
	
	void evenPalinDrome(int index, String s) {
		int length =0;
		
		while(index - length >= 0 && index + length+1 < s.length()) {
			char left = s.charAt(index-length);
			char right = s.charAt(index+length+1);
			if(left == right) {
				allStrings.add(s.substring(index-length, index+length+2));
				length++;
			}else {
				break;
			}
		}
	}

}
