package tree;

import java.util.ArrayList;
import java.util.HashMap;

import algo.Utilities;

public class BuildTreeFromInOrderAndPreOrder {
	
	public static void main(String[] args) {
		ArrayList<Integer> listA = Utilities.toList(new Integer[] {
				1,2,3
				});
		ArrayList<Integer> listB = Utilities.toList(new Integer[] {
				2,1,3
		});	
		new BuildTreeFromInOrderAndPreOrder().buildTree(listA, listB);
	}
	
 public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
	 
	 
	 HashMap<Integer,Integer> indexMap = new HashMap<>();
	 
	 for(int i =0; i < B.size() ; i++) {
		 indexMap.put(B.get(i), i);
	 }
		 
		 return buildTreeUsingRecu(B, A, 0, 0, A.size()-1, indexMap);
	    }

 public TreeNode buildTreeUsingRecu(ArrayList<Integer> A, ArrayList<Integer> B,int j, int left, int right, HashMap<Integer,Integer> map) {
		 
		 if(left > right) {
			 return null;
		 }
		 int index = -1;
		
		 int indexTemp = map.get(B.get(j));
		 
		 if(indexTemp >= left && indexTemp <= right) {
			 index = indexTemp;
		 }
		 
		 if(index < 0) {
			 return null;
		 }
		 
		 
		 TreeNode treeNode = new TreeNode(B.get(j));
		
		 
		 if(left < index) {
			 TreeNode t = null;
			 int m = j+1;
			 while(t == null && m < B.size()) {
			  t = buildTreeUsingRecu(A,B,m,left,index-1,map);
			  m++;
			 }
			 treeNode.left = t;
		 }
		 
		 if(index < right) {
			 TreeNode t = null;
			 int m = j+1;
			 while(t == null && m < B.size()) {
			 t = buildTreeUsingRecu(A, B, m,index+1, right,map);
			 m++;
			 }
			 treeNode.right = t;
		 }
		 
		 return treeNode;
		 
		 
	 }
}
