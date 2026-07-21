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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> bfsq = new LinkedList<>();
        bfsq.offer(root);
        while(!bfsq.isEmpty()) {
            int levelSize = bfsq.size();
            for(int i=0; i<levelSize;i++) {
                TreeNode current = bfsq.poll();
                if(i == levelSize-1) {       
                    result.add(current.val);
                }
                if(current.left!=null) {
                    bfsq.offer(current.left);
                }
                if(current.right!=null) {
                    bfsq.offer(current.right);
                }
            }
        }
        return result;
    }
}
