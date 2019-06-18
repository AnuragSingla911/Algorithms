package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class pathsum {

	 public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
		 
		 find(new ArrayList<Integer>(), 0, B, A);
		 
		 return result;
	    }
	 
	 
	 ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	 
	 private ArrayList<ArrayList<Integer>> findIter(TreeNode A, int B) {
		 
		 if(A == null) {
			 return new ArrayList<>();
		 }
		 
		
		 Queue<TreeNode> queue = new LinkedList<TreeNode>();
		 Queue<Integer> sumQueue = new LinkedList<Integer>();
		 Queue<ArrayList<Integer>> valuesQueue = new LinkedList<ArrayList<Integer>>();
		 
		 queue.offer(A);
		 sumQueue.offer(A.val);
		 ArrayList<Integer> list = new ArrayList<>();
		 list.add(A.val);
		 valuesQueue.offer(list);
		 
		 ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		 
		 while(!queue.isEmpty()) {
			 
			 TreeNode node = queue.poll();
			 int sum = sumQueue.poll();
			 ArrayList<Integer> values = (ArrayList<Integer>) valuesQueue.poll();
			 
			 if(node.left == null && node.right == null && sum == B) {
				 result.add(values);
			 }
			 
			 if(node.left != null) {
				 queue.add(node.left);
				 sumQueue.add(sum+ node.left.val);
				 ArrayList<Integer> valuesLeft = (ArrayList<Integer>) values.clone();
				 valuesLeft.add(node.left.val);
				 valuesQueue.add(valuesLeft);
			 }
			 
			 if(node.right != null) {
				 queue.add(node.right);
				 sumQueue.add(sum+ node.right.val);
				 ArrayList<Integer> valuesRight = (ArrayList<Integer>) values.clone();
				 valuesRight.add(node.right.val);
				 valuesQueue.add(valuesRight);
			 }
			
		 }
		 
		 return result;
	 }
	 
	 private void find(ArrayList<Integer> cur, int sum, int targetSum, TreeNode node) {
		 
		 if(node == null) {
			 return;
		 }
		 
		 cur.add(node.val);
		 sum+= node.val;
		 
		 if(node.left == null && node.right == null) {
			 if(sum == targetSum) {
				 result.add(cur);
			 }
		 }
		 
		 if(node.left != null) {
			find((ArrayList<Integer>) cur.clone(), sum, targetSum, node.left);
		 }
		 
		 if(node.right != null) {
			 find((ArrayList<Integer>) cur.clone(), sum, targetSum, node.right);
		 }
	 }
}
