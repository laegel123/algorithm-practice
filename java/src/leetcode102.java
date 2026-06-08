import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode nowNode = q.poll();
                list.add(nowNode.val);

                if (nowNode.left != null) {
                    q.offer(nowNode.left);
                }
                if (nowNode.right != null) {
                    q.offer(nowNode.right);
                }
            }

            result.add(list);
        }

        return result;
    }
}