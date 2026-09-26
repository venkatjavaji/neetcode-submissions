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

public class Codec {

    private static final String NULL = "#";
    private static final String SEP = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        ser_dfs(root,sb);
        return sb.toString();
    }

    void ser_dfs(TreeNode node, StringBuilder sb) {
         //depth-first..
        if(node==null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(node.val).append(SEP);
        ser_dfs(node.left,sb);
        ser_dfs(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Deque<String> q = new ArrayDeque<>(Arrays.asList(data.split(SEP)));
        Deque<String> q = new ArrayDeque<>();
        for(String s : data.split(SEP)) {
            q.offer(s);
        }
        return des_dfs(q);
    }

    TreeNode des_dfs(Deque<String> bt) {
        String s = bt.poll();
        if(s.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = des_dfs(bt);
        root.right = des_dfs(bt);
        return root;
    }
}
