package tree;

import java.util.Stack;

public class kthSmallestInBST {

	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(4);
		node.left = new TreeNode(3);
		node.left.left = new TreeNode(1);
		node.left.left.right = new TreeNode(2);
		
		node.right = new TreeNode(7);
		node.right.left = new TreeNode(6);
		node.right.left.left = new TreeNode(5);
		node.right.right = new TreeNode(8);
		
		System.out.println(new kthSmallestInBST().kthsmallest(node, 7));
		
	}
	
	 public int kthsmallest(TreeNode A, int B) {
		 
		 if(A == null) {
			 return -1;
		 }
	
		
		 return countIter(A, B);
	    }
	 
	
	 
	 private int value;
	 
	 
	 private int countIter(TreeNode A, int B) {
		 
		 Stack<TreeNode> stack = new Stack<TreeNode>();
		 
		 TreeNode cur = A;
		 
		 int count = 0;
		 
		 while(cur != null || !stack.isEmpty()) {
			 
			 while(cur != null) {
				 stack.push(cur);
				 cur = cur.left;
			 }
			 
			 cur = stack.pop();
			 
			 count++;
			 
			 if(count == B) {
				 return cur.val;
			 }
			
			 cur = cur.right;
			 
			
		 }
		 
		 return -1;
		 
		 
	 }
	 private int findIndex(TreeNode A, int count, int B) {
		 
		 if(A == null) {
			 return 0;
		 }
		 
		 if(A.left != null) {
			 int i =  findIndex(A.left, count, B);
			 if(i == -1) {
				 return -1;
			 }
			 
			 count= i;
		 }
		 
		 System.out.println("count = "+ count + " A.left "+ A.val);
		 
		 if(count == B) {
			 value = A.val;
			 return -1;
		 }
		 
		 
		 count+= 1;
		 
		 System.out.println("count = "+ count + " A.center "+ A.val);
		 
		 if(count == B) {
			 value = A.val;
			 return -1;
		 }
		 
		 if(A.right != null) {
			 int i =  findIndex(A.right, count, B);
			 if(i == -1) {
				 return -1;
			 }
			 
			 count= i;
		 }
		 System.out.println("count = "+ count + " A.right "+ A.val);
		 if(count == B) {
			 value = A.val;
			 return -1;
		 }
		 
		 return count;
	 }
}
