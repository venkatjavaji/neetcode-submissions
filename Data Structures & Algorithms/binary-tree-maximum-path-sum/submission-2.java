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

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    int dfs(TreeNode node) {
        if(node == null) return 0;

        int left = Math.max(0, dfs( node.left)); // drop negative branches
        int right = Math.max(0,dfs(node.right)); // drop negative branches

        max = Math.max(max, left+right+node.val); // path bending at this node
        return node.val + Math.max(left,right); // only one branch can extend upward
    }


}


/*

    -15
    /   \
    10    -20
        /   \
        15     5
        /
    -5
    while doing this... 15 -> -5 (it will discard left -5)
            
Dry run (post-order, children before parent):

Node	raw left	left (clamped)	raw right	right (clamped)	path through node	max	returns
10	    0	0	0	0	10	10	10
-5	    0	0	0	0	-5	10	-5
15	    -5	0	0	0	15	15	15
5	    0	0	0	0	5	15	5
-20	    15	15	5	5	-20 + 15 + 5 = 0	15	-20 + 15 = -5
-15	10	10	-5	0	-15 + 10 + 0 = -5	15	-5

Result: 15, the single node 15.
*/
