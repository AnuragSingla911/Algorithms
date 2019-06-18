package treemaporheapify;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class mergeKShortlist {
	
	public static void main(String[] args) {
		mergeKShortlist obj = new mergeKShortlist();
		ListNode ListNode = obj.new ListNode(4);
		ListNode.next = obj.new ListNode(3);
		
		ListNode ListNode1 = obj.new ListNode(7);
		ListNode1.next = obj.new ListNode(2);
		
		ArrayList<ListNode> t = new ArrayList<>();
		
		t.add(ListNode);
		t.add(ListNode1);
		
		obj.mergeKLists(t);
		
	}

	 public ListNode mergeKLists(ArrayList<ListNode> a) {
	        
		 PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
			 @Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o2.val > o1.val ? 1 : -1;
			}
		});
		 for(ListNode ListNode : a) {
			 while(ListNode != null) {
				 queue.add(ListNode);
				 ListNode = ListNode.next;
			 }
		 }
		 
		 ListNode ListNode = queue.poll();
		 ListNode result = ListNode;
		 
		 while(!queue.isEmpty()) {
			 ListNode temp = queue.poll();
			 ListNode.next = temp;
			 ListNode = ListNode.next;
		 }
		 
		 return result;
		 
		 
         
	    }
	 
	
	 class ListNode {
		    public int val;
		      public ListNode next;
		      ListNode(int x) { val = x; next = null; }
		     
		
		  }
}
