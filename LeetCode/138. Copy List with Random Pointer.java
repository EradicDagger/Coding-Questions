// https://leetcode.com/problems/copy-list-with-random-pointer/
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        //Runtime complexity: O(N)
        //Space complexity: O(N)

        
        Map<Node, Node> originalToNewMap = new HashMap<>();
        
        Node curr = head;
        
        while (curr!=null) {
            Node copy = new Node(curr.val);
            originalToNewMap.put(curr, copy);
            curr = curr.next;
        }
        
        curr = head;
        while (curr!=null) {
            Node copy = originalToNewMap.get(curr);
            copy.next = originalToNewMap.get(curr.next);
            copy.random = originalToNewMap.get(curr.random);
            curr = curr.next;
        }
        
        return originalToNewMap.get(head);
    }
}
