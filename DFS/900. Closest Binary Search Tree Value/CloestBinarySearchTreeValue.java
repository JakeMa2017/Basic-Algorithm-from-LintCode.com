/**
 * Jake Ma
 * Cloest Binary Search Tree Value
 * DFS
 * 4/3/2019
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

public class CloestBinarySearchTreeValue {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }
        
        TreeNode lower = lowerBound(root, target);
        TreeNode upper = upperBound(root, target);
        
        // Either is null means that that other one is the only solution
        if (lower == null) {
            return upper.val;
        }
        if (upper == null) {
            return lower.val;
        }
        
        // Notice that upper - target should be compared with target - lower
        if (upper.val - target < target - lower.val) {
            return upper.val;
        }
        
        return lower.val;
    }
    
    private TreeNode lowerBound(TreeNode root, double target) {
        if (root == null) {
            return null;
        }
        
        if (target <= root.val) {
            return lowerBound(root.left, target);
        }
        
        TreeNode lowerNode = lowerBound(root.right, target);
        if (lowerNode != null) {
            return lowerNode;
        }
        
        return root;
    }
    
    private TreeNode upperBound(TreeNode root, double target) {
        if (root == null) {
            return null;
        }
        
        if (target > root.val) {
            return upperBound(root.right, target);
        }
        
        TreeNode upperNode = upperBound(root.left, target);
        if (upperNode != null) {
            return upperNode;
        }
        
        return root;
    }
}