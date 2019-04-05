/**
 * Jake Ma
 * Binary Tree Zigzag Level Order Traversal
 * BFS
 * 4/5/2019
 * 
 * 
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class BinaryTreeZigzagLevelOrderTraversal {
    /**
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        
        if (root == null) {
            return results;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false; // reverse order for even number levels
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> result = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                result.add(head.val);
                
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            if (reverse) {
                Collections.reverse(result);
                
            }
            reverse = !reverse;
            results.add(result);
        }
        
        return results;
    }
}