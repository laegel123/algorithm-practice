import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode47 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        boolean[] visited = new boolean[n];

        dfs(nums, visited, new ArrayList<>(), 0, n);

        return result;
    }

    public void dfs(int[] nums, boolean[] visited, List<Integer> list, int depth, int len) {
        if (depth == len) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;

                visited[i] = true;
                list.add(nums[i]);
                dfs(nums, visited, list, depth + 1, len);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
