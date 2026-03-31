import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon7576 {
    static int N;
    static int M;
    static int[][] GRAPH;
    static boolean[][] VISITED;
    static int[] DX = {0, 0, -1, 1};
    static int[] DY = {-1, 1, 0, 0};

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        GRAPH = new int[N][M];
        VISITED = new boolean[N][M];

        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < M; j++) {
                GRAPH[i][j] = sc.nextInt();
            }
        }

        System.out.println(bfs() - 1);
        sc.close();
    }

    static int bfs() {
        int day = 1;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (GRAPH[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    VISITED[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] c = q.poll();
            int cx = c[0];
            int cy = c[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (GRAPH[nx][ny] == -1 || VISITED[nx][ny]) continue;

                q.offer(new int[]{nx, ny});
                VISITED[nx][ny] = true;
                GRAPH[nx][ny] = GRAPH[cx][cy] + 1;
                day = Math.max(day, GRAPH[nx][ny]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (GRAPH[i][j] == 0) day = 0;
            }
        }

        return day;
    }


}
