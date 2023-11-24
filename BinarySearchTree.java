import java.util.ArrayList;

public class BinarySearchTree implements BinarySearchTree_I
{
    private Node root;

    public BinarySearchTree()
    {
        root = null;
    }
    public Node getRoot() { return root; }
    public void setRoot(Node root) { this.root = root; }


    public void insertNode(Node z) 
    {
        if (root == null) {
			root = z;
			return;
		}
		
		Node current = root;
		Node parent = null;
		while (current != null) 
        {
			if (z.getKey() < current.getKey()) 
            {
				parent = current;
				current = current.getLeft();
			} 
            else if (z.getKey() > current.getKey())
            {
				parent = current;
				current = current.getRight();
			} 
            else 
            {
				System.out.println("Our tree does not support duplicates");
                z.setCount();
				return;
			}
		}
		if (z.getKey() < parent.getKey()) 
        {
			parent.setLeft(z);
            z.setParent(parent);
		} 
        else if (z.getKey() > parent.getKey())
        {
			parent.setRight(z);
            z.setParent(parent);
		} 
        else 
        { 
			//System.out.println("Can't have duplicates");
            z.setCount();
		}

    }

    public void preOrderWalk(Node x) 
    {
            if (x == null)  { return; }
            System.out.print(x.getKey() + " ");
            preOrderWalk(x.getLeft());
            preOrderWalk(x.getRight());
    }


    public void inOrderWalk(Node x)
    {
        if (x == null) { return; }
        inOrderWalk(x.getLeft());
        System.out.print(x.getKey() + " ");
        inOrderWalk(x.getRight());

    }

    public void postOrderWalk(Node x) 
    {
        if (x == null) { return; }
        postOrderWalk(x.getLeft());
        postOrderWalk(x.getRight());
        System.out.print(x.getKey() + " ");
    }

    public Node getMax(Node x) 
    {
        while (x.getRight() != null)
        {
            x = x.getRight();
        }
        
        return x;
    }

    public Node getMin(Node x) 
    {
        while (x.getLeft() != null)
        {
            x = x.getLeft();
        }
        return x;
    }

    public Node getSuccessor(Node x)
    {
        if (x.getRight() != null) 
        {
            return getMin(x.getRight());
        }
    
        Node successor = null;
    
        Node current = root;
    
        while (current != null) 
        {
            if (x.getKey() < current.getKey()) 
            {
                successor = current;
                current = current.getLeft();
            } 
            else if (x.getKey() > current.getKey())
            {
                current = current.getRight();
            } 
            else 
            {
                break;
            }
        }
        return successor;
    }

    public Node getPredecessor(Node x) 
    {
        if (x.getLeft() != null) 
        {
            return getMax(x.getLeft());
        }
    
        Node predecessor = null;
    
        Node current = root;
    
        while (current != null) 
        {
            if (x.getKey() < current.getKey()) 
            {
                predecessor = current;
                current = current.getRight();
            } 
            else if (x.getKey() > current.getKey())
            {
                current = current.getLeft();
            } 
            else 
            {
                break;
            }
        }
        return predecessor;
    }

    public Node getNode(Node x, int key) 
    {
        if (x == null || key == x.getKey()) { return x; }

        if (key < x.getKey()) 
        {
            return getNode(x.getLeft(), key);
        }
        else
        {
             return getNode(x.getRight(), key);
        }
        
    }

    public int getHeight(Node x) 
    {
        if (x == null)
        {
            return -1;
        }
        int leftHeight = getHeight(x.getLeft());
        int rightHeight = getHeight(x.getRight());

        if (leftHeight > rightHeight)
        {
            return leftHeight + 1;
        }
        return rightHeight + 1;
    }

    public void shiftNode(Node u, Node v)
    {
        if (u.getKey() == root.getKey())
        {
            setRoot(v);
        }
        else
        {
            if (u == u.getParent().getLeft())
            {
                u.getParent().setLeft(v);
            }
            else 
            {
                u.getParent().setRight(v);
            }
        }
        if (v != null)
        {
            v.setParent(u.getParent());
        }
        
    }

    public Node deleteNode(Node n) 
    {
        if (n.getLeft() == null)
        {
            shiftNode(n, n.getRight());
        }
        else 
        {
            if (n.getRight() == null)
            {
                shiftNode(n, n.getLeft());
            }
            else
            {
                Node y = getSuccessor(n);
                Node yParent = y.getParent();

                if (yParent != n)
                {
                    shiftNode(y, y.getRight());
                    y.setRight(n.getRight());
                    y.getRight().setParent(y);
                }
                shiftNode(n, y);
                y.setLeft(n.getLeft());
                y.getLeft().setParent(y);
            }
        }
        n.setLeft(null);
        n.setRight(null);
        n.decCount();
        return n;
    }

    public void preOrderWalk(Node x, ArrayList<String> list) 
    {
        if (x == null) { return; }
        list.add(x.toString());
        preOrderWalk(x.getLeft(), list);
        preOrderWalk(x.getRight(), list);
    }
    public void inOrderWalk(Node x, ArrayList<String> list) 
    {
        if (x == null) { return; }    
        inOrderWalk(x.getLeft(), list);
        list.add(x.toString());
        inOrderWalk(x.getRight(), list);
        
    }
    public void postOrderWalk(Node x, ArrayList<String> list) 
    {
        if (x == null) { return; }
        postOrderWalk(x.getLeft(), list);
        postOrderWalk(x.getRight(), list);
        list.add(x.toString());
        
    }

    public void print() 
    {
        System.out.println("Printing Tree");
        printHelper(root, 0);
    }
       
    private void printHelper(Node current, int spaces) 
    {
        //base case - we've reached beyond a leaf node
        if (current == null) { return; }
        //this explicitly makes each depth of the tree 8 spaces away from its parent
        //changing this value changes the width of the printed tree
        final int COUNT = 8;
        spaces += COUNT;
        //we are doing a right-to-left inOrder traversal for better readability
        printHelper(current.getRight(), spaces);
        //print current Node
        System.out.println(); //puts Node on a new line
        String whitespace = ""; //will build up the depth of whitespace for each node
        for (int i = COUNT; i < spaces; i++) {
        whitespace += " ";
        }
        System.out.println(whitespace + current.getKey()); //prints data for current Node
        //Now go to the left child
        printHelper(current.getLeft(), spaces);
        }
    
}
