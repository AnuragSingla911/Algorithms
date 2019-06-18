package linklist;

import linklist.deleteDuplictes.ListNode;

public class addTwoLinkList {

	public static void main(String[] args) {
		ListNode t = new deleteDuplictes.ListNode(9);
		t.next = new deleteDuplictes.ListNode(9);
		t.next.next = new deleteDuplictes.ListNode(9);
		
		ListNode t1 = new deleteDuplictes.ListNode(1);

		
		ListNode result = new addTwoLinkList().addTwoNumbers(t, t1);
		
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
	
	 public ListNode addTwoNumbers(ListNode A, ListNode B) {
	        
	       
	        
	        ListNode result = new ListNode(-1);
	        ListNode t = result;
	       
	        ListNode larger = A;
	        ListNode smaller = B;
	        
	        int carry = 0;
	        while(larger != null || smaller != null) {
	        		int l = larger != null ? larger.val : 0;
	        		int s = smaller != null ? smaller.val : 0;
	        		int val = l+ s + carry;
	        		
	        		if(val >= 10) {
	        			carry = val / 10;
	        		}else {
	        			carry = 0;
	        		}
	        		
	        		ListNode temp2 = new ListNode(val % 10);
	        		result.next = temp2;
	        		result = result.next;
	        		if(larger != null)
	        		larger = larger.next;
	        		if(smaller != null)
	        		smaller=smaller.next;
	        }
	        
	        if(carry > 0) {
	        	ListNode temp2 = new ListNode(carry);
	        	result.next = temp2;
	        }
	        
	        return t.next;
	        
	        
	        
	    }
}
