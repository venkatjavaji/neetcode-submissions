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
    int goodNodes = 0;
    public int goodNodes(TreeNode root) {

        //intution is PreOrder traversal - root.Left.Right

        return countNodes(root,Integer.MIN_VALUE);
        
    }

    public int countNodes(TreeNode root, int maxseen) {
        if(root == null ) return 0;

        int count = root.val >= maxseen ? 1 : 0; //count this node as a good node.. it will get sumup in recursive calls

        maxseen = Math.max(maxseen,root.val);

        count += countNodes(root.left, maxseen);
        count += countNodes(root.right,maxseen);
        
        return count;
    }
}
