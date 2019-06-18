package hashing;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import algo.Utilities;

public class anagrams {

	public static void main(String[] args) {
		
		String[] arr = new String[] {  "abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba", "abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa", "babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab", "bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb", "abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab", "aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba", "abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa", "aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb" 
		};
		
		Utilities.print2DArrayList(new anagrams().anagrams(Utilities.toList(arr)));
		

//		new anagrams().anagrams(arr);
	}
	
	 public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
		 
		 LinkedHashMap<Integer, ArrayList<Integer>> map = new LinkedHashMap<>();

			for (int i = 0; i < A.size(); i++) {
				int key = getKey(A.get(i));

				if (!map.containsKey(key)) {
					map.put(key, new ArrayList<Integer>());
				}
				
				map.get(key).add(i+1);
			}
			
			ArrayList<ArrayList<Integer>> result = new ArrayList<>();
			for(ArrayList<Integer> arr : map.values()) {
				result.add(arr);
			}
			
			return result;
			
	    }

	

	public int getKey(String s) {

		int sum = 0;
		int prod = 1;
		for (int i = 0; i < s.length(); i++) {
			sum += s.charAt(i);
			prod *= s.charAt(i);
		}

		return sum + prod;

	}
}



