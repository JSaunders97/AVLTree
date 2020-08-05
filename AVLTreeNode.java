
public class AVLTreeNode {
	public String val; // Value of node
	public int balance; // Balance = height(node.right) - height(node.left)
	public AVLTreeNode parent; // Parent of node, null if root
	public AVLTreeNode left; // Left branch of tree
	public AVLTreeNode right; // Right branch of tree
	
	public AVLTreeNode (String s) {
		val = s;
	}
	
}
