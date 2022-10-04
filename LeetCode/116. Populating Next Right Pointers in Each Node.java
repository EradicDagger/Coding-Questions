// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        if (root == null ) {
            return root;
        }
        Deque<Node> dq = new LinkedList<>();
        
        root.next = null;
        Node temp;
        int level = 1;
        dq.add(root);
        
        while(dq.size() > 0) {
            
            //popping
            int n = dq.size();
                        
            for(int i=0;i<n;i++) {
                temp =  dq.pollFirst();
                
                temp.next = dq.peekFirst();
                
                if (i == n-1) 
                    temp.next = null;
                        
                if (temp.left != null) {
                    dq.add(temp.left);
                } 

                if (temp.right != null) {
                    dq.add(temp.right);
                }
            }          
        
            level++;
        }
        return root;
    }
}
