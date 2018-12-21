/**
 * Binary Tree Path Sum
 * Divide and Conquer
 * Jake Ma
 * 11-11-2018
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

public class BInary_Tree_Path_Sum {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // Exit and add leaf node val to result
        if (root.left == null && root.right == null && root.val == target) {
            List<Integer> path = new ArrayList<>();
            path.add(root.val);
            result.add(path);
            return result;
        }

        // Divide
        List<List<Integer>> left = binaryTreePathSum(root.left, target - root.val);
        List<List<Integer>> right = binaryTreePathSum(root.right, target - root.val);

        // Conquer

        // Multiple from left and right paths, so we use a for loop here
        for (List<Integer> l : left) {
            l.add(0, root.val);
            result.add(l);
        }
        for (List<Integer> r : right) {
            r.add(0, root.val);
            result.add(r);
        }

        return result;

    }
}
