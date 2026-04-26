import java.util.ArrayList;
import java.util.List;

public class programmers84512 {
    List<String> list = new ArrayList<>();
    String[] VOWELS = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        dfs("", 0);
        return list.indexOf(word) + 1;
    }
    
    void dfs(String current, int len) {
        if (current.length() == 5) return;
        
        for (String vowel : VOWELS) {
            String next = current + vowel;
            list.add(next);
            dfs(next, len + 1);
        }
    }
}
