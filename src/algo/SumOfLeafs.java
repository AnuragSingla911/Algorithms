package algo;

import java.util.ArrayList;
import java.util.LinkedList;

public class SumOfLeafs {
	
	
	public static void main(String[] args) {
		Node root = new Node(6);		
		root.left = new Node(3);		
		root.right = new Node(5);
		root.left.left = new Node(2);
		root.left.right = new Node(5);
		root.left.right.left = new Node(7);
		root.left.right.right = new Node(4);
		root.right.right = new Node(4);
		
		
		Tree t = new Tree(root);
		t.printSum();
		t.minDepth();
		
	  
		
		
		Node root1 = new Node(4);
		root1.left = new Node(5);
		root1.left.right = new Node(6);
		
	
		
		t.hasPathSum(root, 18);
	}
	

}



class Tree {
	
	Node root;
	
	private int sum = 0;
	private int minDepth = Integer.MAX_VALUE;
	private boolean isSumExist = false;
	private ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	
	Tree(Node root){
		this.root = root;
	}
	
	public void printSum() {
		sum = 0;
		printRecercive(root, "");
		System.out.println("sum.. "+ sum);
	}
	
	
	public void hasPathSum(Node root, int sum) {
		this.sum = 0;
		isSumExist = false;
		checkSumExist(root, 0, sum);
		System.out.println("is sum exsit : "+ isSumExist);
	}
	
	private void checkSumExist(Node node, int value, int sumToBeCheck) {
		value+= node.value;
		System.out.println(" sum become.. "+ value);
		if(node.left == null && node.right == null) {
			System.out.println(" sum for this leaf : "+ value);
			if(value == sumToBeCheck) {
				isSumExist = true;
			}
			return;
		}
		
		if(node.left != null && !isSumExist) {
			checkSumExist(node.left, value, sumToBeCheck);
		}
		
		if(node.right != null && !isSumExist) {
			checkSumExist(node.right, value , sumToBeCheck);
		}
	}
	
	
	public void minDepth() {
		minDepth = Integer.MAX_VALUE;
		minDepth(root, 0);
		System.out.println(" the depth : "+ minDepth);
	}
	
	public boolean isTreeSummertry() {
		
		LinkedList<Node> list = new LinkedList<>();
		
		toStringLeft(root, list);
		
		for(int i =0; i< list.size()/2 ; i++) {
			Node left = list.get(i);
			Node right = list.get(list.size()-1-i);
			if(left.value != right.value) {
				return false;
			}
		}
		return true;
		
		
	}
	
	private void toStringLeft(Node node, LinkedList<Node> value) {
		
		if(node.left != null) {
			toStringLeft(node.left, value);
		}
		
		
		value.add(node);
				
		
		if(node.right != null) {
			toStringLeft(node.right, value);
		}
	}
	
	private void toStringRight(Node node, StringBuilder value) {
		value = value.append(node.value);
		
		if(node.right != null) {
			toStringRight(node.right, value);
		}
		
		if(node.left != null) {
			toStringRight(node.left, value);
		}
		
		
	}
	
	private void minDepth(Node node, int value) {
		
		value++;
		
		if(node.left == null && node.right == null) {
			
			if(value < minDepth) {
				minDepth = value;
			}
		}
		
		if(node.left != null) {
			minDepth(node.left, value);
		}
		
		if(node.right != null) {
			minDepth(node.right, value);
		}
	}
	
	
	
	private void printRecercive(Node node, String value) {
		value+= node.value;
		
		if(node.left == null && node.right == null) {
			sum += Integer.parseInt(value);
		}
		
		if(node.left != null) {
			printRecercive(node.left, value);
		}
		
		if(node.right != null) {
			printRecercive(node.right, value);
		}
	}
	
}

class Node {
	
	int value;
	Node left;
	Node right;
	
	Node(int val){
		this.value = val;
	}
	
	public void addLeft(Node child) {
		left = child;
	}
	
	public void addRight(Node child) {
		right = child;
	}

}
