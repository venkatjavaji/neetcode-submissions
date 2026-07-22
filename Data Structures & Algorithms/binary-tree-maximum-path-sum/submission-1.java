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
    int globalmax = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        calsum(root);
        return globalmax;

    }
    int calsum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        //discard -ve values that will reduce the total_sum
        int leftgain = Math.max(calsum(root.left),0);
        int rightgain = Math.max(calsum(root.right),0);

        // calculate total_path_sum at a node
        int pathsumgain = root.val + leftgain + rightgain;
        // update the global_max
        globalmax = Math.max(pathsumgain,globalmax);

        // key note :: what we can push upward is node + best one SIDE only**
        return root.val + Math.max(leftgain, rightgain);

    }
}
