package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import algo.Utilities;

public class ladderLengthTwo {
	
		

	
		public static void main(String[] args) {
			
			
			String s = "abbbbb bbabba abbaba baaabb bbbabb babbab aaabaa aaabbb bbbaab aabaaa aaaaaa baaabb aababa aaabab bbbaaa aabaab ababab bbaaba ababba abaaab baaaab aababb aaaaaa abbbab aaabab bbabab aaaabb aaaaab babaab babbab baaaba aabbaa aabbaa bbabab bbaaba abbbbb bbbbbb babaab baaaab abaaab abbaab aaaaaa bbbbba babbba bbbabb abaaab aabbba baaaba aabbbb";
			
			
			
			ArrayList<String> list= new ArrayList<>();
			
			for(String s0 : s.split(" ")) {
				list.add(s0);
			}
			
			Utilities.print2DArrayList(new ladderLengthTwo().findLadders("baaaba","aabbbb", list));
		}
		
	    public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dict) {

	    	 
	    	
            if(start != null && start.equals(end)){
                 ArrayList<ArrayList<String>> r = new ArrayList<ArrayList<String>>();
                  ArrayList<String> l = new ArrayList<>();
                  l.add(start);
                  r.add(l);
                  return r;
            }
			
           
			Queue<String> queue = new LinkedList<String>();
			Queue<Integer> countQueue = new LinkedList<Integer>();
			Queue<ArrayList<String>> QueueList = new LinkedList<>();
			queue.add(end);
			countQueue.add(1);
			HashSet<ArrayList<String>> mem = new HashSet<>();
			
			ArrayList<String> list = new ArrayList<>();
			
			list.add(end);
			mem.add(list);
			QueueList.add(list);
			
			ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
			int shortestCount = Integer.MAX_VALUE;
			while(!queue.isEmpty()) {
				String str = queue.poll();
				System.out.println(str);
				int count = countQueue.poll();
				
				ArrayList<String> queueList0 = QueueList.poll();
			//	Utilities.printArrayList(queueList0);
				if(isOneCharDiff(str, start)) {
					if(count <= shortestCount) {
						shortestCount = count;
						ArrayList<String> queueList1 = new ArrayList<String>(queueList0);
						queueList1.add(start);
						mem.add(queueList1);
						Collections.reverse(queueList1);
						result.add(queueList1);
						continue;
					}
				}
				
				if(count > shortestCount) {
					continue;
				}
				
				for(String s : dict) {
					ArrayList<String> queueList1 = new ArrayList<String>(queueList0);
					
					queueList1.add(s);
					
					if(isOneCharDiff(s, str) && !mem.contains(queueList1) && !queueList0.contains(s)) {
						queue.add(s);
						countQueue.add(count+1);
						
						QueueList.add(queueList1);
						mem.add(queueList1);
					}
				}
				
			}
			//Collections.reverse(result);
			return result;
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
