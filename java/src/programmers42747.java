import java.util.Arrays;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42747
*/

public class programmers42747 {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);   

        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int h = n - i;
            
            if (citations[i] >= h) {
                return h;
            }
        }
        
        return answer;
    }
}
