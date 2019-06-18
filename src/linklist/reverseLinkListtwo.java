package linklist;

import linklist.deleteDuplictes.ListNode;

public class reverseLinkListtwo {

	public static void main(String[] args) {
		ListNode t = new deleteDuplictes.ListNode(1);
		t.next = new deleteDuplictes.ListNode(2);
		t.next.next = new deleteDuplictes.ListNode(3);
		t.next.next.next = new deleteDuplictes.ListNode(4);
		t.next.next.next.next = new deleteDuplictes.ListNode(5);
		
		ListNode result  = new reverseLinkListtwo().reverseBetween(t, 2, 5);
		
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	 public ListNode reverseBetween(ListNode A, int B, int C) {
		 
		 
		 ListNode temp = A;
		 
		 while( B > 2) {
			 temp = temp.next;
		 }
		 
		
		 
		 ListNode prev = temp;
		 ListNode temp2 = temp.next;
		 ListNode current = temp.next;
		 
 if(B == 1) {
		prev = null;
		temp = null;
		temp2 = A;
		current  = A;
		 }
		 
		 for(int j = B; j <= C ; j++) {
			 
				
			 ListNode next = current.next;
			 
			 current.next = prev;
			 
			
			 
			 prev = current;
			 
			 current = next;
			 
			 
			
			 
		 }
		 
		 temp2.next = current;
		 if(temp != null) {
		 
		 
			 temp.next = prev;
		 }
		
		 
		 return B == 1 ? prev : A;
		 
	    }
}
