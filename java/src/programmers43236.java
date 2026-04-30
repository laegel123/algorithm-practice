import java.util.Arrays;

public class programmers43236 {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        
        int low = 1;
        int high = distance;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            int count = 0;
            int before = 0;
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - before < mid) {
                    count++;
                } else {
                    before = rocks[i];
                }
            }
            
            if (distance - before < mid) count++;
            
            if (count > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
                answer = mid;
            }   
        }
        
        return answer;
    }
}
