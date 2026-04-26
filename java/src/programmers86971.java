import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class programmers86971 {
    public int solution(int n, int[][] wires) {
        int answer = n;
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int[] wire : wires) {
            map.computeIfAbsent(wire[0], k -> new ArrayList<>()).add(wire[1]);
            map.computeIfAbsent(wire[1], k -> new ArrayList<>()).add(wire[0]);
        }
        
        for (int[] wire : wires) {
            int count = bfs(map, wire, n);
            answer = Math.min(answer, Math.abs(count-(n - count)));
        }
        
        return answer;
    }
    
    public int bfs(Map<Integer, List<Integer>> map, int[] removed, int n) {
        int count = 0;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            
            for (int next : map.getOrDefault(node, new ArrayList<>())) {
                if (!visited[next] && !isRemoved(node, next, removed)) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        
        return count;
    }
    
    public boolean isRemoved(int node, int next, int[] removed) {
        return (node == removed[0] && next == removed[1]) ||
            (node == removed[1] && next == removed[0]);
    }
}
