import java.util.ArrayList;
import java.util.List;

public class leetcode113 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
  }
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, new ArrayList<>(), 0);

        return result;
    }

    public void dfs(TreeNode root, int targetSum, List<Integer> list, int sum) {
        if (root == null) return;

        list.add(root.val);
        sum += root.val;

        if (root.left == null && root.right == null && sum == targetSum) {
            result.add(new ArrayList<>(list));
        }

        dfs(root.left, targetSum, list, sum);
        dfs(root.right, targetSum, list, sum);
        list.remove(list.size() - 1);

    }
}
