public class leetcode114 {
    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);
        
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode cur = root;

        while (cur.right != null) {
            cur = cur.right;
        }

        cur.right = temp;
    }
}
