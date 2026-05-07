public class leetcode99 {
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
  
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    TreeNode change;
    TreeNode target;

    public void recoverTree(TreeNode root) {
        inorder(root);

        int temp = change.val;
        change.val = target.val;
        target.val = temp;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        if (prev.val > node.val) {
            if (change == null) {
                change = prev;
            }
            target = node;
        }

        prev = node;

        inorder(node.right);
    }
}
