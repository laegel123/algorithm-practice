/**
 * @author laegel
 * @version 1.0
 * @since 2025-10-13
 */
public class leetcode10 {
    public static void main(String[] args) {
        System.out.println(isMatch("ab", ".*"));
    }
    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[n][m] = true;

        for (int i = n; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                boolean firstMatch = i < n && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');

                // case *
                if (j+1 < m && p.charAt(j+1) == '*') {
                    dp[i][j] = dp[i][j+2] || (firstMatch && dp[i+1][j]);
                } else {
                // case not *
                    dp[i][j] = firstMatch && dp[i+1][j+1];
                }
            }
        }

        return dp[0][0];
    }
}
