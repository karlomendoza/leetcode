public class BinaryTreePruning {

  public TreeNode pruneTree(TreeNode root) {
    if(recursivePruneTree(root))
      return null;

    return root;
  }

  public boolean recursivePruneTree(TreeNode node){

    if(node.left != null && recursivePruneTree(node.left))
      node.left = null;

    if(node.right != null && recursivePruneTree(node.right))
      node.right = null;

    if(node.val == 0 && node.left == null && node.right == null ){
      return true;
    }
    return false;
  }
}
