/*
https://school.programmers.co.kr/learn/courses/30/lessons/42584
 */

import java.util.Stack;

public class programmers42584 {
    public int[] solution(int[] prices) {
        int[] answer = {};
        int n = prices.length;
        answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = n - 1 - idx;
        }
        
        return answer;
    }
}
