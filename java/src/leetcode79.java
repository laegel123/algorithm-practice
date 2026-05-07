public class leetcode79 {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(board, new boolean[n][m], word, i, j, 0)) return true;
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, boolean[][] visited, String word, int x, int y, int depth) {
        if (board[x][y] != word.charAt(depth)) return false;
        
        if (depth == word.length() - 1) return true;

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length) continue;

            if (!visited[nextX][nextY]) {
                if (dfs(board, visited, word, nextX, nextY, depth + 1)) {
                    return true;
                }
            }
        }
        visited[x][y] = false;

        return false;
    }
}
