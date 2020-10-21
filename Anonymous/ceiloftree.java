class Node { 
    int data; 
    Node left, right; 
    Node(int info) 
    { 
        data = info; 
        left = right = null; 
    } 
} 

class BinaryTreeProb { 
    Node root; 
    int CeilOfTree(Node node, int val) 
    { 
        if (node == null) { 
            return -1; 
        } 
        if (node.data == val) { 
            return node.data; 
        } 
        if (node.data < val) { 
            return Ceil(node.right, val); 
        } 
        int ceil = Ceil(node.left, val); 
  
        return (ceil >= val) ? ceil : node.data; 
    } 
    public static void main(String[] args) 
    { 
        BinaryTreeProb tree = new BinaryTreeProb(); 
        tree.root = new Node(5); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(19); 
        tree.root.left.left = new Node(1); 
        tree.root.left.right = new Node(3); 
        tree.root.right.left = new Node(16); 
        tree.root.right.right = new Node(12); 
        for (int i = 0; i < 16; i++) { 
  
            System.out.println(i + " " + tree.CeilOfTree(tree.root, i)); 
        } 
    } 
} 
  
