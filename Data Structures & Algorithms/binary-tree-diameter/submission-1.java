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
    int max_diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max_diameter;
    }

    int dfs(TreeNode node) {
        if(node == null) return 0;
        
        int left_height = dfs(node.left);
        int right_height = dfs(node.right);

        //diameter calculation - start
        int diameter_at_node = left_height+right_height;
        max_diameter = Math.max(diameter_at_node, max_diameter);
        //diameter calculation - end

        // this is height of the tree at a given node...
        return 1+Math.max(left_height,right_height);
    }
}
