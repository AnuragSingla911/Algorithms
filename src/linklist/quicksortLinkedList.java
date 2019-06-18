package linklist;

import linklist.deleteDuplictes.ListNode;

public class quicksortLinkedList {

	public static void main(String[] args) {
		ListNode t = new deleteDuplictes.ListNode(1);
		t.next = new deleteDuplictes.ListNode(3);
		t.next.next = new deleteDuplictes.ListNode(8);
		t.next.next.next = new deleteDuplictes.ListNode(4);
		t.next.next.next.next = new deleteDuplictes.ListNode(5);
		
		ListNode result = new quicksortLinkedList().partition(t);
		
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
		
		
	}
	
	 public ListNode partition(ListNode A){
		 
		 if(A == null || A.next == null) {
			 return A;
		 }
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
	        
	        ListNode x = partition(A);
	        ListNode y = partition(temp);
	        
	        return mergeTwoLists(x,y);
	    }
	
	 public ListNode mergeTwoLists(ListNode A, ListNode B) {
	        
	        if(A == null){
	            return B;
	        }
	        
	        if(B == null){
	            return A;
	        }
	        
	        ListNode head = null;
	        
	        if(A.val > B.val){
	            head = B;
	            B = B.next;
	        }else{
	            head = A;
	            A = A.next;
	        }
	        
	    
	        
	        ListNode result = head;
	        
	        while(A != null && B != null){
	            if(A.val > B.val){
	                head.next = B;
	                B = B.next;
	            }else{
	                head.next = A;
	                A = A.next;
	            }
	            
	            head = head.next;
	        }
	        
	        
	        while(A != null){
	            head.next = A;
	            A = A.next;
	            head = head.next;
	        }
	        
	        while(B != null){
	            head.next = B;
	            B = B.next;
	            head = head.next;
	        }
	        
	        return result;
	    }
	
	
	
}
