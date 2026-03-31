import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon1926 {

    static int N;
    static int M;
    static int[][] GRAPH;
    static boolean[][] VISITED;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        VISITED = new boolean[N][M];
        GRAPH = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                GRAPH[i][j] = sc.nextInt();
            }
        }


        int count = 0;
        int maxSize = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (GRAPH[i][j] == 1 && !VISITED[i][j]) {
                    count++;
                    maxSize = Math.max(maxSize, bfs(i,j));
                }
            }
        }

        System.out.println(count);
        System.out.println(maxSize);
    }

    // return picture size
    public static int bfs(int x, int y) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        VISITED[x][y] = true;
        int size = 1;

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int cx = arr[0];
            int cy = arr[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (GRAPH[nx][ny] == 0 || VISITED[nx][ny]) continue;

                q.offer(new int[]{nx, ny});
                VISITED[nx][ny] = true;
                size++;
            }
        }

        return size;
    }
}