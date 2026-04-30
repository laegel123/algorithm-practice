import java.util.Arrays;

public class programmers43164 {
    boolean ISFOUND = false;
    String[] ANSWER;
    boolean[] VISITED;
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        VISITED = new boolean[tickets.length];
        ANSWER = new String[tickets.length + 1];
        String[] path = new String[tickets.length + 1];
        path[0] = "ICN";
        dfs(tickets, path, "ICN", 1);
        
        return ANSWER;
    }
    
    public void dfs(String[][] tickets, String[] path, String cur, int idx) {
        if (ISFOUND) return;
        
        if (idx == tickets.length + 1) {
            ANSWER = path.clone();
            ISFOUND = true;
            return;
        }
        
        
        for (int i = 0; i < tickets.length; i++) {
            if (!VISITED[i] && tickets[i][0].equals(cur)) {
                String next = tickets[i][1];
                VISITED[i] = true;
                path[idx] = next; 
                dfs(tickets, path, next, idx + 1);
                VISITED[i] = false;
            }
            
        }
    }
}
