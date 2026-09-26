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
    private static final String NULL =  "#";
    private static final String SEP = ",";
    public String serialize(TreeNode root) {
        //level-order building...

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>(); //cant use Deque since it wont allow null-values..
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null) {
                sb.append(NULL).append(SEP);
            } else {
                sb.append(node.val).append(SEP);
                q.offer(node.left);
                q.offer(node.right);
                
            }
        }
        System.out.println(sb);
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        //build Tree from the String..
        //first build the root and add it to the queue
        // build left add to queue and build right and add to queue and repeat

        String[] d = data.split(SEP);
        if(NULL.equals(d[0])) return null;

        Deque<TreeNode> q = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(d[0]));
        q.offer(root);
        int counter = 1;
        while(!q.isEmpty()) {
            TreeNode parent = q.poll();
            //first will be left
            if(!NULL.equals(d[counter])) {
                parent.left = new TreeNode(Integer.parseInt(d[counter]));
                q.offer(parent.left);
            }
            counter++;//counter will be incremented

            //second will be right
            if(!NULL.equals(d[counter])){
                parent.right = new TreeNode(Integer.parseInt(d[counter]));
                q.offer(parent.right);
            }
            counter++;
        }
        return root;
        
    }
}
