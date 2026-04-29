import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class programmers43162 {
    boolean[] VISITED;
    
    public int solution(int n, int[][] computers) {
        VISITED = new boolean[n];
        List<List<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1 && i != j) {
                    list.get(i).add(j);
                }
            }
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (!VISITED[i]) {
                bfs(list, i);
                result++;
            }
        }
        
        return result;
    }
    
    public void bfs(List<List<Integer>> list, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        VISITED[start] = true;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : list.get(cur)) {
                if (!VISITED[next]) {
                    q.offer(next);
                    VISITED[next] = true;
                }
            }
        }
    }
}
