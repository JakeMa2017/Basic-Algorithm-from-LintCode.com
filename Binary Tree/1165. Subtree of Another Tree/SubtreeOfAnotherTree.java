/**
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

public class SubtreeOfAnotherTree {
    /**
     * @param s: the s' root
     * @param t: the t' root
     * @return: whether tree t has exactly the same structure and node values with a subtree of s
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // Write your code here
        if (s == null) {
            return t == null;
        }
        
        if (s.val == t.val && compare(s, t)) {
            return true;
        }
        
        return isSubtree(s.left, t) || isSubtree(s.right, t);
        
    }
    
    private boolean compare(TreeNode s, TreeNode t) {
        if (s == null) {
            return t == null;
        }
        
        if (t == null || s.val != t.val) {
            return false;
        }
        
        return compare(s.left, t.left) && compare(s.right, t.right);
    }
}