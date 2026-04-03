import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon15649 {
    static int N, M;
    static int[] ARR;
    static boolean[] VISITED;
    static StringBuilder SB = new StringBuilder();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ARR = new int[M];
        VISITED = new boolean[N + 1];

        dfs(0);

        System.out.print(SB);
        br.close();
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                SB.append(ARR[i] + " ");
            }
            SB.append("\n");
            return;
        }


        for (int i = 1; i < N + 1; i++) {
            if (!VISITED[i]) {
                VISITED[i] = true;
                ARR[depth] = i;
                dfs(depth + 1);
                VISITED[i] = false;
            }
        }
        
    }
    
}
