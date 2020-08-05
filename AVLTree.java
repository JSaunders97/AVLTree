class AVLTree {
  AVLTreeNode root;

  public AVLTree() {
    // AVL Tree class 
	  root = null;
  }

  public void createTestTree() {
    // Create a Test tree 
	  AVLTreeNode one = new AVLTreeNode("1");
	  AVLTreeNode two = new AVLTreeNode("2");
	  AVLTreeNode three = new AVLTreeNode("3");
	  AVLTreeNode four = new AVLTreeNode("4");
	  AVLTreeNode five = new AVLTreeNode("5");
	  AVLTreeNode six = new AVLTreeNode("6");
	  AVLTreeNode se7en = new AVLTreeNode("7"); 

	  root = four;
	  four.left = two;
	  four.right = six;
	  two.left = one;
	  two.right = three;
	  six.left = five;
	  six.right = se7en;
	  
	  four.parent = null;
	  two.parent = four;
	  six.parent = four;
	  one.parent = two;
	  three.parent = two;
	  five.parent = six;
	  se7en.parent = six;

  }

  public void print() {
    // Print out tree
	int i = 0;  
	printRec(root, i);
  }
  
  private void printRec(AVLTreeNode node, int i) {
	if(node == null) {
		return;
	}
	
	
	for (int j = 0; j<i; j++) {
	System.out.print("  ");
	}
	i++;
	
	System.out.println(node.val);
	
	printRec(node.left, i);	
	printRec(node.right, i);
  }

  public boolean inTree(String e) { 
    // Search for e in tree using binary search
    AVLTreeNode node = root;
	  
	  while(node != null) {
		  if (node.val.compareTo(e) == 0) {
			  return true;
		  }else if (node.val.compareTo(e) < 0) {
			  node = node.right;
		  }else {
			  node = node.left;
		  }
	  }
	  return false; 
  }
  

  public void insert(String e) { 
    // Insert e into tree then rebalance
	AVLTreeNode node = new AVLTreeNode(e);
	
	if(root == null) {
		root = node;
	}else {
		AVLTreeNode parent = root;
		AVLTreeNode searchNode = root;
		
		while(searchNode != null) {
			parent = searchNode;
			
			if(searchNode.val.compareTo(e) > 0) {
				searchNode = searchNode.left;
			}else {
				searchNode = searchNode.right;
			}
		}
		
		if(parent.val.compareTo(e) > 0) {
			parent.left = node;
			node.parent = parent;
		}else {
			parent.right = node;
			node.parent = parent;
		}
		
		balanceValues(root);
		
		makeBalanced(parent);
	}
				  
  }
  
  private void makeBalanced(AVLTreeNode node) {
	  // Rebalance tree according to the 4 possible cases
	  balanceNode(node);
	  	  
	  if(node.balance == -2) {
		  if (node.left.balance < 0) {
			  node = rotateRight(node);
		  }else {
			  node = rotateLeftRight(node);
		  }
	  }else if (node.balance == 2) {
		  if (node.right.balance > 0) {
			  node = rotateLeft(node);
		  }else {
			  node = rotateRightLeft(node);
		  }
	  }
		  
	  if(node.parent != null) {
		  makeBalanced(node.parent);
	  }else {
		  root = node;
	  }
  }
  
  private AVLTreeNode rotateRight(AVLTreeNode node) {
	  AVLTreeNode temp = node.left;
	  
	  temp.parent = node.parent;
	  
	  node.left = temp.right;
	  
	  if(node.left != null) {
		  node.left.parent = node;
	  }
	  
	  temp.right = node;
	  node.parent = temp;
	  
	  if(temp.parent != null) {
		  if(temp.parent.right == node) {
			  temp.parent.right = temp;
		  }else {
			  temp.parent.left = temp;
		  }
	  }
	  
	  balanceValues(root);
	  
	  return temp;
	  
  }
  
  private AVLTreeNode rotateLeft(AVLTreeNode node) {
	  AVLTreeNode temp = node.right;
	  
	  temp.parent = node.parent;
	  
	  node.right = temp.left;
	  
	  if(node.right != null) {
		  node.right.parent = node;  
	  }
	  
	  temp.left = node;
	  node.parent = temp;
	  
	  if(temp.parent != null) {
		  if(temp.parent.right == node) {
			  temp.parent.right = temp;
		  }else {
			  temp.parent.left = temp;
		  }
	  }
	  
	 balanceValues(root);
	  
	  return temp;
	  
  }
  
  private AVLTreeNode rotateLeftRight(AVLTreeNode node) {
	  node.left = rotateLeft(node.left);
	  return rotateRight(node);
  }
  
  private AVLTreeNode rotateRightLeft(AVLTreeNode node) {
	  node.right = rotateRight(node.right);
	  return rotateLeft(node);
  }
  
  private void balanceValues(AVLTreeNode node) {
	  // Recursively update balance values, starting from node
	  
	  if(node == null) {
		  return;
	  }

	    node.balance = balanceNode(node);
		
		balanceValues(node.left);	
		balanceValues(node.right);
	  
  }
  
  private int balanceNode(AVLTreeNode node) {
	  // Compute the balance value for a single node
	  if (node == null) {
		  return 0;
	  }else {
		  return (height(node.right) - height (node.left));
	  }
		  
	  
	  
  }
  
  private int height(AVLTreeNode node) {
	  // Return greatest depth of tree starting from node
	  
	  if (node == null) {
		  return 0;
	  }else {
		  int heightL = height(node.left);
		  int heightR = height(node.right);
		  
		  if (heightL > heightR) {
			  return (1 + heightL); 
		  }else {
			  return (1 + heightR); 
		  }
			  
	  }
	  
	  
  }
  
}
