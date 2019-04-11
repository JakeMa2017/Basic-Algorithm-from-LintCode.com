/**
 * Jake Ma
 * Kth Smallest Element in a Binary Tree
 * BST
 * 4/8/2019
 */

public class KthSmallestElementInABST {
    /**
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    private int result = 0;
    private int count = 0;
    class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return result;
        }
        helper(root, k);
        return result;
    }
    
    // in order traversal
    private void helper(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        
        helper(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }

        helper(root.right, k);
    }
}