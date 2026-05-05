import java.util.HashMap;
import java.util.Map;

public class leetcode389 {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Character c : t.toCharArray()) {
            if (map.getOrDefault(c, 0) == 0) return c;
            map.put(c, map.get(c) - 1);
        }

        return ' ';
    }
}
