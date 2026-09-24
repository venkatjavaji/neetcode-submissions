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
    public int goodNodes(TreeNode root) {

        return dfs(root, Integer.MIN_VALUE);
        
    }

    int dfs(TreeNode node, int max_seen) {
        if(node == null) return 0;

        int count = 0;
        if(node.val >= max_seen) {
            //consider this node as good node.
            count = 1;
            max_seen = node.val;
        }

        count += dfs(node.left, max_seen);
        count += dfs(node.right, max_seen);

        return count;
    }
}
