import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class programmers49189 {
    public int solution(int n, int[][] edge) {
        int[] w = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        for (int i = 0; i < w.length; i++) {
            w[i] = -1;
        }
        
        return bfs(graph, n, w);
    }
    
    public int bfs(List<List<Integer>> graph, int n, int[] w) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        w[1] = 0;
        int max = 0;
        
        while (!q.isEmpty()) {
            int now = q.poll();
            
            
            for (int next : graph.get(now)) {
                if (w[next] == -1) {
                    q.offer(next);
                    w[next] = w[now] + 1;
                    max = Math.max(max, w[next]);
                }
            }
        }
        
        int result = 0;
        for (int x : w) {
            if (x == max) result++;
        }
        
        return result;
    }
}