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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //theoretically.. LCA is finding the the ancestor using DFS
        //reach to the bottom
        // compare if node is equal to p/q
        //if matches return that p/q else null
        // if p & q are not null return node
        // if either one of p | q is null return non-null value
        return dfs(root,p,q);
        
    }

    TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        // Base case: if we reach null, return null (not found)
        if(node == null) return node;

        // If current node is p or q, return it
        // (it might be the LCA if the other is in its subtree)
        if(node == p || node == q) return node;

        //how to fetch left and right
        // Recursively search left subtree
        TreeNode left = dfs(node.left, p, q);
         // Recursively search right subtree
        TreeNode right = dfs(node.right, p, q);

        // If both found on different sides, current is LCA
        if(left != null && right != null) return node;

         // If found on one side, return that side
        // (means both p and q are on the same side)
        return left!=null ? left : right;
    }
}

/**
Tree:
           5
          / \
         3   8
        / \ / \
       1  4 7  9
        \
         2
dfs(node=5, p=3, q=8):
  │
  ├─ node=5, is it 3 or 8? NO
  │  Search left and right
  │
  ├─ left = dfs(node=3, p=3, q=8):
  │   │
  │   ├─ node=3, is it 3? YES ✓
  │   └─ return node=3  ← Found p!
  │
  ├─ right = dfs(node=8, p=3, q=8):
  │   │
  │   ├─ node=8, is it 8? YES ✓
  │   └─ return node=8  ← Found q!
  │
  ├─ Analysis at node=5:
  │   left = node=3 (not null)
  │   right = node=8 (not null)
  │   
  │   if(left != null && right != null) {
  │       return node  ← BOTH FOUND!
  │   }
  │
  └─ return 5 ✓

Answer: 5

+++++++++++++
Same tree:
           5
          / \
         3   8
        / \ / \
       1  4 7  9
        \
         2

dfs(5, p=1, q=4):
  Is 5 == 1 or 5 == 4? NO
  
  left = dfs(3, p=1, q=4)
    │
    ├─ Is 3 == 1 or 3 == 4? NO
    │
    ├─ left = dfs(1, p=1, q=4)
    │   Is 1 == 1? YES
    │   return 1  ← Found p!
    │
    ├─ right = dfs(4, p=1, q=4)
    │   Is 4 == 4? YES
    │   return 4  ← Found q!
    │
    ├─ Analysis at node 3:
    │   left = 1 (not null)
    │   right = 4 (not null)
    │   Both found → return 3 ✓
    │
    └─ return 3
  
  right = dfs(8, p=1, q=4)
    Is 8 == 1 or 8 == 4? NO
    Search deeper...
    left = dfs(7, ...) = null
    right = dfs(9, ...) = null
    return null
  
  Analysis at node 5:
    left = 3 (not null)
    right = null
    One side null → return left = 3 ✓

Answer: 3
Reason: Both 1 and 4 are in node 3's subtree


+++++++++++++
Tree:
           5
          / \
         3   8
        / \ / \
       1  4 7  9
        \
         2

dfs(5, p=1, q=2):
  5 != 1 and 5 != 2
  
  left = dfs(3, p=1, q=2):
    3 != 1 and 3 != 2
    
    left = dfs(1, p=1, q=2):
      Is 1 == 1? YES
      return 1 ← Found p! STOP immediately
                 (don't search node 1's children)
    
    right = dfs(4, p=1, q=2):
      4 != 1 and 4 != 2
      left  = dfs(null) = null
      right = dfs(null) = null
      return null ← 4 has NO children!
                    node 2 is NOT under node 4
    
    Analysis at node 3:
      left  = 1 (not null)
      right = null
      One side null → return left = 1
    
    return 1
  
  right = dfs(8, p=1, q=2):
    ...
    return null
  
  Analysis at node 5:
    left  = 1 (not null)
    right = null
    One side null → return 1

Answer: 1 ✓



*/
