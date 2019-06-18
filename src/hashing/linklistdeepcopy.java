package hashing;

import java.util.HashMap;

public class linklistdeepcopy {
	
	
	public static void main(String[] args) {
		RandomListNode t = new RandomListNode(9);
		t.next = new RandomListNode(5);
		t.next.next = new RandomListNode(7);
		t.next.random = t;
		t.next.next.next = new RandomListNode(10);
		
		RandomListNode result = new linklistdeepcopy().copyRandomList(t);
		
		while(result != null) {
			System.out.println(result.label);
			result = result.next;
		}
	}
	
	

	 public RandomListNode copyRandomList(RandomListNode head) {
	        
	        HashMap<RandomListNode,RandomListNode> copyMap = new HashMap<>();
	        
	        RandomListNode headCopy = new RandomListNode(-1);
	        RandomListNode result = headCopy;

	        while(head != null){
	            
	            if(copyMap.containsKey(head)){
	                headCopy.next = copyMap.get(head);
	            }else{
	                RandomListNode temp = new RandomListNode(head.label);
	                headCopy.next = temp;
	                copyMap.put(head, temp);
	            }
	            
	            if(head.random != null){
	            if(copyMap.containsKey(head.random)){
	                headCopy.next.random = copyMap.get(head.random);
	            }else{
	                RandomListNode temp = new RandomListNode(head.random.label);
	                headCopy.next.random = temp;
	                copyMap.put(head.random, temp);
	            }
	            }
	            
	            if(result == null){
	                result = headCopy;
	            }
	            
	            
	            
	            head = head.next;
	            headCopy = headCopy.next;
	        }
	        
	        return result.next;
	    }

}

class RandomListNode {
	      int label;
	      RandomListNode next, random;
	     RandomListNode(int x) { this.label = x; }
	  }
