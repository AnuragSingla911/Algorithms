package linklist;

import linklist.deleteDuplictes.ListNode;

public class KReverse {

	public static void main(String[] args) {
		ListNode t = new deleteDuplictes.ListNode(1);
		t.next = new deleteDuplictes.ListNode(2);
		t.next.next = new deleteDuplictes.ListNode(3);
		t.next.next.next = new deleteDuplictes.ListNode(4);
		t.next.next.next.next = new deleteDuplictes.ListNode(5);
		
		ListNode result = new KReverse().reverseList(t, 2);
		
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
	
	 public ListNode reverseList(ListNode A, int B) {
		 
		 
		 int size = 0;
		 ListNode temp1 = A;
		 
		 while(temp1 != null) {
			 size++;
			 temp1 = temp1.next;
		 }
		 
		
		 ListNode prev = null;
		 ListNode current = A;
		 
		 ListNode result = null;
		 
		 ListNode temp3, temp2 = null;
		 
		 for(int i =0; i< size/B; i++) {
			 
			 temp3 = temp2;
			 temp2 = current;
			 
			 for(int j =0; j < B ; j++) {
			 
			
				 ListNode next = current.next;
				 
				 current.next = prev;
				 
				
				 
				 prev = current;
				 
				 current = next;
				 
				 if(i == 0 && j == B-1) {
					 result = prev;
				 }
				
				 
			 }
			 
			 if(temp3 != null)
			 temp3.next = prev;
			 temp2.next = current;
			 prev = temp2;
			 
			
			 
			 
			 
			
		 }
		 
		 return result;
	    }
}
