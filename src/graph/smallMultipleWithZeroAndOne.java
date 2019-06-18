package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class smallMultipleWithZeroAndOne {

	public static void main(String[] args) {
		System.out.println(new smallMultipleWithZeroAndOne().multiple(99));
	}
	
	 private static class Node {
	        public final boolean isDigitOne;
	        public final int val;
	        public final Node prev;
	        public Node(boolean isDigitOne, int val, Node prev) {
	            this.isDigitOne = isDigitOne;
	            this.val = val;
	            this.prev = prev;
	        }
	    }
	 
	    public static String multiple0(int num) {
	        if (num < 0) {
	            throw new IllegalArgumentException("Invalid args");
	        }

	        String result = "0";

	        if (num > 0) {
	            // A set to store all the visited nodes
	            boolean[] isVisited = new boolean[num];
	            Arrays.fill(isVisited, false);

	            Set<Integer> visitedSet = new HashSet<>();
	            // The queue used by BFS
	            Queue<Node> queue = new ArrayDeque<>();

	            // Add the first number 1 and mark it visited
	            queue.add(new Node(true, 1 % num, null));
	            isVisited[1 % num] = true;

	            // The final destination node which represents the answer
	            Node destNode = null;
	            int x = 1;
	            while (!queue.isEmpty()) {
	                // Get the next node from the queue
	                Node currNode = queue.remove();
	                System.out.println(currNode.val + " "+currNode.val % num + " " + x++);
	                if (currNode.val == 0) {
	                    // We have reached a valid multiple of num
	                    destNode = currNode;
	                    break;
	                } else {
	                    // Visit the next 2 neighbors
	                    // Append 0 - (currNode.val * 10)
	                    // Append 1 - (currNode.val * 10) + 1

	                    // Append a '0'
	                    int val1 = (currNode.val * 10) % num;
	                    if (!isVisited[val1]) {
	                        queue.add(new Node(false, val1, currNode));
	                        isVisited[val1] = true;
	                    }
	                    
	                    // Append a '1'
	                    int val2 = (currNode.val * 10  + 1) % num;
	                    
	                    if (!isVisited[val2]) {
	                        queue.add(new Node(true, val2, currNode));
	                        isVisited[val2] = true;
	                    }
	                }
	            }

	            // Trace the path from destination to source
	            if (destNode == null) {
	                throw new IllegalStateException("Result should not be null");
	            } else {
	                StringBuilder reverseResultBuilder = new StringBuilder();
	                Node currNode = destNode;
	                while (currNode != null) {
	                    reverseResultBuilder.append(currNode.isDigitOne ? '1' : '0');
	                    currNode = currNode.prev;
	                }
	                result = reverseResultBuilder.reverse().toString();
	            }
	        }

	        return result;
	    }
	    
	 public String multiple(int A) {
	        
	        if(A < 2){
	            return String.valueOf(A);
	        }
	        
	        Queue<Node> queue = new LinkedList<Node>();
	        
	        queue.add(new Node(true, 1 % A, null));
	       
	        Node dest = null;
	        
	        int x = 1;
	      
	        while(!queue.isEmpty()){
	            
	            Node cur = queue.poll();
	           
	         System.out.println(cur.val + " "+cur.val % A + " " + x++);
	            	if(cur.val % A == 0) {
	            		dest = cur;
	            		break;
	            	}else {
	            		
	            	}
	            
	            	int no1 = (cur.val%A) * 10;
	            	no1 = no1 % A;
	            	if(!map.containsKey(no1)) {
	            		queue.add(new Node(false, no1, cur));
	            		map.put(no1, false);
	            		
	            	}
	            	
	            	int no2 = (cur.val%A) * 10 + 1;
	            	no2 = no2 % A;
	            	if(!map.containsKey(no2)) {
	            queue.add(new Node(true, no2, cur));
	            map.put(no2, false);
	            	}
	        }
	        
	        
	        StringBuilder bulder  = new StringBuilder();
	        while(dest != null) {
	        		bulder.append(dest.isDigitOne ? "1" : "0");
	        		dest = dest.prev;
	        }
	        return bulder.reverse().toString();
	    }
	 HashMap<Integer,Boolean> map = new HashMap<>();
	
}
