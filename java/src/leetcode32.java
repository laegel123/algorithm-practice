/**
 * @author laegel
 * @version 1.0
 * @since 2025-10-21
 */
public class leetcode32 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses(""));
    }

    public static int longestValidParentheses(String s) {
        int maxLength = 0;
        int l = 0;
        int r = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            } else {
                r++;
            }

            if (l == r) {
                maxLength = Math.max(maxLength, l + r);
            } else if (r > l) {
                l = 0;
                r = 0;
            }
        }

        l = 0;
        r = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                r++;
            } else {
                l++;
            }

            if (l == r) {
                maxLength = Math.max(maxLength, l + r);
            } else if (l > r) {
                l = 0;
                r = 0;
            }
        }

        return maxLength;
    }
}
