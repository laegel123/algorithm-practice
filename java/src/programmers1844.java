import java.util.LinkedList;
import java.util.Queue;

public class programmers1844 {
    int[] DISTANCE_X = {1, 0, -1, 0};
    int[] DISTANCE_Y = {0 ,1 ,0 ,-1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        return bfs(maps, n, m);
    }
    
    public int bfs(int[][] maps, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            if (now[0] == n - 1 && now[1] == m - 1) return maps[now[0]][now[1]];
            
            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + DISTANCE_X[i];
                int nextY = now[1] + DISTANCE_Y[i];
   
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                if (visited[nextX][nextY] || maps[nextX][nextY] == 0) continue;
                
                q.offer(new int[]{nextX, nextY});
                maps[nextX][nextY] = maps[now[0]][now[1]] + 1;
                visited[nextX][nextY] = true;
            }
            
            
        }
        
        return -1;
    }
}
