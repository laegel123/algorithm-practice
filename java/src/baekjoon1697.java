import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon1697 {
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] p = new int[100001];
        p[n] = 1;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);

        while (!q.isEmpty()) {
            int c = q.poll();

            if (c == k) break;

            for (int i = 0; i < 3; i++) {
                int nx = 0;
                if (i == 0) {
                    nx = c - 1;
                } else if (i == 1) {
                    nx = c + 1;
                } else {
                    nx = c * 2;
                }
            
                if (nx < 0 || nx > 100000) continue;
                if (p[nx] > 0) continue;
                q.offer(nx);
                p[nx] = p[c] + 1;

            }
        }

        System.out.println(p[k] - 1);
        br.close();
    }
}
