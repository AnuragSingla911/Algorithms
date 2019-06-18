package linklist;

import linklist.deleteDuplictes.ListNode;

public class partition {
	
	public static void main(String[] args) {
		ListNode t = new deleteDuplictes.ListNode(2);
		t.next = new deleteDuplictes.ListNode(4);
		t.next.next = new deleteDuplictes.ListNode(3);
		t.next.next.next = new deleteDuplictes.ListNode(1);
		t.next.next.next.next = new deleteDuplictes.ListNode(5);
		
		ListNode result  = new partition().partition(t, 4);
		
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	 public ListNode partition(ListNode A, int B) {
		 
		 ListNode pointerA = A;
		 
		 ListNode pointerB = A;
		 
		 ListNode pointerAPrev = null;
		 
		 ListNode pointerBPrev = null;
		 
		 while(pointerA.val < B) {
			 pointerAPrev = pointerA;
			 pointerA = pointerA.next;
		 }
		 
		 pointerB = pointerA;
		 pointerBPrev = pointerAPrev;
		 
		 boolean isResult = false;
		 
		 ListNode result = A;
		 
		 while(pointerB != null) {
			 
			
			
			 
			 while(pointerB != null  && pointerB.val >= B) {
				 
				 pointerBPrev = pointerB;
				 pointerB = pointerB.next;
			 }
			 
			 if(pointerB == null) {
				 continue;
			 }
			 
			 if(pointerA == A && !isResult && pointerB != null) {
				 isResult = true;
				 result = pointerB;
			 }
			
			 if(pointerB != null) {
			 pointerBPrev.next = pointerB.next;
			 }
			 if(pointerAPrev != null)
			 pointerAPrev.next = pointerB;
			 if(pointerB != null)
			 pointerB.next = pointerA;
			 
				 pointerAPrev = pointerB;
			 
			 
			 pointerB = pointerA.next;
			 pointerBPrev = pointerA;
			 
			 
		 }
		 
		 return result;
	    }
}
