// https://leetcode.com/problems/find-duplicate-subtrees/

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
    Map<String, Integer> dupMap = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            List<TreeNode> resultList = new ArrayList<>();
        findDup(root, resultList);
        return resultList;
    }

    public String findDup(TreeNode root, List<TreeNode> resultList) {
        if(root == null) {
            return "null";
        }
        String left = findDup(root.left, resultList);
        String right = findDup(root.right, resultList);
        String str = root.val + ":" + left + ":" + right;
        dupMap.merge(str, 1, Integer::sum);
        if(dupMap.get(str) == 2) {
            System.out.println("Int :: "+ str);
            resultList.add(root);
        }
        System.out.println("Str :: "+ str);
        System.out.println("Map :: " + dupMap.toString());
        
        return str;
    }
}
