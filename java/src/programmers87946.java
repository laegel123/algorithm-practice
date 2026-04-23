
/*
https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */

public class programmers87946 {
    private int MAX_COUNT = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(dungeons, visited, k, 0);
        return MAX_COUNT;
    }
    
    public void dfs(int[][] dungeons, boolean[] visited, int status, int count) {
        MAX_COUNT = Math.max(MAX_COUNT, count);
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && status >= dungeons[i][0]) {
                visited[i] = true;
                dfs(dungeons, visited, status - dungeons[i][1], count + 1);
                visited[i] = false;
            }
        }
    }
}
