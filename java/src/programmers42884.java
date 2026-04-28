import java.util.Arrays;

public class programmers42884 {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        int camera = Integer.MIN_VALUE;
        int count = 0;
        
        for (int[] route : routes) {
            if (route[0] > camera) {
                count++;
                camera = route[1];
            }
        }
        
        return count;
    }
}
