package linklist;

import linklist.deleteDuplictes.ListNode;

public class detectCycle {
	
	public static void main(String[] args) {
		ListNode t = new deleteDuplictes.ListNode(1);
		t.next = new deleteDuplictes.ListNode(2);
		t.next.next = new deleteDuplictes.ListNode(3);
		t.next.next.next = new deleteDuplictes.ListNode(4);
		t.next.next.next.next = new deleteDuplictes.ListNode(5);
		t.next.next.next.next.next = new deleteDuplictes.ListNode(6);
		t.next.next.next.next.next.next = new deleteDuplictes.ListNode(7);

		t.next.next.next.next.next.next.next = t.next.next;
		
		ListNode result = new detectCycle().detectCycle(t);
		
		System.out.println(result.val);
	}

	 public ListNode detectCycle(ListNode A) {
		 
		 if(A == null || A.next == null) {
			 return null;
		 }
		 
		 ListNode result = isCyclic(A, A.next);
		 
		 if(result == null) {
			 return null;
		 }else {
			 ListNode temp = result.next;
			 int size = 1;
			 while(temp != result) {
				 size++;
				 temp = temp.next;
			 }
			 
			 
			 ListNode temp2 = A;
			 while(size > 0) {
				 temp2 = temp2.next;
				 size--;
			 }
			 
			
			 while(temp2 != A) {
				 temp2  = temp2.next;
				 A = A.next;
			 }
			 
			 return temp2;
		 }
		 
		
		
		
	        
	        
	    }
	 
	 
	 public ListNode isCyclic(ListNode first, ListNode second) {
		
	        while(first != null && second != null){
	           
	            
	            if(second.next != null){
	            	 first = first.next;
	                second = second.next.next;
	                
	                if(first == second) {
	                	return first;
	                }
	            }else{
	                break;
	            }
	        }
	        
	        return null;
	 }
}
