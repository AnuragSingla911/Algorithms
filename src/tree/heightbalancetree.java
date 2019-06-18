package tree;

public class heightbalancetree {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.right = new TreeNode(3);
		
		System.out.println(new heightbalancetree().isBalanced(root));
	}

	 public int isBalanced(TreeNode A) {
		 
		height(A);
		return value;
	    }
	 
	 int value = 1;
	 
	 private int height(TreeNode A) {
		 int left = 0;
		 if(A.left != null) {
			 left = height(A.left);
		 }
		 
		 int right = 0;
		 
		 if(A.right !=  null) {
			 right = height(A.right);
		 }
		 
		 if(Math.abs(left-right) > 1) {
			 value = 0;
		 }
		 
		 System.out.println("height of "+ A.val + " is : "+ Math.max(left, right));
			
		 
		 return Math.max(left+1, right+1);
	 }
}
