package linklist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import algo.Utilities;
import linklist.deleteDuplictes.ListNode;

public class insertionsortlinklist {

	public static void main(String[] args) {
		
		
		ListNode t = new deleteDuplictes.ListNode(2);
		t.next = new deleteDuplictes.ListNode(4);
		t.next.next = new deleteDuplictes.ListNode(5);
		t.next.next.next = new deleteDuplictes.ListNode(1);
		t.next.next.next.next = new deleteDuplictes.ListNode(3);
		
		ListNode result = new insertionsortlinklist().insertionSortList(t);
		
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
		
	}
	
	  public ListNode insertionSortList(ListNode A) {
		  
		  if(A == null || A.next == null) {
			  return A;
		  }
		  
		 
		
		  
		  ListNode pointer = A;
		  
		  ListNode result = null;
		  
		  
		  while(pointer != null) {
			  
			  
			  	  ListNode t = pointer.next;
			  
				  if(result == null || result.val > pointer.val) {
					  pointer.next = result;
					  result = pointer;
				  }else {
					  ListNode temp = result;
					  
					  
					  while(temp.next != null && temp.next.val <= pointer.val) {
						  temp = temp.next;
					  }
					 
					  
					  pointer.next=temp.next;
					  temp.next= pointer;
				  }
			  
			
			 pointer = t;
			  
			  
		  }
		  
		 
		  
		  return result;
		  
		  
		  
		  
		  
	    }
	  
	  
	  public void inertionAort(ArrayList<Integer> list) {
		  
		  for(int i = 1; i < list.size() ; i++) {
			  int no = list.get(i);
			  int index = i-1;
			  for(int j = i-1; j >= 0 ; j--) {
				  if(no < list.get(j)) {
					 list.set(j+1, list.get(j));
					 
				  }else {
					  index=j;
					  break;
				  }
			  }
			  list.set(index+1, no);
			  
		  }
	  }
}
