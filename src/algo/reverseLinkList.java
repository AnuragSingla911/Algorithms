package algo;

public class reverseLinkList {
	
	public static void main(String[] args) {
		LinkNodeList list=new LinkNodeList();
		list.add(new LinkNode(7));
		list.add(new LinkNode(8));
		list.add(new LinkNode(10));
		
		list.print();
		list.reverseList();
		list.print();
		list.sort();
		list.print();
	}

}

class LinkNodeList{
	LinkNode head;
	
	LinkNode currentNode;
	
	void add(LinkNode node) {
		if(head==null) {
			head=node;
		}
		
		if(currentNode==null) {
			currentNode=node;
		}
		
		currentNode.next=node;
		
		currentNode=node;
		
		
		
		
	}
	
	void print(){
		LinkNode t = head;
		while(t !=null) {
			System.out.println(t.value);
			t =t.next;
		}
	}
	
	void reverseList() {
		reverse(head, null);
	}
	
	void sort() {
		head=mergeSort(head);
	}
	
	
	
	private LinkNode mergeSort(LinkNode root) {
		
		if(root.next==null) {
			return root;
		}
		
		LinkNode middle= middle(root);
		
		
		LinkNode temp = middle.next;
		middle.next=null;
		
		LinkNode left = mergeSort(root);
		LinkNode right = mergeSort(temp);
		
		return merge(left,right);
		
	}
	
	private LinkNode merge(LinkNode a,LinkNode b) {
		
		if(a==null)return b;
		if(b==null)return a;
		
		LinkNode c=null;
		if(a.value <= b.value) {
			c=a;
			c.next=merge(a.next,b);
		}else {
			c=b;
			c.next=merge(a,b.next);
		}
		
		return c;
	}
	
	LinkNode middle(LinkNode node) {
		if(node==null) {
			return null;
		}
		LinkNode slow=node;
		LinkNode fast=node.next;
		
		while(fast != null) {
			fast=fast.next;
			if(fast !=null) {
				slow = slow.next;
				fast= fast.next;
			}
			
		}
		
		return slow;
	}
	
	void reverse(LinkNode node,LinkNode prev) {
		
		if(node==null) {
			return;
		}
		
		if(node.next==null) {
			head=node;
		}
		
		LinkNode temp=  node.next;
		if(temp != null) {
			reverse(temp, node);
		}
		node.next=prev;	
	}
}

class LinkNode{
	int value;
	LinkNode next;
	
	LinkNode(int val){
		this.value=val;
	}
}
