import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1149 {

    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] price = new int[n][3];
        int[][] result = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            price[i][0] = Integer.parseInt(st.nextToken());
            price[i][1] = Integer.parseInt(st.nextToken());
            price[i][2] = Integer.parseInt(st.nextToken());
        }

        result[0][0] = price[0][0];
        result[0][1] = price[0][1];
        result[0][2] = price[0][2];

        for (int i = 1; i < n; i++) {
            result[i][0] = Math.min(result[i - 1][1], result[i - 1][2]) + price[i][0];
            result[i][1] = Math.min(result[i - 1][0], result[i - 1][2]) + price[i][1];
            result[i][2] = Math.min(result[i - 1][0], result[i - 1][1]) + price[i][2];
        }

        System.out.println(Math.min(result[n - 1][0], Math.min(result[n - 1][1], result[n - 1][2])));
        br.close();
    }
    
}

