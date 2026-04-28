import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class programmers42861 {
    public int solution(int n, int[][] costs) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(new ArrayList<>());
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        int count = 0;
        int result = 0;
        
        for (int[] cost : costs) {
            if (!isConnect(list, cost[0], cost[1])) {
                list.get(cost[0]).add(cost[1]);
                list.get(cost[1]).add(cost[0]);
                count++;
                result += cost[2];
            }
            
            if (count == n - 1) break;
        }
        
        return result;
    }
    
    public boolean isConnect(List<List<Integer>> list, int cur, int target) {
        boolean[] visited = new boolean[list.size()];
        return dfs(list, visited, cur, target);
    }
    
    public boolean dfs(List<List<Integer>> list, boolean[] visited, int cur, int target) {
        if (cur == target) return true;
        
        visited[cur] = true;
        for (int next : list.get(cur)) {
            if (!visited[next] && dfs(list, visited, next, target)) {
                return true;
            }
        }
        
        return false;
    }
}
