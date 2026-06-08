import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        int idx = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = q.poll();
                list.add(curNode.val);

                if (curNode.left != null) q.offer(curNode.left);
                if (curNode.right != null) q.offer(curNode.right);
            }

            if (idx % 2 == 1) {
                Collections.reverse(list);
            }

            result.add(list);
            idx++;
        }

        return result;
    }
}
