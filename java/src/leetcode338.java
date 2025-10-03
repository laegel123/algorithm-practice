/**
 * @author laegel
 * @version 1.0
 * @since 2025-10-02
 */
public class leetcode338 {
    public static void main(String[] args) {

    }

    public int[] countBits(int n) {
        if (n == 0) return new int[]{0};
        if (n == 1) return new int[]{0, 1};

        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i/2] + i%2;
        }

        return memo;
    }
    // n = 0 -> 0
    // n = 1 -> 1 1
    // n = 2 -> 1 10
    // n = 3 -> 2 11
    // n = 4 -> 1 100
    // n = 5 -> 2 101
    // n = 6 -> 2 110
    // n = 7 -> 3 111
    // n = 8 -> 1 1000
    // n = 9 -> 2 1001
    // n = 10 -> 2 1010
    // n = 11 -> 3 1011
    // f(n) = f(n/2) + i%2
}
