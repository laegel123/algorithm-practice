import java.util.ArrayList;
import java.util.List;

/**
 * @author laegel
 * @version 1.0
 * @since 2025-10-03
 */
public class leetcode22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recur(0, 0, n, "", result);

        return result;
    }

    public static void recur(int openCount, int closeCount, int n, String str, List<String> result) {
        if (closeCount == n) {
            result.add(str);
            return;
        }

        if (openCount < n) {
            str += "(";
            recur(openCount + 1, closeCount, n, str, result);
            str = str.substring(0, str.length() - 1);
        }

        if (openCount > closeCount) {
            str += ")";
            recur(openCount, closeCount + 1, n, str, result);
            str = str.substring(0, str.length() - 1);
        }
    }
}
