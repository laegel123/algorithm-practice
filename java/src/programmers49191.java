import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class programmers49191 {
    public int solution(int n, int[][] results) {
        List<List<Integer>> winGraph = new ArrayList<>();
        List<List<Integer>> loseGraph = new ArrayList<>();
        
        for (int i = 0; i <=n; i++) {
            winGraph.add(new ArrayList<>());
            loseGraph.add(new ArrayList<>());
        }
        
        for (int[] result : results) {
            winGraph.get(result[0]).add(result[1]);
            loseGraph.get(result[1]).add(result[0]);
        }
        
        
        int result = 0;
        
        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            int winCount = dfs(winGraph, i, visited);
            
            visited = new boolean[n + 1];
            int loseCount = dfs(loseGraph, i, visited);
            
            if (winCount + loseCount == n - 1) result++;
        }
        
        return result;
    }
    
    public int dfs(List<List<Integer>> graph, int start, boolean[] visited) {
        int count = 0;
        Stack<Integer> stack = new Stack();
        stack.push(start);
        visited[start] = true;
        
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    stack.push(next);
                    count++;
                }
            }
            
        }
        
        return count;
    }
}
