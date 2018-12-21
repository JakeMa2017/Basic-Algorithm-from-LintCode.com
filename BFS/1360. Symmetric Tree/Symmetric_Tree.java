/**
 * Symmetric Tree
 * BFS
 * Jake Ma
 * 11-11-2018
 */

public class SymmetricTree {
    /**
     * @param root: root of the given tree
     * @return: whether it is a mirror of itself 
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        return helper(root.left, root.right);
        /*
        // Using Stack to check equality
        while(!queue.isEmpty()) {
            int size = queue.size();
            Stack<TreeNode> halfLevel = new Stack<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                if (head != null) {
                    queue.offer(head.left);
                    queue.offer(head.right);
                }
                if (size == 1) {
                    break;
                }
                if (size % 2 != 0) {
                    return false;
                }
                if (i < size / 2) {
                    halfLevel.push(head);
                } else {
                    if (head == null && head != halfLevel.pop()) {
                        return false;
                    } else if (head != null && halfLevel.peek() == null) {
                        return false;
                    } else if (head != null && head.val != halfLevel.pop().val) {
                        return false;
                    }
                }
            }
        }
        return true;
        */
        /*
        // Using ArrayList to check equality. Not at all elegant.
        while(!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<TreeNode> level = new ArrayList<>();
            if (size != 1 && size % 2 != 0) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                if (head.left != null)
                    queue.offer(head.left);
                if (head.right != null)
                    queue.offer(head.right);
                level.add(head.left);
                level.add(head.right);
            }
            
            for (int i = 0; i < level.size() / 2; i++) {
                if (level.get(i) != null && level.get(level.size() - 1 - i) != null) {
                    if(level.get(i).val != level.get(level.size() - 1 - i).val) {
                        return false;
                    }
                } else if ((level.get(i) != null && level.get(level.size() - 1 - i) == null) || (level.get(i) == null && level.get(level.size() - 1 - i) != null)) {
                    return false;
                }
            }
        }
        return true;
        */
        
    }
    
    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val == right.val) {
            return helper(left.left, right.right) && helper(left.right, right.left);
        }
        return false;
    }
    
}
