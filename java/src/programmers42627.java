import java.util.Arrays;
import java.util.PriorityQueue;
/*
https://school.programmers.co.kr/learn/courses/30/lessons/42627
*/
public class programmers42627 {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        
        int total = 0;
        int time = 0;
        int n = jobs.length;
        int idx = 0;
        
        while (idx < n || !pq.isEmpty()) {
            
            while (idx < n && jobs[idx][0] <= time) {
                pq.offer(jobs[idx]);
                idx++;
            }
            
            if (!pq.isEmpty()) {
                int[] now = pq.poll();
                time += now[1];
                
                total += time - now[0];
            } else {
                time = jobs[idx][0];
            }
        }
        
        return total / n;
    }
}
