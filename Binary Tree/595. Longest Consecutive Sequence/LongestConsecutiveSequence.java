/**
 * Binary Tree Longest Consecutive Sequence
 * Binary Tree
 * Jake Ma
 * 11-24-2018
 */

public class LongestConsecutiveSequence {
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root, root.val - 2, 1, 0);
    }
    
    public int helper(TreeNode root, int pre, int cur, int max) {
        if (root == null) {
            return max;
        }
        
        if (root.val == pre + 1) {
            cur += 1; // longest path so far
        } else {
            cur = 1;
        }
        max = Math.max(max, cur); // update longest path value
        int left = helper(root.left, root.val, cur, max);
        int right = helper(root.right, root.val, cur, max);
        
        max = Math.max(max, Math.max(left, right));
        
        return max;
    }
}