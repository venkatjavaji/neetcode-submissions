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
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    int dfs(TreeNode node) {
        if(node == null) return 0;

        int leftHeight = dfs(node.left);
        if(leftHeight == -1) return -1; //left is unbalanced, stop

        int rightHeight = dfs(node.right);
        if(rightHeight == -1) return -1; //right is unbalanced, stop

        // Check if THIS node is balanced
        // For balanced tree: |leftHeight - rightHeight| <= 1
        if(Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
         // This node is balanced, return its height
        return 1 + Math.max(leftHeight,rightHeight);
    }
}
