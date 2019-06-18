package hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class windowSirng {



	public static void main(String[] args) {

		System.out.println(new windowSirng().minWindow("abcabcabdacavab", "da"));;


	}

	 public String minWindow(String A, String B) {
		    if (B == null || B.length() == 0) {
		      return "";
		    }
		    Set<Character> charSet = new HashSet<>();
		    Map<Character, Integer> countMap = new HashMap<>();
		    for (Character c : B.toCharArray()) {
		      charSet.add(c);
		      if (countMap.containsKey(c)) {
		        countMap.put(c, countMap.get(c) + 1);
		      } else {
		        countMap.put(c, 1);
		      }
		    }
		    int start = 0, end = 0;
		    int minStart = -1, minLength = Integer.MAX_VALUE;
		    while (end < A.length()) {
		      char endChar = A.charAt(end);
		      if (charSet.contains(endChar)) {
		        countMap.put(endChar, countMap.get(endChar) - 1);
		      }
		      
		        while (satisfies(countMap) && start <= end) {
		          int curLength = end - start + 1;
		          if (curLength < minLength) {
		            minLength = curLength;
		            minStart = start;
		          }
		          start++;
		          char startChar = A.charAt(start - 1);
		          if (countMap.containsKey(startChar)) {
		            countMap.put(startChar, countMap.get(startChar) + 1);
		          }
		        }
		     
		      end++;
		    }
		    if (minLength == Integer.MAX_VALUE) {
		      return "";
		    }
		    return A.substring(minStart, minStart + minLength);
		  }

		  private boolean satisfies(Map<Character, Integer> countSet) {
		    Set<Character> keySet = countSet.keySet();
		    for (Character c : keySet) {
		      if (countSet.get(c) > 0) {
		        return false;
		      }
		    }
		    return true;
		  }}
