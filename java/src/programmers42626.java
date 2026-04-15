public class programmers42626 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for (int n : scoville) {
            p.offer(n);
        }
        
        int count = 0;
        while (p.size() > 1) {
            if (p.peek() >= K) return count;
            
            int x = p.poll();
            int y = p.poll();
            int newScoville = x + (y * 2);
            p.offer(newScoville);
            count++;
        }
        
        
        return p.peek() >= K ? count : -1;
    }
}