/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class RecoverBinarySearchTree {
    TreeNode first, second, prev;
    public void recoverTree(TreeNode root) {
        findSwapped(root);
        swap();
    }
    
    private void swap(){
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    
    private TreeNode findSwapped(TreeNode node){
        if(node == null)
            return node;
        
        findSwapped(node.left);
        //processar el actual;
        if(prev != null && prev.val > node.val){
            if(first == null)
                first = prev;
            second = node;
        }
        
        
        prev = node;
        findSwapped(node.right);
        return node;
    }
}
