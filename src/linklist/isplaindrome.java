package linklist;

import java.util.Stack;

public class isplaindrome {
	
	public static void main(String[] args) {
		
	}

	public int lPalin(ListNode B) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode A = B;
        while(A != null) {
        		stack.push(A);
        		A = A.next;
        }
        
        while(B != null) {
        		if(stack.pop().val == B.val) {
        			B = B.next;
        		}else {
        			return 0;
        		}
        }
        return 1;
    }

class ListNode {
	     public int val;
	      public ListNode next;
	      ListNode(int x) { val = x; next = null; }
	  }
}
