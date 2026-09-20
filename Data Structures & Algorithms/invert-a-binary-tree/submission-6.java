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
    public TreeNode invertTree(TreeNode root) {

        //revision-mode :)
        // return dfs(root);
        return bfs(root);
    }

    TreeNode bfs(TreeNode root) {
        if(root == null) return root;
        //bfs need a Queue
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            if(cur.left!=null) queue.offer(cur.left);
            if(cur.right!=null) queue.offer(cur.right);
        }
        return root;
    }

    /*
            Original Tree:
            1
            / \
            2   3
            / \
            4   5

            Goal: Invert to:
            1
            / \
            3   2
                / \
                5   4
    DFS Call Stack Visualization:
═════════════════════════════

dfs(1)
│
├─ temp = 1.left = node(2)
├─ node(1).left = dfs(1.right) = dfs(3)
│  │
│  └─ dfs(3)
│     ├─ temp = 3.left = null
│     ├─ 3.left = dfs(3.right) = dfs(null) = null
│     ├─ 3.right = dfs(temp=null) = null
│     └─ return node(3)  ← After swap: 3 has no children
│
├─ node(1).right = dfs(temp=2) = dfs(2)
│  │
│  └─ dfs(2)
│     ├─ temp = 2.left = node(4)
│     ├─ 2.left = dfs(2.right) = dfs(5)
│     │  │
│     │  └─ dfs(5)
│     │     ├─ temp = 5.left = null
│     │     ├─ 5.left = dfs(5.right) = dfs(null) = null
│     │     ├─ 5.right = dfs(null) = null
│     │     └─ return node(5)  ← Leaf node, return as-is
│     │
│     ├─ 2.right = dfs(temp=4) = dfs(4)
│     │  │
│     │  └─ dfs(4)
│     │     ├─ temp = 4.left = null
│     │     ├─ 4.left = dfs(4.right) = dfs(null) = null
│     │     ├─ 4.right = dfs(null) = null
│     │     └─ return node(4)  ← Leaf node, return as-is
│     │
│     └─ return node(2)  ← After swap: left=5, right=4
│
└─ return node(1)  ← After swap: left=3, right=2

Final Tree State After All DFS Calls:
        1
       / \
      3   2
         / \
        5   4
    */
    TreeNode dfs(TreeNode node){
        if(node == null) return node;
        TreeNode temp = node.left;
        node.left = dfs(node.right);
        node.right = dfs(temp);
        return node;
    }
}
