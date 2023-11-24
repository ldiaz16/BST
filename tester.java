public class tester 
{
	public static void main(String[] args) 
    {

		BinarySearchTree bst = new BinarySearchTree();
        
        Node root = new Node(5);
		bst.setRoot(root);

        Node one = new Node(1);
        Node three = new Node(3);
        Node eight = new Node(8);
        Node seven = new Node (7);
        Node nine = new Node(9);
        Node ten = new Node(10);
        Node eleven = new Node(11);
        
		bst.insertNode(one);
		bst.insertNode(three);
        bst.insertNode(eight);
        bst.insertNode(nine);
        bst.insertNode(ten);
        bst.insertNode(seven);
        bst.insertNode(nine);
        bst.insertNode(nine);

        Node max = bst.getMax(root);
        Node min = bst.getMin(root);

        bst.print();
        /* 
        System.out.println(" \nThe max is " + max.getKey()); //works
        System.out.println("The min is " + min.getKey()); //works
        System.out.println(bst.getNode(root, 9)); //works kind of... why 0
        System.out.println("The height is " + bst.getHeight(root)); // works
        System.out.println("Count of [9] is: " + nine.getCount());//works
        bst.shiftNode(ten, eleven); //works
        bst.preOrderWalk(root);
        System.out.println("\nSuccessor of root is: " + bst.getSuccessor(root)); //works
        bst.deleteNode(root);
        bst.preOrderWalk(root);
        System.out.println("\n" + seven.getRight());
        System.out.println("\n" + seven.getParent());
        */
        bst.print();
        
		//search(5, bst);
		//search(0, bst);

	}

	 /*  public static void search(int data, BinarySearchTree bst) {

		if (bst.getNode(data) == null) {
			System.out.println("Node " + data + " not found in tree");
		} else {
			System.out.println("Node " + data + " found");
		}
	} */
}