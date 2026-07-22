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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //identify the initial root from the preOder start index
        //build the hashmap to store the indexes of inorder nodes
        Map<Integer,Integer> inOrderMap = new HashMap<>();
        for(int i = 0 ;i<inorder.length;i++) {
            inOrderMap.put(inorder[i],i);
        }
        return buildBTree(preorder,inOrderMap, 0,0,inorder.length-1);

    }

    public TreeNode buildBTree(int[] preorder, Map<Integer,Integer> inordermap, int rindex, int left, int right) {

        int rootval = preorder[rindex];
        TreeNode root = new TreeNode(rootval);
        //next build left and right nodes
        int mid = inordermap.get(preorder[rindex]);
        if(mid>left) {
            root.left = buildBTree(preorder,inordermap,rindex+1, left,mid-1);
        }
        if(mid<right) {
            root.right = buildBTree(preorder,inordermap,rindex+mid-left+1,mid+1,right);
        }
        return root;
    }
}
