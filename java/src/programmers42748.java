import java.util.Arrays;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42748
*/
public class programmers42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        
        answer = new int[commands.length];
        int idx = 0;
        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];
            int[] sort = new int[j - i + 1];
            for (int x = 0; x < sort.length; x++) {
                sort[x] = array[i - 1 + x];
            }
            
            Arrays.sort(sort);
            answer[idx++] = sort[k - 1];
        }
        
        return answer;
    }
}