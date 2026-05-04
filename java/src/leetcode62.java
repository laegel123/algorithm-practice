public class leetcode62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = 1;
                } else if (i == 1 && j == 2) {
                    dp[i][j] = 1;
                } else if (i == 2 && j == 1) {
                    dp[i][j] = 1;
                } else {
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    } else if (i - 1 < 0) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (j - 1 < 0) {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
}
