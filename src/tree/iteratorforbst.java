package tree;

import java.util.Stack;

public class iteratorforbst {
	
	Stack<TreeNode> stack = new Stack<TreeNode>();
	
	TreeNode cur = null;

	 public iteratorforbst(TreeNode root) {
		 
		 TreeNode cur = root;
		 while(cur != null) {
			 stack.push(cur);
			 cur = cur.left;
		 }
		 
	        
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return stack.isEmpty() && cur == null ? false : true;
	    }

	    /** @return the next smallest number */
	    public int next() {
	    	
	    	 while(cur != null) {
				 stack.push(cur);
				 cur = cur.left;
			 }
	       cur = stack.pop();
	       
	       int val = cur.val;
	        
	       cur = cur.right;
	       
	       return val;
	       
	       
	    }
}
