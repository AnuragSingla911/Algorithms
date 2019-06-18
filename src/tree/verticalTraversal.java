package tree;

import java.util.ArrayList;
import java.util.TreeMap;


public class verticalTraversal {

	 public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
		 find(A, 0,0);
		 
		 return new ArrayList<ArrayList<Integer>>(list.values());
	    }
	 
	 TreeMap<Integer, ArrayList<Integer>> list = new TreeMap<>();
	 
	 private void find(TreeNode A, int index, int depth) {
		 
		
		 
		 if(A.left != null) {
			 find(A.left, index-1, depth+1);
		 }
		 
		 if(!list.containsKey(index)) {
			 list.put(index, new ArrayList<Integer>());
		 }
		 
		 list.get(index).add(A.val);
		 
		 if(A.right != null) {
			 find(A.right, index+1, depth+1);
		 }
	 }
}

class DepthValue {
	
}

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
