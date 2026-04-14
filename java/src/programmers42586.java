import java.util.*;
public class programmers42586 {


    public static void main(String[] args) {
        System.out.println(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}));
    }
 
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
             q.offer((int)Math.ceil((double)(100 - progresses[i]) / speeds[i]));
        }
        
        List<Integer> list = new ArrayList<>();
        int standard = q.poll();
        int count = 1;
        while (!q.isEmpty()) {
            int day = q.poll();
            if (day <= standard) {
                count++;
            } else {
                list.add(count);
                count = 1;
                standard = day;
            }
        }
        list.add(count);
        
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }

}
