package linklist;

import linklist.deleteDuplictes.ListNode;

public class reorderList {

	public static void main(String[] args) {
		ListNode t = new deleteDuplictes.ListNode(1);
		t.next = new deleteDuplictes.ListNode(2);
		t.next.next = new deleteDuplictes.ListNode(3);
		t.next.next.next = new deleteDuplictes.ListNode(4);
		
		ListNode result = new reorderList().reorderList(t);
		
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
	
	public ListNode reorderList(ListNode A) {
		
		ListNode first= A;
        ListNode second = A.next;
        while(first != null && second != null){
           
            
            if(second.next != null){
            	 first = first.next;
                second = second.next.next;
            }else{
                break;
            }
        }
        
        ListNode temp = first.next;
        first.next = null;
        
        ListNode prev = null;
        
        ListNode current = temp;
        
        while(current != null) {
        	ListNode next = current.next;
        	current.next = prev;
        	prev= current;
        	current = next;			
        }
        
        ListNode result = new ListNode(-1);
        ListNode t=result;
        boolean isA = true;
        while(A != null || prev != null) {
        		if(isA) {
        			result.next = A;
        			A = A.next;
        			result = result.next;
        			isA = false;
        		}else {
        			result.next = prev;
        			prev = prev.next;
        			result = result.next;
        			isA = true;
        		}
        }
        
        return t.next;
    }
}
