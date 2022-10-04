//https://leetcode.com/problems/check-completeness-of-a-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        
        Queue<TreeNode> bfsQueue = new LinkedList<>();        
        bfsQueue.offer(root);

        boolean isIncompleteTree = false;
        
        while(!bfsQueue.isEmpty()) {
            TreeNode curr = bfsQueue.poll();
            
            if (curr == null)
                isIncompleteTree = true;
            else {
                if (isIncompleteTree)
                    return false;
                bfsQueue.offer(curr.left);
                bfsQueue.offer(curr.right);
            }       
        }
        return true;
    }
}
