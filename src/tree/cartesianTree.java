package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import algo.Utilities;

public class cartesianTree {

	public static void main(String[] args) {
		ArrayList<Integer> list = Utilities.toList(new Integer[] {1,2,3});
		new cartesianTree().buildTree(list);
	}
	
	public TreeNode buildTree(ArrayList<Integer> A) {
		return buildTreeusingIterative(A);
    }
	
 public TreeNode buildTreeusingIterative(final List<Integer> A) {
		 
		 int left = 0;
		 int right = A.size();
		 
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
			 
			 if(left > right) {
				 continue;
			 }
			 
			 int max = A.get(left);
				int index=left;
				for(int i = left+1; i <= right; i++) {
					if(A.get(i) > max) {
						max = A.get(i);
						index=i;
					}
				}
			 current.val = A.get(index);

			 if(left < index) {
				 current.left = new TreeNode(-1);
				 queue.add(current.left);
				 leftIndexes.add(left);
				 rightIndexes.add(index-1);

			 }

			 if(index < right) {
				 current.right = new TreeNode(-1);
				 queue.add(current.right);
				leftIndexes.add(index+1);
				rightIndexes.add(right);
			 }


		 }
		 
		 return root;
		 
	 }

	
	private TreeNode buildTreeRecu(ArrayList<Integer> A, int left, int right) {
		
		if(left> right) {
			return null;
		}
		int max = A.get(left);
		int index=left;
		for(int i = left+1; i <= right; i++) {
			if(A.get(i) > max) {
				max = A.get(i);
				index=i;
			}
		}
		
		TreeNode t = new TreeNode(A.get(index));
		
		if(left < index) {
			t.left = buildTreeRecu(A, left, index-1);
		}
		
		if(index < right) {
			t.right = buildTreeRecu(A, index+1, right);
		}
		
		return t;
	}
	
	
	
	
}
