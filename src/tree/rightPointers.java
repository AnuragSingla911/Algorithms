package tree;
class TreeLinkNode {
    int val;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;
     TreeLinkNode(int x) {
      val = x;
      left=null;
      right=null;
     }
 }
public class rightPointers {
	
	public static void main(String[] args) {
		TreeLinkNode node = new TreeLinkNode(4);
		node.left = new TreeLinkNode(3);
		node.left.left = new TreeLinkNode(1);
		node.left.right = new TreeLinkNode(2);
		
		node.right = new TreeLinkNode(7);
		node.right.left = new TreeLinkNode(6);
		node.right.right = new TreeLinkNode(8);
		
		new rightPointers().connect(node);
	}

	void connect(TreeLinkNode root) 
	{ 
		
		TreeLinkNode current = root;
		
		TreeLinkNode first = current;
		
		while(current != null) {
			
			first = current;
			
			
			TreeLinkNode firstTemp = first;
			TreeLinkNode currentPrev = null;
			TreeLinkNode currentPrevTwo = null;
			while(firstTemp != null) {
				

				if(firstTemp.left != null) {
					currentPrevTwo = currentPrev;
					currentPrev = firstTemp.left;
					if(currentPrevTwo != null)
					currentPrevTwo.next = currentPrev;
					
				}
				
				if(firstTemp.right != null) {
					currentPrevTwo = currentPrev;
					currentPrev = firstTemp.right;
					if(currentPrevTwo != null)
					currentPrevTwo.next = currentPrev;
				}
				
				firstTemp = firstTemp.next;
			}
			
		
			current = null;
			
			while(first != null) {
				

				if(first.left != null) {
					current = first.left;
					break;
				}
				
				if(first.right != null) {
					current = first.right;
					break;
				}
				
				first = first.next;
			}
		}


	} 

	
}



