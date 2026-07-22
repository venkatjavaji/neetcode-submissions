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
    public int kthSmallest(TreeNode root, int k) {
        

        //intution is to traverse the tree in inOrder - right.root.left (naturally gives in ascending order)
         List<Integer> result = new ArrayList<>();
         preOrder(root,result);
         return result.get(k-1);
    }

    public void preOrder(TreeNode root,List<Integer> result ) {
       
        if(root == null) return;
        preOrder(root.left,result);
        result.add(root.val);
        preOrder(root.right,result);

    }
}
