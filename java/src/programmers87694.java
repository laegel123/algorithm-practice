import java.util.LinkedList;
import java.util.Queue;

public class programmers87694 {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] point = new int[102][102];
        
        for (int[] r : rectangle) {
            int x1 = r[0] * 2;
            int x2 = r[2] * 2;
            int y1 = r[1] * 2;
            int y2 = r[3] * 2;
            
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    point[i][j] = 1;
                }
            }
        }
        
        for (int[] r : rectangle) {
            int x1 = r[0] * 2;
            int x2 = r[2] * 2;
            int y1 = r[1] * 2;
            int y2 = r[3] * 2;
            
            for (int i = x1 + 1; i < x2; i++) {
                for (int j = y1 + 1; j < y2; j++) {
                    point[i][j] = 0;
                }
            }
        }
        
        return bfs(point, characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }
    
    public int bfs(int[][] point, int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[102][102];
        q.offer(new int[]{characterX, characterY});
        visited[characterX][characterY] = true;
        
        int[] distanceX = {1, 0, -1 ,0};
        int[] distanceY = {0 ,1 ,0, -1};
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            if (now[0] == itemX && now[1] == itemY) return (point[itemX][itemY] - 1) / 2;
            
            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + distanceX[i];
                int nextY = now[1] + distanceY[i];
                
                if (nextX < 0 || nextX >= 102 || nextY < 0 || nextY >= 102) continue;
                if (visited[nextX][nextY] || point[nextX][nextY] == 0) continue;
                
                visited[nextX][nextY] = true;
                point[nextX][nextY] = point[now[0]][now[1]] + 1;
                q.offer(new int[] {nextX, nextY});
            }
        }
        
        return -1;
    }
}
