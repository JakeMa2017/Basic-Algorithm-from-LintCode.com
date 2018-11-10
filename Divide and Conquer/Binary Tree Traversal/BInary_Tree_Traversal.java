import javax.swing.tree.TreeNode;

/*
* Binary Tree Traversal
* Divide and Conquer
* Jake Ma
* 2018-11-10
* 
* Definition for binary tree
* public class TreeNode {
*     int val;
*     TreeNode left;
*     TreeNode right;
*     TreeNode(int x) { val = x; }
* }
*/

public class Binary_Tree_traversal {
  /**
   * @param root: A Tree
   * @return: In/Post/Pre order a list of lists of integer
   */
  public List<Integer> preOrder(TreeNode root) {
      List<Integer> result = new ArrayList<>();

      if (root == null) {
        return result;
      }

      List<Integer> left = preOrder(root.left);
      List<Integer> right = preOrder(root.right);

      result.add(root.val);
      result.addAll(left);
      result.addAll(right);

      return result;
  }

  public List<Integer> postOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    if (root = null) {
      return result;
    }

    List<Integer> left = new postOrder(root.left);
    List<Integer> right = new postOrder(root.right);

    result.addAll(left);
    result.addAll(right);
    result.add(root.val);

    return result;
  }

  public List<Integer> inOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    List<Integer> left = inOrder(root.left);
    LIst<Integer> right = inOrder(root.right);

    result.addAll(left);
    result.add(root.val);
    result.addAll(right);

    return result;
  }
}