import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class programmers84021 {
    class Point implements Comparable<Point> {
    int x;
    int y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) return this.y - o.y;
        return this.x - o.x;
    }
}

    int[] DX = {1, 0, -1, 0};
    int[] DY = {0, 1, 0, -1};
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        List<List<Point>> boards = countBlocks(game_board, 0);
        List<List<Point>> puzzles = countBlocks(table, 1);
        
        boolean[] visitedPuzzle = new boolean[puzzles.size()];
        
        
        for (List<Point> board : boards) {
            for (int i = 0; i < puzzles.size(); i++) {
                if (visitedPuzzle[i]) continue;
                
                List<Point> puzzle = puzzles.get(i);
                if (board.size() != puzzle.size()) continue;
                
                if (isMatch(board, puzzle)) {
                    visitedPuzzle[i] = true;
                    answer += board.size();
                    break;
                }
            }
        }
        
        return answer;
    }
    
    public List<List<Point>> countBlocks(int[][] maps, int target) {
        int n = maps.length;
        boolean[][] visited = new boolean[n][n];
        List<List<Point>> boards = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maps[i][j] == target && !visited[i][j]) {
                    boards.add(bfs(maps, visited, i, j, target));
                }
            }
        }
        
        return boards;
    }
    
    public List<Point> bfs(int[][] maps, boolean[][] visited, int x, int y, int target) {
        int n = maps.length;
        List<Point> block = new ArrayList<>();
        
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            Point now = q.poll();
            block.add(now);
            
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + DX[i];
                int nextY = now.y + DY[i];
                
                
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;
                if (visited[nextX][nextY] || maps[nextX][nextY] != target) continue;
                q.offer(new Point(nextX,nextY));
                visited[nextX][nextY] = true;
            }
        }
        
        return normalize(block);
    }
    
    public boolean isMatch(List<Point> board, List<Point> puzzle) {
        for (int r = 0; r < 4; r++) {
            puzzle = rotate(puzzle);
            
            if (board.size() == puzzle.size()) {
                boolean match = true;
                for (int i = 0; i < board.size(); i++) {
                    if (board.get(i).x != puzzle.get(i).x || board.get(i).y != puzzle.get(i).y) {
                        match = false;
                    }
                }
                
                if (match) return true;
            }
        }
        
        return false;
    }
    
    public List<Point> rotate(List<Point> block) {
        List<Point> rotated = new ArrayList<>();
        for (Point p : block) {
            rotated.add(new Point(p.y, -p.x));
        }
        
        return normalize(rotated);
    }
    
    public List<Point> normalize(List<Point> block) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        
        for (Point p : block) {
            minX = Math.min(minX, p.x);
            minY = Math.min(minY, p.y);
        }
        
        for (Point p : block) {
            p.x -= minX;
            p.y -= minY;
        }
        
        Collections.sort(block);
        return block;
    }
}
