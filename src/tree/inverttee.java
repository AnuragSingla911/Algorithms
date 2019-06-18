package tree;

import java.util.LinkedList;
import java.util.Queue;

public class inverttee {

	public TreeNode invertTree(TreeNode A) {
		
		if(A == null) {
			return null;
		}
		
		TreeNode left = A.left != null ? invertTree(A.left) : null;
		
		TreeNode right = A.right != null ? invertTree(A.right) : null;
		
		A.right = left;
		A.left = right;
		
		return A;
    }
	
	
public TreeNode invertTreeIterative(TreeNode A) {
		
		if(A == null) {
			return null;
		}
		
		Queue<TreeNode> a = new LinkedList<TreeNode>();
		
		a.offer(A);
		
		while(!a.isEmpty()) {
			
			TreeNode cur = a.poll();
			if(cur.left != null)
			a.offer(cur.left);
			if(cur.right != null)
			a.offer(cur.right);
			
			TreeNode temp = cur.left;
			
			cur.left = cur.right;
			
			cur.right = temp;
			
			
			
			
		}
		
		return A;
		
		
		
    }
}
