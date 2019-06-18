package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

import algo.Utilities;


public class shortestUniquePrefix {

	public static void main(String[] args) {
		
		ArrayList<String> list = Utilities.toList(new String[] {"bearcat", "bert"});
		
		Utilities.printArrayList(new shortestUniquePrefix().prefix(list));
		
	}
	
	public ArrayList<String> prefix(ArrayList<String> A) {
		
		for(String str : A) {
			insert(str);
		}
		
		ArrayList<String> result = new ArrayList<String>();
		
		for(String str : A) {
			result.add(findUnique(str));
		}
		
		
		return result;		
    }
	
	private String findUnique(String word) {
		
		StringBuilder builder = new StringBuilder();
		
		TrieNode current = root;
		
		String uniqueTillNow = "";
		boolean isFound = false;
		
		for(int i =0; i< word.length() ; i++) {
				char c = word.charAt(i);
				builder.append(c);
				if(current.map.get(c).map.size() < 2) {
					if(!isFound) {
					uniqueTillNow = builder.toString();
					isFound = true;
					}
				}else {
					isFound = false;
				}
				
				current = current.map.get(c);
			
		}
		
		return uniqueTillNow;
		
		
	}
	
	private void insert(String word) {
		TrieNode current = root;
		for(int i =0; i< word.length() ; i++) {
			if(current.map.containsKey(word.charAt(i))) {
				current = current.map.get(word.charAt(i));
				if(i == word.length()-1) {
					current.isEndOfWord = true;
				}
			}else {
				String s = word.substring(0, i);
				TrieNode t = new TrieNode(s);
				if(i == word.length()-1) {
					t.isEndOfWord = true;
				}
				current.map.put(word.charAt(i), t);
				current = t;
			}
		}
	}

	private TrieNode root = new TrieNode("");

	
	class TrieNode {
		String wordTillNow;
		LinkedHashMap<Character, TrieNode> map = new LinkedHashMap<>();
		boolean isEndOfWord;
		
		TrieNode(String s){
			wordTillNow = s;
		}
	}
}
