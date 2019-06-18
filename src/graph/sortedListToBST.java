package graph;

import java.util.LinkedList;
import java.util.Queue;

public class sortedListToBST {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}


	static class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
	public static void main(String[] args) {
		ListNode node = new ListNode(4);
		ListNode node1 = new ListNode(5);
		ListNode node2 = new ListNode(6);
		node.next = node1;
		node1.next=node2;
		new sortedListToBST().sortedListToBST(node);

	}

	public TreeNode sortedListToBST(ListNode a) {



		ListNode slow = middle(a);

		if(slow.next == null) {
			TreeNode head = new TreeNode(slow.val);
			return head;
		}
		TreeNode head = new TreeNode(slow.next.val);
		Queue<ListNode> list = new LinkedList<ListNode>();
		Queue<TreeNode> tree = new LinkedList<TreeNode>();



		list.add(a);
		list.add(slow.next.next);
		slow.next = null;
		tree.add(head);


		while(!list.isEmpty()) {
			ListNode left = list.poll();
			TreeNode cur = tree.poll();
			if(left != null) {
				ListNode leftMiddle = middle(left);
				if(leftMiddle != null) {
					if(leftMiddle.next == null) {
						cur.left = new TreeNode(leftMiddle.val);
					}else {

						cur.left = new TreeNode(leftMiddle.next.val);
						list.add(left);
						list.add(leftMiddle.next.next);
						leftMiddle.next = null;
						tree.add(cur.left);

					}
				}
			}

			ListNode right = list.poll();
			if(right != null) {
				ListNode rightMiddle = middle(right);
				if(rightMiddle != null) {
					if(rightMiddle.next == null) {
						
							cur.right = new TreeNode(rightMiddle.val);
					}else {
						cur.right = new TreeNode(rightMiddle.next.val);

						list.add(right);
						list.add(rightMiddle.next.next);

						rightMiddle.next = null;
						tree.add(cur.right);

					}
				}
			}
		}

		return head;

	}

	private ListNode middle(ListNode a) {

		int size = 0;
		ListNode c = a;
		while(c != null) {
			c= c.next;
			size++;
		}

		ListNode slow = a;
		ListNode fast = a;
		ListNode prev = null;
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;

		}
		//prev.next=null;
		return size < 2 || size % 2 == 0 ? slow : prev;
	}
}
