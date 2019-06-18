package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import algo.Utilities;

public class sortedArrayToBST {

	public static void main(String[] args) {
		List<Integer> list = Utilities.toList(new Integer[] {1,2});
		
		new sortedArrayToBST().sortedArrayToBST(list);
	}
	
	
	public TreeNode sortedArrayToBST(final List<Integer> a) {
		TreeNode root = new TreeNode(-1);
		return sortedArrayToBSTusingIterative(a);
	}
	
	private TreeNode sortedArrayToBSTusingRecu(final List<Integer> a, int left, int right, TreeNode current)
	{
		
		if(left >= right) {
			return null;
		}
		int middle = (left + right)/2;
		
		current.val = a.get(middle);
		
		if(left < middle) {
			current.left = new TreeNode(-1);
			current.left = sortedArrayToBSTusingRecu(a, left, middle, current.left);
		}
		
		if(middle < right) {
			current.right = new TreeNode(-1);
			current.right = sortedArrayToBSTusingRecu(a, middle+1, right, current.right);
		}
		
		return current;
		
		
	}
	
	 public TreeNode sortedArrayToBSTusingIterative(final List<Integer> a) {
		 
		 int left = 0;
		 int right = a.size();
		 
		 TreeNode current = new TreeNode(-1);
		 TreeNode root = current;
		 
		 Queue<TreeNode> queue = new LinkedList<TreeNode>();
		 Queue<Integer> leftIndexes = new LinkedList<Integer>();
		 Queue<Integer> rightIndexes = new LinkedList<Integer>();
		 queue.add(current);
		 leftIndexes.add(left);
		 rightIndexes.add(right);
		 
		 while(!queue.isEmpty()) {



			 current = queue.poll();
			 left = leftIndexes.poll();
			 right = rightIndexes.poll();
			 
			 if(left >= right) {
				 continue;
			 }
			 
			 int middle = (left+right)/2;
			 current.val = a.get(middle);

			 if(left < middle) {
				 current.left = new TreeNode(-1);
				 queue.add(current.left);
				 leftIndexes.add(left);
				 rightIndexes.add(middle);

			 }

			 if(middle+1 < right) {
				 current.right = new TreeNode(-1);
				 queue.add(current.right);
				leftIndexes.add(middle+1);
				rightIndexes.add(right);
			 }


		 }
		 
		 return root;
		 
	 }
}
