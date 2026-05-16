import javax.swing.tree.TreeNode;

public class leetcode112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        int remain = targetSum - root.val;
        return hasPathSum(root.left, remain) ||
               hasPathSum(root.right, remain);
    }
}
