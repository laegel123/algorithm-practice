import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon2178 {
    static int N;
    static int M;
    static int[][] GRAPH;
    static boolean[][] VISITED;
    static int[] DX = {0, 0, -1, 1};
    static int[] DY = {-1, 1, 0, 0}; 

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        GRAPH = new int[N][M];
        VISITED = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                GRAPH[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        System.out.println(GRAPH[N - 1][M - 1]);
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        VISITED[x][y] = true;

        while (!q.isEmpty()) {
            int[] c = q.poll();
            int cx = c[0];
            int cy = c[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (GRAPH[nx][ny] == 0 || VISITED[nx][ny]) continue;

                q.offer(new int[]{nx, ny});
                VISITED[nx][ny] = true;
                GRAPH[nx][ny] = GRAPH[cx][cy] + 1;
            }
        }
    }
}
