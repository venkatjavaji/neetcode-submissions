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
    public boolean isValidBST(TreeNode root) {
        //build the list in in-order traversal and see if it is in increasing order...
        //or compare the min and max at every height
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean dfs(TreeNode node, int min, int max) {

        if(node == null) return true;

        if(node.val <= min || node.val >= max) return false;

        return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
    }
}
