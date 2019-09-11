package dp;

import java.util.ArrayList;

public class creatingbsts {

	public static void main(String[] args) {
		creatingbsts bsts = new creatingbsts();
		bsts.generateTrees(3);
	}
	
	
//Definition for binary tree
	  class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 
	    public ArrayList<TreeNode> generateTrees(int a) {
	        
	        ArrayList<TreeNode> result = construct(1,a);
	       
	        return result;
	    }
	    
	    private ArrayList<TreeNode> construct(int start, int end){
	        
	        if(start > end){
	        	ArrayList<TreeNode> t = new ArrayList<TreeNode>();
	        	t.add(null);
	            return t;
	        }
	  
	    ArrayList<TreeNode> returnValues = new ArrayList<>();
	    
	    for(int i = start; i<= end; i++){
	    ArrayList<TreeNode> leftTree = construct(start, i-1);
		   System.out.println(" left tree size : "+ leftTree.size() + " "+ " start :"+ start + " i "+ (i-1));

	   ArrayList<TreeNode> rightTree = construct(i+1, end);
	   
	   System.out.println(" right tree size : "+ rightTree.size() + " "+ " i :"+ (i+1) + " end "+ (end));
	    
	    
	       for(TreeNode leftItem : leftTree){
	           for(TreeNode rightItem : rightTree){
	               TreeNode result = new TreeNode(i);
	               result.left = leftItem;
	               result.right = rightItem;
	               returnValues.add(result);
	           }
	       }
	    
	       
	    }
	        
	        return returnValues;
	        
	    }
	

}
