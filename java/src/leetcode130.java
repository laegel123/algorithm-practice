public class leetcode130 {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && board[i][j] == 'O' &&  (i == 0 || i == n -1 || j == m - 1 || j == 0)) dfs(board, visited, i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'L') board[i][j] = 'O';
            }
        }

    }

    public void dfs(char[][] board, boolean[][] visited, int x, int y) {
        board[x][y] = 'L';
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) continue;
            if (visited[nx][ny] || board[nx][ny] == 'X') continue;

            dfs(board, visited, nx, ny);
        }
    }
}
