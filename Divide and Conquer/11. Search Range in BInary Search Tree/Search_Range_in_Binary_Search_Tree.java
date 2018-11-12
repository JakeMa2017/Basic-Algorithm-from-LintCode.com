/**
 * Search Range in Binary Search Tree
 * Divide and Conquer OR simple and violent
 * Jake Ma
 * 11-11-2018
 */

public class Search_Range_in_Binary_Search_Tree {
    /**
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */

    public List<Integer> result;
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        
        // It's a ordered BST, so we can do it simple and violent
        result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        helper(root, k1, k2, result);
        return result;
        
        // List<Integer> result = new ArrayList<>();
        
        // if (root == null) {
        //     return result;
        // }
        // if (root.val <= k2 && root.val >= k1) {
        //     result.add(root.val);
        // }
        
        // List<Integer> left = searchRange(root.left, k1, k2);
        // List<Integer> right = searchRange(root.right, k1, k2);
        
        // result.addAll(left);
        // result.addAll(right);
        
        // return result;
    }
    
    private void helper(TreeNode root, int k1, int k2, List<Integer> result) {
        if (root == null) {
            return;
        }
        // Go to the very bottom one to get the min and max
        if (root.val > k1) {
            helper(root.left, k1, k2, result);
        }
        if (root.val >= k1 && root.val <= k2) {
            result.add(root.val);
        }
        if (root.val < k2) {
            helper(root.right, k1, k2, result);
        }
    }
}