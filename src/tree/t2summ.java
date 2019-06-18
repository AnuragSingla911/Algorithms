package tree;

import java.util.Stack;

public class t2summ {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(19);
		
		System.out.println(new t2summ().t2Sum(root, 17));
	}
	
	 public int t2Sum(TreeNode A, int B) {
		 
		 return findSumExist(A, B);
		 
	    }
	 
	 private int findSumExist(TreeNode A, int sum) {
		 
		 Stack<TreeNode> leftStack = new Stack<TreeNode>();
		 Stack<TreeNode> rightStack = new Stack<TreeNode>();
		 
		 TreeNode left = A;
		
		 
		 TreeNode right = A;
		 
		 
		 TreeNode first = null;
		 TreeNode second = null;
		 while(true) {
			 while(left != null) {
				 leftStack.push(left);
				 left = left.left;
			 }
			 
			 while(right != null) {
				 rightStack.push(right);
				 right = right.right;
			 }
			 if(first == null)
			 first = leftStack.pop();
			 if(second == null)
			 second = rightStack.pop();
			 
			 System.out.println("first : "+ first.val + " second :"+ second.val);
			 if(first == second) {
				 return 0;
			 }
			
			 
			 if(first.val+ second.val == sum) {
				 return 1;
			 }else if(first.val + second.val > sum) {
				
				 right = second.left;
				 second = null;
			 }else {
				 left = first.right;
				 first = null;
			 }
		 }
		 
		
	 }
}
