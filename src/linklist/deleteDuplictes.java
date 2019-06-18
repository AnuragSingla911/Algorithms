
package linklist;

public class deleteDuplictes {

	public static void main(String[] args) {
			C obj = new deleteDuplictes.C();
			ListNode t = new deleteDuplictes.ListNode(2);
			t.next = new deleteDuplictes.ListNode(2);
			t.next.next = new deleteDuplictes.ListNode(3);
			t.next.next.next = new deleteDuplictes.ListNode(5);
			t.next.next.next.next = new deleteDuplictes.ListNode(5);
			
			ListNode result = obj.deleteDuplicates(t);
			
			while(result != null) {
				System.out.println(result.val);
				result=result.next;
			}
			
			
			
	}

	public ListNode deleteDuplicates(ListNode A) {

		if (A == null) {
			return A;
		}

		ListNode B = A;

		while(A.next != null) {
			if(A.val == A.next.val) {
				A.next = A.next.next;
			}else {
				A = A.next;
			}
		}

		return B;
	}

	static class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	} 
	static class C {
		 public ListNode deleteDuplicates(ListNode A) {

	            if (A == null) {
	                return A;
	            }

	            ListNode head = new ListNode(-1);
	            head.next = A;
	            ListNode result = head;
	            while(A != null) {
	                boolean isFound = false;
	                while(A.next != null && A.val == A.next.val) {
	                    isFound = true;
	                    A = A.next;
	                }
	                
	                if(isFound){
	                head.next = A.next;
	                isFound = false;
	                }else {
	                	head = A;
	                	A = A.next;
	                	continue;
	                }
	                
	               A = A.next;
	                if(A != null && A.next != null && A.val != A.next.val)
	                	
	                head = head.next;

	            




	            }

	            return result.next;
	        }

	}
}

