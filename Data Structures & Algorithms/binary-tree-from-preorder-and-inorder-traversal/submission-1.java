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
    int index= 0; //declaring as class variable to cache the increments
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer,Integer> inMap = new HashMap<>();
        for(int i=0; i< inorder.length; i++) {
            inMap.put(inorder[i],i);
        }
        return dfs(preorder, inMap, 0 ,inorder.length-1);
        
    }

    TreeNode dfs(int[] preorder, Map<Integer,Integer> inMap, int left, int right) {

            if(left>right) return null;
           
            int val = preorder[index];
            TreeNode root = new TreeNode(val);
             int mid = inMap.get(val);
             index++;

            root.left = dfs(preorder,inMap,left,mid-1);
            root.right = dfs(preorder,inMap,mid+1,right);
            return root;

    }
}
