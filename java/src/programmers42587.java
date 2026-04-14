import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class programmers42587 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{priorities[i], i});
        }
        
        int idx = priorities.length - 1;
        Arrays.sort(priorities);
        int order = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == priorities[idx]) {
                order++;
                idx--;
                if (now[1] == location) {
                    return order;
                }
            } else {
                q.offer(now);
            }   
        }
        
        return answer;
    }
}
