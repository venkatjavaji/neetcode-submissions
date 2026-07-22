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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //serialise the data by pushing the tree data to string
        //root+left+right
        StringBuilder sb = new StringBuilder();
        if(root==null)  {
            sb.append("n");
            return sb.toString();
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode t = q.poll();
            if(sb.length()>0) sb.append(",");
            if(t == null) {
                sb.append("n");
            } else {
                sb.append(t.val);
                q.offer(t.left);
                q.offer(t.right);
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    // [1,2,3,n,n,4,5,n,n,n,n] this is the input string we need to deserialise
    public TreeNode deserialize(String data) {
        
        if(data == null || data.equals("n")) return null;
        String[] datarr = data.split(",");
        Queue<TreeNode> qtree = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(datarr[0]));
        qtree.offer(root);
        int counter = 1;
        while(!qtree.isEmpty() && counter < datarr.length) {
            TreeNode parent = qtree.poll();
            
            String ls = datarr[counter];
            if(!ls.equals("n")) {
                parent.left = new TreeNode(Integer.valueOf(datarr[counter]));
                qtree.offer(parent.left);
            }
            counter++;
            String rs = datarr[counter];
            if(!rs.equals("n")) {
                parent.right = new TreeNode(Integer.valueOf(datarr[counter]));
                qtree.offer(parent.right);
            }
            counter++;
        }
        return root;
    }
}
