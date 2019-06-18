package linklist;

import linklist.deleteDuplictes.ListNode;

public class rotateList {

	public static void main(String[] args) {
		ListNode t = new deleteDuplictes.ListNode(1);
		t.next = new deleteDuplictes.ListNode(2);
		t.next.next = new deleteDuplictes.ListNode(3);
		t.next.next.next = new deleteDuplictes.ListNode(4);
		
		ListNode result = new rotateList().rotateRight(t, 2);
		
		while(result != null) {
			System.out.println(result.val);
			result=result.next;
		}
	}
	
	 public ListNode rotateRight(ListNode A, int B) {
		 
		 if(B == 0) {
			 return A;
		 }
		 
		 ListNode temp = A;
		 
		 int size = 0;
		 while(temp != null) {
			 size++;
			 temp = temp.next;
		 }
		 
		
		
		 temp = A;
		 
		 int i = 0;
		 
		 
 		 while(i < size - B) {
			 temp = temp.next;
			 i++;
		 }
 		 
 		 ListNode head = temp;
 		 
 		 while(temp.next != null) {
 			 temp = temp.next;
 		 }
 		 
 		 temp.next = A;
 		 
 		 int rest = size - B;
 		 
 		 while(rest > 0) {
 			 temp = temp.next;
 			 rest--;
 		 }
 		 
 		 temp.next = null;
 		 
 		 
		 return head;
		 
		 
		 
		 
		 
		 
	    }
}
