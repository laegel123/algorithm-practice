
/*
https://school.programmers.co.kr/learn/courses/30/lessons/42578
*/

import java.util.HashMap;

public class programmers42578 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }
        
        int answer = 1;
        for (String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }
            
        return answer - 1;
    }
}