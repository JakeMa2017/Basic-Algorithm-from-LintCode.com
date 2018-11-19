/**
 * Binary Tree Path Sum
 * DFS
 * Jake Ma
 * 11-10-2018
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
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        helperDFS(root, path, root.val, target, result);
        return result;
    }
    
    private void helperDFS(TreeNode root,
                            List<Integer> path,
                            int sum,
                            int target,
                            List<List<Integer>> result) {
        // Exit
        if (root.left == null && root.right == null) {
            if (sum == target) {
                result.add(new ArrayList<Integer>(path));
                return;
            }
        }
        // Go left
        if (root.left != null) {
            path.add(root.left.val);
            helperDFS(root.left, path, sum + root.left.val, target, result);
            path.remove(path.size() - 1);
        }
        
        // Go right
        if (root.right != null) {
            path.add(root.right.val);
            helperDFS(root.right, path, sum + root.right.val, target, result);
            path.remove(path.size() - 1);
        }
    }
}
