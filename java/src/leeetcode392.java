/**
 * @author laegel
 * @version 1.0
 * @since 2025-10-02
 */
public class leeetcode392 {
    public static void main(String[] args) {
        String s = "bb";
        String t = "ahbgdc";

        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;

        int index = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (t.length() - index < s.length() - i) {
                return false;
            }
            int j = index;
            char c1 = s.charAt(i);

            while (flag && j < t.length()) {
                char c2 = t.charAt(j);
                if (c1 == c2) {
                    if (i == s.length() - 1) return true;
                    index = j + 1;
                    break;
                }
                j++;

                if (j == t.length()) {
                    flag = false;
                }
            }
            if (!flag) return false;
        }

        return false;
    }

    // two pointer
    public static boolean isSubsequence2(String s, String t) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }
}
