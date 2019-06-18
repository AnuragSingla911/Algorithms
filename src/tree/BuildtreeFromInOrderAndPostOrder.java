package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import algo.Utilities;

public class BuildtreeFromInOrderAndPostOrder {
	
	public static void main(String[] args) {
		ArrayList<Integer> listA = Utilities.toList(new Integer[] {
				7, 5, 6, 2, 3, 1, 4
				});
		ArrayList<Integer> listB = Utilities.toList(new Integer[] {
				 5, 6, 3, 1, 4, 2, 7
		});		
		new BuildtreeFromInOrderAndPostOrder().buildTree(listA, listB);
	}

	
	 public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
		 
		 return buildTreeUsingIterative(A, B);//(A, B, B.size()-1, 0, A.size()-1);
	    }
	 
	 
	 public TreeNode buildTreeUsingRecu(ArrayList<Integer> A, ArrayList<Integer> B,int j, int left, int right) {
		 
		 if(left > right) {
			 return null;
		 }
		 int index = -1;
		
		 for(int i = left; i<= right; i++) {
			
			 if(A.get(i).intValue() == B.get(j).intValue()) {
				 index = i;
				 break;
			 }
		 }
		 
		 if(index < 0) {
			 return null;
		 }
		 
		 
		 TreeNode treeNode = new TreeNode(B.get(j));
		
		 
		 if(left < index) {
			 TreeNode t = null;
			 int m = j-1;
			 while(t == null && m >= 0) {
			  t = buildTreeUsingRecu(A,B,m,left,index-1);
			  m--;
			 }
			 treeNode.left = t;
		 }
		 
		 if(index < right) {
			 TreeNode t = null;
			 int m = j-1;
			 while(t == null && m >= 0) {
			 t = buildTreeUsingRecu(A, B, m,index+1, right);
			 m--;
			 }
			 treeNode.right = t;
		 }
		 
		 return treeNode;
		 
		 
	 }
	 
	 
 public TreeNode buildTreeUsingIterative(ArrayList<Integer> A, ArrayList<Integer> B) {
		 
	 		int left = 0;
	 		int right = A.size()-1;
	 		int j = B.size()-1;
		 
		 TreeNode treeNode = new TreeNode(-1);
		 TreeNode root = treeNode;
		 
		
		 Queue<TreeNode> queue = new LinkedList<TreeNode>();
		 Queue<Integer> lefts = new LinkedList<Integer>();
		 Queue<Integer> rights = new LinkedList<Integer>();
		 Queue<Integer> jValues = new LinkedList<Integer>();
		 Queue<Integer> indexes = new LinkedList<Integer>();
		 
		 HashMap<Integer,Integer> indexMap = new HashMap<>();
		 
		 for(int i =0; i < A.size() ; i++) {
			 indexMap.put(A.get(i), i);
		 }
		 
		 
		 
		 queue.add(treeNode);
		 lefts.add(left);
		 rights.add(right);
		 jValues.add(j);
		 
		 int index = -1;
		 
		 if(indexMap.containsKey(B.get(j))) {
			 index = indexMap.get(B.get(j));
		 }
		
		 
		 if(index < 0) {
			 return null;
		 }
		 
		 indexes.add(index);
		 
		 while(!queue.isEmpty()) {
			 
			 TreeNode treenode = queue.poll();
			 left = lefts.poll();
			 right = rights.poll();
			 j = jValues.poll();
			 index = indexes.poll();
			 if(left > right) {
				continue;
			 }
			
			 
			
			
			
			 
			 if(index < 0) {
				 continue;
			 }
			 
			 
			 
			 treenode.val = B.get(j).intValue();
			 
		 if(left < index) {
			 int m = j-1;
			 int indexLeft = -1;
			 while(indexLeft == -1 && m >= 0) {	 

				if(indexMap.containsKey(B.get(m))) {
					int indexLeftTemp = indexMap.get(B.get(m));
					if(indexLeftTemp < index) {
						indexLeft = indexLeftTemp;
					}
				}
				 
				 
			  m--;
			 }
			 
			 if(indexLeft >= 0) {
				 TreeNode t = new TreeNode(-1);
				 treenode.left = t;
				 queue.add(t);
				 lefts.add(left);
				 rights.add(index-1);
				 jValues.add(m+1);	 
				 indexes.add(indexLeft);
				 
			 }
			 
		 }
		 
		 if(index < right) {
			int indexright = -1;
			 int m = j-1;
			 while(indexright == -1 && m >= 0) {
				 if(indexMap.containsKey(B.get(m))) {
						int indexrighttemp = indexMap.get(B.get(m));
						if(indexrighttemp > index) {
							indexright = indexrighttemp;
						}
					}
			 m--;
			 }
			 if(indexright >= 0) {
				 TreeNode t = new TreeNode(-1);
				 treenode.right = t;
				 queue.add(t);
				 lefts.add(index+1);
				 rights.add(right);
				 jValues.add(m+1);
				 indexes.add(indexright);
			 }
		 }
		 
		 }
		 return root;
		 
		 
	 }
}
