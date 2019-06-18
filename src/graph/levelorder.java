package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class levelorder {
	
	class TreeNode {
		    int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) {
		       val = x;
		       left=null;
		       right=null;
		      }
		  }

	 public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
		 
		 ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		 
		 if(A == null) {
			 return result;
		 }
		 
		 List<TreeNode> list = new LinkedList<TreeNode>();
		 
		 list.add(A);
		 
		 while(!list.isEmpty()) {
			 
			 ArrayList<Integer> cur = new ArrayList<>();
			 
			 int size = list.size();
			 
			 for(int i =0; i< size ; i++) {
				 TreeNode node = list.remove(0);
				 cur.add(node.val);
				 
				 if(node.left != null) {
					 list.add(node.left);
				 }
				 
				 if(node.right != null) {
					 list.add(node.right);
				 }
			 }
			 
			 result.add(cur);
			 
		 }
		 
		 return result;
	    }
}
