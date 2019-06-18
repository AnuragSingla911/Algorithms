package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class cloneGraph {

	 public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		 
		 if(node == null) {
			 return node;
		 }
	        
		 
		 HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
		 
		 Queue<UndirectedGraphNode> queue = new LinkedList<>();
		 
		 queue.add(node);
		
		 UndirectedGraphNode head = new UndirectedGraphNode(node.label);
		 Queue<UndirectedGraphNode> queueClone = new LinkedList<>();
		 queueClone.add(head);
		 map.put(node, head);
		 
		 while(!queue.isEmpty()) {
			 UndirectedGraphNode node0 = queue.poll();
			 UndirectedGraphNode clone0 = queueClone.poll();
			 if(node0.neighbors != null) {
				 ArrayList<UndirectedGraphNode> cloneList = new ArrayList<>();
				 for(UndirectedGraphNode neighour : node0.neighbors) {
					 if(map.containsKey(neighour)) {
						 cloneList.add(map.get(neighour));
					 }else {
						 UndirectedGraphNode newNode = new UndirectedGraphNode(neighour.label);
						 map.put(neighour, newNode);
						 cloneList.add(newNode);
						 queue.add(neighour);
						 queueClone.add(newNode);
					 }
				 }
				 clone0.neighbors = cloneList;
			 }
		 }
		 
		 
		 return head;
		 
		 
	    }
	 
	 
	 class UndirectedGraphNode {
		      int label;
		      List<UndirectedGraphNode> neighbors;
		      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
		  }
}
