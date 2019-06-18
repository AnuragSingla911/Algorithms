package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import algo.Utilities;

public class hotelReviews {

	public static void main(String[] args) {
			ArrayList<String> list = Utilities.toList(new String[] {"water_ic_cool", "co_ice_drink", "cool_wifi_speed_a" });
			String s = "cool_ice_wifii_ab_a";
			hotelReviews review = new hotelReviews();
			Utilities.printArrayList(review.solve(s, list));
	}
	
	class IndexCount implements Comparable<IndexCount>{
		int index;
		int count;
		
		@Override
		public int compareTo(IndexCount o) {
			return count < o.count ? 1 : count > o.count ? -1 : index > o.index ? 1 : -1;
		}
	}

	public ArrayList<Integer> solve(String A, ArrayList<String> B) {

		for(String good : A.split("_")) {
			insert(good);
		}
		
		ArrayList<IndexCount> list = new ArrayList<IndexCount>();
		int j = 0;
		for(String s : B) {
			int i = 0;
			for(String word : s.split("_")) {
				if(isExist(word)) {
					i++;
				}
			}
			IndexCount obj = new IndexCount();
			obj.count = i;
			obj.index = j;
			list.add(obj);
			j++;
		}
		
		Collections.sort(list);
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(IndexCount obj : list) {
			result.add(obj.index);
		}
		
		return result;

	}
	
	private boolean isExist(String word) {
		TrieNode current = root;
		for(int i =0; i< word.length() ; i++) {
			if(current.map.containsKey(word.charAt(i))) {
				current = current.map.get(word.charAt(i));
			}else {
				return false;
			}
		}
		return current.isendofword;
	}

	private void insert(String word) {
		TrieNode current = root;
		for(int i =0; i< word.length() ; i++) {
			if(current.map.containsKey(word.charAt(i))) {
				current = current.map.get(word.charAt(i));
				if(i == word.length()-1) {
					current.isendofword = true;
				}
			}else {
				TrieNode t = new TrieNode();
				if(i == word.length()-1) {
					t.isendofword = true;
				}
				current.map.put(word.charAt(i), t);
				current = t;
			}
		}
	}

	private TrieNode root = new TrieNode();

	static class TrieNode {
		HashMap<Character, TrieNode> map = new HashMap<>();
		boolean isendofword;
	}
}
