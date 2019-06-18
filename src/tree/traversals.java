package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import algo.Utilities;

public class traversals {
	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		//Utilities.printArrayList(new traversals().preorderTraversal(root));
		//Utilities.printArrayList(new traversals().inorderTraversal(root));
		Utilities.printArrayList(new traversals().postorderTraversal(root));

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
	
	public ArrayList<Integer> postorderTraversal(TreeNode A) {
		ArrayList<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		TreeNode item1 = A;
		TreeNode lastNode = null;
		while(item1!= null || !stack.isEmpty()) {
			if(item1 != null) {
				stack.push(item1);
				item1 = item1.left;
			}else {
				TreeNode temp = stack.peek();
				
				if(temp.right == null || temp.right == lastNode) {
					list.add(temp.val);
					lastNode = stack.pop();
				}else {
					item1 = temp.right;
				}
				
			}
		}	
		return list;
	}

	public ArrayList<Integer> inorderTraversal(TreeNode A) {
		ArrayList<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		TreeNode item1 = A;//stack.peek();
		while(item1!= null || !stack.isEmpty()) {
			while(item1 != null) {
				stack.push(item1);
				item1 = item1.left;
			}


			item1 = stack.pop();
			list.add(item1.val);
			
			item1= item1.right;

		}	
		return list;
	}





}
