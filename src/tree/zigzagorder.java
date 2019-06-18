package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import algo.Utilities;

public class zigzagorder {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(4);
		node.left = new TreeNode(3);
		node.left.left = new TreeNode(1);
		node.left.left.right = new TreeNode(2);
		
		node.right = new TreeNode(7);
		node.right.left = new TreeNode(6);
		node.right.left.left = new TreeNode(5);
		node.right.right = new TreeNode(8);
		
		Utilities.print2DArrayList(new zigzagorder().zigzagLevelOrder(node));
	}
	
	
	 public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
		 
		 LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		 
		queue.add(A);
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		boolean isLefttoright = true;
		 while(!queue.isEmpty()) {
			 
			 
			 
			 ArrayList<Integer> list = new ArrayList<>();
			 int size = queue.size();
			 for(int i =0; i< size ; i++) {
				 
					 TreeNode treeNode =  queue.remove(size-i-1);
					 

					 list.add(treeNode.val);
					 
					 if(isLefttoright) {
					 if(treeNode.left != null)
						 queue.add(treeNode.left);

					 if(treeNode.right != null) {
						 queue.add(treeNode.right);
					 }
					 }else {
						 if(treeNode.right != null) {
							 queue.add(treeNode.right);
						 } 
						 
						 if(treeNode.left != null)
							 queue.add(treeNode.left);

					 }
				
			 }
			 
			 result.add(list);
			 isLefttoright = !isLefttoright;
			 
			 
			 
			 
		 }
		 
		 return result;
	    }
}
