package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import algo.Utilities;

public class ladderLengthj {
	
	public static void main(String[] args) {
		ArrayList<String> list= Utilities.toList(new String[] {
				 "aabbaaba" , "aababaaa", "baabbaaa", "baabbbab", "bbbabbaa" ,"bbabbaba" ,"abbaabaa" 
				 ,"aabbbabb","abababbb","abaaabba","bbbaaabb","abbaaaab","abababab","abbbabab","abaaaabb"
				 		,"aaaaabaa","baaaabaa","bbabbabb","ababaaab","aabaabab","babbbaba","bbbaaabb","babaaabb","aabaaaab","bbaabbaa","aaababaa","bbbbabab","aaaababa",
				 		"bbbbbaba","abaabaab","baaababb","bbabbaaa","abbbbbab","bbbbbabb"
				 				,"abaaabaa","babbaabb","babaabab","aabbbbba","baabaabb"
	
		});
		
		System.out.println(new ladderLengthj().ladderLength("ababbabb","aababaab", list));
	}
	
	public int ladderLength(String start, String end, ArrayList<String> dictV) {
		
		
		Queue<String> queue = new LinkedList<String>();
		Queue<Integer> countQueue = new LinkedList<Integer>();
		queue.add(end);
		countQueue.add(1);
		HashSet<String> mem = new HashSet<>();
		mem.add(end);
		while(!queue.isEmpty()) {
			String str = queue.poll();
			System.out.println(str);
			int count = countQueue.poll();
			if(isOneCharDiff(str, start)) {
				return count + 1;
			}
			
			for(String s : dictV) {
				if(isOneCharDiff(s, str) && !mem.contains(s)) {
					queue.add(s);
					countQueue.add(count+1);
					mem.add(s);
				}
			}
			
		}
		
		return 0;
    }
	
	private boolean isOneCharDiff(String a, String b) {
		int count = 0;
		for(int i =0; i < a.length() ; i++) {
			if(a.charAt(i) != b.charAt(i)) {
				count++;
			}
		}
		
		return count == 1;
	}
}
