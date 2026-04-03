import java.util.Scanner;

public class baekjoon2579 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < n + 1; i++) {
            if (i == 1) {
                dp[1] = arr[1];
            } else if (i == 2) {
                dp[2] = arr[1] + arr[2];
            } else {
                dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];
            }
        }

        System.out.println(dp[n]);
        sc.close();
    }
    
}