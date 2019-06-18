package tree;

import java.util.LinkedList;
import java.util.Queue;

public class totalsumofpaths {
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(4);
		node.left = new TreeNode(3);
		node.left.left = new TreeNode(1);
		node.left.left.right = new TreeNode(2);
		
		node.right = new TreeNode(7);
		node.right.left = new TreeNode(6);
		node.right.left.left = new TreeNode(5);
		node.right.right = new TreeNode(8);
		
		
		System.out.println(new totalsumofpaths().sumNumbers(node));
	}

	  public int sumNumbers(TreeNode A) {
	        
	        
	        long sum = 0;
	        
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        Queue<Long> numberQueue = new LinkedList<Long>();
	        queue.add(A);
	        numberQueue.add((long)A.val);

	        while(!queue.isEmpty()){
	            TreeNode treeNode = queue.poll();
	            
	            long no = numberQueue.poll();

	            if(treeNode.left == null && treeNode.right == null){
	            		System.out.println("adding sum : "+ no);
	                sum+= no;
	            }
	            
	            if(treeNode.left != null){
	                queue.add(treeNode.left);
	                long noo = no * 10L + (long)treeNode.left.val;
	                numberQueue.add(noo);
	                
	            }
	            
	            if(treeNode.right != null){
	                queue.add(treeNode.right);
	                 long noo = no * 10L + (long)treeNode.right.val;
	                  numberQueue.add(noo);
	            }
	            
	            
	        }
	        
	        
	        return (int)(sum % 1003L);
	        
	        
	    }
}
