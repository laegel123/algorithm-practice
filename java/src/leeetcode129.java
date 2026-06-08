public class leeetcode129 {
    int result = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);

        return result;
    }

    public void dfs(TreeNode root, int num) {
        if (root == null) return;

        num = num * 10 + root.val;

        if (root.left == null && root.right == null) {
            result += num;
            return;
        }

        dfs(root.left, num);
        dfs(root.right, num);
    }
}
