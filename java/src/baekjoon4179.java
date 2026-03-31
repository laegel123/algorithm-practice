import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon4179 {
    static int N;
    static int M;
    static char[][] GRAPH;
    static int[][] FIRE;
    static int[][] J;
    static boolean[][] VISITED_J;
    static boolean[][] VISITED_F;
    static int[] DX = {0, 0, -1, 1};
    static int[] DY = {-1, 1, 0, 0};
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        GRAPH = new char[N][M];
        FIRE = new int[N][M];
        J = new int[N][M];
        VISITED_J = new boolean[N][M];
        VISITED_F = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                GRAPH[i][j] = line.charAt(j);
            }
        }

        int result = bfs();
        System.out.println(result == -1 ? "IMPOSSIBLE" : result);
        sc.close();
    }

    static int bfs() {
        Queue<int[]> jq = new LinkedList<>();
        Queue<int[]> fq = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                FIRE[i][j] = -1;
                J[i][j] = -1;
                if (GRAPH[i][j] == 'J') {
                    jq.offer(new int[]{i, j});
                    VISITED_J[i][j] = true;
                    J[i][j] = 0;
                }
                if (GRAPH[i][j] == 'F') {
                    fq.offer(new int[]{i, j});
                    VISITED_F[i][j] = true;
                    FIRE[i][j] = 0;
                }
            }
        }

        while (!fq.isEmpty()) {
            int[] c = fq.poll();
            int cx = c[0];
            int cy = c[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (GRAPH[nx][ny] == '#' || VISITED_F[nx][ny]) continue;

                FIRE[nx][ny] = FIRE[cx][cy] + 1;
                VISITED_F[nx][ny] = true;
                fq.offer(new int[]{nx, ny});
            }
        }

        while (!jq.isEmpty()) {
            int[] c = jq.poll();
            int cx = c[0];
            int cy = c[1];

            if (cx == 0 ||cx == N - 1 || cy == 0 || cy == M - 1) {
                return J[cx][cy] + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (GRAPH[nx][ny] == '#' || VISITED_J[nx][ny]) continue;
                if (FIRE[nx][ny] != -1 && J[cx][cy] + 1 >= FIRE[nx][ny]) continue;

                jq.offer(new int[]{nx, ny});
                J[nx][ny] = J[cx][cy] + 1;
                VISITED_J[nx][ny] = true;
            }

        }

        return -1;
    }
}
