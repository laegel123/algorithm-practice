/**
 * @author laegel
 * @version 1.0
 * @since 2025-10-02
 */
public class leetcode5 {
    public static void main(String[] args) {
//        String s = "cbbd";
        String s = "aaaa";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            int[] odd = getExpandNum(s, i, i);
            int[] even = getExpandNum(s, i, i + 1);

            int length = end - start;
            if (odd[1] - odd[0] > length) {
                start = odd[0];
                end = odd[1];
            }
            if (even[1] - even[0] > length) {
                start = even[0];
                end = even[1];
            }
        }

        return s.substring(start, end + 1);
    }

    public static int[] getExpandNum(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return new int[]{l + 1, r - 1};
    }
}
