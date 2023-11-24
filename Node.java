public class Node implements Node_I

{
    private final int key;
    private Node parent;
    private Node left;
    private Node right;
    private int count;

    public Node(int key)
    {
        this.key = key;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.count = 1;
    }

    public int getKey() { return key; }
    public Node getParent() { return parent; }
    public Node getLeft() { return left; }
    public Node getRight() { return right; }
    public int getCount() { return count; }


    public void setLeft(Node n) { left = n; }
    public void setRight(Node n) { right = n; }
    public void setParent(Node n) { parent = n; }
    public void setCount() { count++ ; }
    public void decCount() { count-- ;}

    public boolean equals(Node n) 
    {
        if (this.key == n.getKey()) { return true; }
        else { return false; }
    }

    public String toString()
    {
        String str = "(" + key + ",";
        
        if (parent != null) 
        { 
            str = str + parent.getKey() + ","; 
        }
        else 
        { 
            str = str + ","; 
        }
        if (left != null) 
        { 
            str = str + left.getKey() + ","; 
        }
        else 
        { 
            str = str + ","; 
        }
        if (right != null) 
        { 
            str = str + right.getKey() + ","; 
        }
        else 
        { 
            str = str + ","; 
        }
        str = str + count + ")";
        return str;
    }


}
