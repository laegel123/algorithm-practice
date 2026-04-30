import java.util.Arrays;

public class programmers43238 {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long low = times[0];
        long high = (long) times[times.length - 1] * n;
        
        while (low <= high) {
            long processTime = 0;
            long mid = (low + high) / 2;
            
            for (int time : times) {
                processTime += mid / time;
                
                if (processTime >= n) break;
            }
            
            if (processTime >= n) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return answer;
    }
}
