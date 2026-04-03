import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1182 {
    static int N, S;
    static int[] ARR;
    static int COUNT = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        ARR = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ARR[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        if (S == 0) COUNT--;
        System.out.println(COUNT);
        br.close();
    }

    static void dfs(int idx, int sum) {
        if (idx == N) {
            if (sum == S) {
                COUNT++;
            }
            return;
        }

        dfs(idx + 1, sum + ARR[idx]);
        dfs(idx + 1, sum);
    }
    
}
