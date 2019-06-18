package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class issymmetric {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		
		System.out.println(new issymmetric().isSymmetric(root));
	}
	
	  public int isSameTree(TreeNode A, TreeNode B) {
		  List<TreeNode> left = new LinkedList<TreeNode>();
		  List<TreeNode> right = new LinkedList<TreeNode>();
		  if(A != null)
		  left.add(A);
		  if(B != null)
		  right.add(B);
		  
		  while(!left.isEmpty() || !right.isEmpty()) {
			  	if(left.size() != right.size()) {
			  		return 0;
			  	}
				for(int i =0; i< left.size() ; i++) {
					TreeNode leftNode = left.get(i);
					TreeNode rightNode = right.get(i);
					if(leftNode == null && rightNode == null) {
						continue;
					}else if(leftNode == null && rightNode != null) {
						return 0;
					}else if(leftNode != null && rightNode == null) {
						return 0;
					}else
						if(leftNode.val != rightNode.val) {
							return 0;
						}
				}
				int size = left.size();
				for(int i =0; i< size ; i++) {
					TreeNode first = left.remove(0);
					TreeNode second = right.remove(0);
					if(first.left != null) {
						left.add(first.left);
					}
					if(first.right != null) {
						left.add(first.right);
					}
					
					if(second.left != null) {
						right.add(second.left);
					}
					
					if(second.right != null) {
						right.add(second.right);
					}
				}
			}
		  return 1;
		  
	    }
	
	public int isSymmetric(TreeNode A) {

		if(A == null) {
			return 1;
		}


		List<TreeNode> left = new LinkedList<TreeNode>();
		left.add(A);


		while(!left.isEmpty()) {
			for(int i =0; i< left.size()/2 ; i++) {
				TreeNode leftNode = left.get(i);
				TreeNode rightNode = left.get(left.size()-i-1);
				if(leftNode == null && rightNode == null) {
					continue;
				}else if(leftNode == null && rightNode != null) {
					return 0;
				}else if(leftNode != null && rightNode == null) {
					return 0;
				}else
					if(leftNode.val != rightNode.val) {
						return 0;
					}
			}
			int size = left.size();
			for(int i =0; i< size ; i++) {
				TreeNode first = left.remove(0);
				if(first.left != null) {
					left.add(first.left);
				}
				if(first.right != null) {
					left.add(first.right);
				}
			}
		}

		return 1;

	}

	    public ArrayList<Integer> preorderTraversal(TreeNode A) {
	        ArrayList<Integer> list = new ArrayList<>();
	        Stack<TreeNode> stack = new Stack<>();
	        stack.push(A);
	        while(!stack.isEmpty()) {
	            TreeNode item = stack.pop();
	            list.add(item.val);
	            if(item.right != null) {
	                stack.push(item.right);
	            }
	            if(item.left != null) {
	                stack.push(item.left);
	            }
	        }
	        return list;
	    }
	    
	    public ArrayList<Integer> preorderTraversalUpdated(TreeNode A) {
	        ArrayList<Integer> list = new ArrayList<>();
	        Stack<TreeNode> stack = new Stack<>();
	        stack.push(A);
	        while(!stack.isEmpty()) {
	            TreeNode item = stack.pop();
	            list.add(item.val);
	            if(item.left != null) {
	                stack.push(item.left);
	            }
	            if(item.right != null) {
	                stack.push(item.right);
	            }
	            
	        }
	        return list;
	    }
}
