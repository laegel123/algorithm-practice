import java.util.LinkedList;
import java.util.Queue;

public class programmers43163 {
    public int solution(String begin, String target, String[] words) {
        
        return bfs(begin, target, words);
    }
    
    public int bfs(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        int[] dist = new int[words.length];
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < words.length; i++) {
            if (isChangeable(begin, words[i])) {
                q.offer(i);
                dist[i] = 1;
                visited[i] = true;
            }
        }
        
        
        while (!q.isEmpty()) {
            int now = q.poll();
            if (words[now].equals(target)) return dist[now];
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isChangeable(words[now], words[i])) {
                    q.offer(i);
                    visited[i] = true;
                    dist[i] = dist[now] + 1;
                }
            }
            
        }
        
        return 0;
    }
    
    public boolean isChangeable(String begin, String target) {
        int count = 0;
        
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != target.charAt(i)) {
                count++;
            }
            
            if (count > 1) return false;
        }
        
        return true;
    }
}
