public class programmers42860 {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int d = name.charAt(i) - 'A';
            count += Math.min(d, 26 - d);
        }
        
        int move = n - 1;
        
        for (int i = 0; i < n; i++) {
            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') next++;
            
            move = Math.min(move, 2 * i + (n - next));
            move = Math.min(move, 2 * (n - next) + i);
        }
        
        return count + move;
    }
}
