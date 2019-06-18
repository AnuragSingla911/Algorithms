package tree;

import java.util.ArrayList;

public class recoverbst {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(4);
		node.left = new TreeNode(3);
		node.left.left = new TreeNode(1);
		node.left.left.right = new TreeNode(2);

		node.right = new TreeNode(7);
		node.right.left = new TreeNode(6);
		node.right.left.left = new TreeNode(15);
		node.right.right = new TreeNode(8);

		new recoverbst().recoverTree(node);
	}

	ArrayList<Integer> recoverTree(TreeNode root) 
	{ 
		TreeNode current, pre; 


		ArrayList<Integer> values = new ArrayList<Integer>();

		if (root == null) 
			return new ArrayList<>(); 

		current = root; 
		TreeNode previous = null;

		while (current != null) { 

			if(current.left != null) {
				pre = current.left;
				TreeNode temp = pre;
				while(pre.right != null) {
					pre = pre.right;
				}
				current.left = null;
				pre.right = current;
				current = temp;
			}else {
				System.out.println(current.val);
				if(previous != null && previous.val > current.val) {
					TreeNode temp = current;
					while(temp.right != null && temp.right.val < previous.val) {
						temp = temp.right;
						if(temp.right != null && temp.right.val > previous.val){
							TreeNode temp2 = temp.right;
							while(temp2.left != null && temp2.left.val > previous.val) {
								temp2 = temp2.left;

							}
							if(temp2.left != null && temp2.left.val < previous.val)
								temp = temp2.left;


						}
					}

					values.add(temp.val);
					values.add(previous.val);

					return values;
				}
				previous = current;
				current = current.right;
			}

		} 

		return new ArrayList<>();
	} 



}
