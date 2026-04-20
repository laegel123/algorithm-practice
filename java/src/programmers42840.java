import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class programmers42840 {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] one = {1, 2, 3, 4, 5};
        int[] sec = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thr = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int oneCount = 0;
        int secCount = 0;
        int thrCount = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % one.length]) oneCount++;
            if (answers[i] == sec[i % sec.length]) secCount++;
            if (answers[i] == thr[i % thr.length]) thrCount++;
        }
        
        int max = Math.max(oneCount, Math.max(secCount, thrCount));
        
        List<Integer> list = new ArrayList<>();
        if (max == oneCount) {
            list.add(1);
        } 
        if (max == secCount) {
            list.add(2);
        } 
        if (max == thrCount) {
            list.add(3);
        }
        
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }    
}
