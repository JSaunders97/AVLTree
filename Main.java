class Main {
  public static void main(String[] args) {


    // Initialise new AVL Tree  
    AVLTree test_tree = new AVLTree();
    // Fill tree with example tree
    test_tree.createTestTree();
    // Print out the tree
    System.out.print("Example tree.\n");
    test_tree.print();
    // Insert new value
    test_tree.insert("8");
    System.out.print("Tree after inserting 8!\n");
    test_tree.print();
    System.out.print("Tree after inserting 9!\n");
    test_tree.insert("9");
    test_tree.print();
    
    // Test usage of inTree 
    boolean answer = test_tree.inTree("7");
    System.out.print("Is 7 in the tree? ");
    System.out.print(answer);

    System.out.print("\n");
    answer = test_tree.inTree("10");
    System.out.print("Is 10 in the tree? ");
    System.out.print(answer);
  }
}
