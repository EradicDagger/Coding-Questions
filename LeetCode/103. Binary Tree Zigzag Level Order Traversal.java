// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) 
            return list;       
        
        if (root.left == null && root.right == null) {
            list.add(new ArrayList<Integer>(){
                {add(root.val);}
            }); 
            return list;
        }
        
     
        Deque<TreeNode> dq = new LinkedList<>();
        list.add(new ArrayList<Integer>(){
                {add(root.val);}
            }); 
        
        TreeNode temp;
        int level = 1;
        List<Integer> tList;
        
        //init
        dq.add(root);
        while(dq.size() > 0) {
            
            //popping
            int n = dq.size();
                        
            tList = new ArrayList<>();
            
            for(int i=0;i<n;i++) {
                if(level%2 == 0) {
                    temp =  dq.pollLast();
                } else {
                    temp = dq.pollFirst();
                }
                
                //push
                if (level%2 != 0) {
                    
                    if (temp.right != null) {
                        dq.add(temp.right);
                        tList.add(temp.right.val);
                    }
                    
                    if (temp.left != null) {
                        dq.add(temp.left);
                        tList.add(temp.left.val);
                    }
                } else if (level%2 == 0) {
                                        
                    if (temp.left != null) {
                        dq.offerFirst(temp.left);
                        tList.add(temp.left.val);
                    } 
                    
                    if (temp.right != null) {
                        dq.offerFirst(temp.right);
                        tList.add(temp.right.val);
                    }
                }          
            }
            if (tList.size() > 0 ) {
            	list.add(tList);
                
            }
            level++;
            
        } 
        return list;
    }
}
