import java.util.ArrayList;
import java.util.List;

public class PathSumII {
  List<List<Integer>> ans = new ArrayList<>();
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    helperF(root, targetSum, new ArrayList<>());
    if(ans.isEmpty())
      return new ArrayList<>();
    return ans;
  }

  public void helperF(TreeNode root, int targetSum, List<Integer> path){

    if(root == null)
      return;

    path.add(root.val);

    if(root.left == null && root.right == null && targetSum - root.val == 0 ){
      List a = new ArrayList<>();
      a.addAll(path);
      ans.add(a);
    }

    helperF(root.left, targetSum - root.val, path);
    helperF(root.right, targetSum - root.val, path);
    path.remove(path.size()-1);
  }
}
