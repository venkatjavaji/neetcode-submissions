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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // traverse until you find the subRoot.val matches any of the root[node].val.. then apply same tree...
        // or just do inOrder traversal on both trees and use contains.. with string..

        return dfs(root,subRoot);


    }

    boolean dfs(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) return true; //if subroot is null, its subtree of any tree

        if(root == null) return false;

        // Check if current root matches subRoot
        if(isSameTree(root, subRoot)) return true;

        // If not, check left and right subtrees
        return dfs(root.left,subRoot) || dfs(root.right, subRoot);

    }

    boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return p.val == q.val
                && isSameTree(p.left, q.left) 
                && isSameTree(p.right, q.right);

    }
}
