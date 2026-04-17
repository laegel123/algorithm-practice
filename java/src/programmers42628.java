import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class programmers42628 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pqRv = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();
        
        for (String operation : operations) {
            String[] split = operation.split(" ");
            String cmd = split[0];
            int num = Integer.parseInt(split[1]);
            if (cmd.equals("I")) {
                pq.offer(num);
                pqRv.offer(num);
                map.put(num, map.getOrDefault(split[1], 0) + 1);
            } else {
                if (num == -1) {
                    clean(pq, map);
                    if (!pq.isEmpty()) {
                        int min = pq.poll();
                        map.put(min, map.get(min) - 1);
                        if (map.get(min) == 0) map.remove(min);
                    }
                } else {
                    clean(pqRv, map);
                    if (!pqRv.isEmpty()) {
                        int max = pqRv.poll();
                        map.put(max, map.get(max) - 1);
                        if (map.get(max) == 0) map.remove(max);
                    }
                }
            }
        }
        clean(pq, map);
        clean(pqRv, map);
        if (pq.isEmpty() || pqRv.isEmpty()) return new int[]{0, 0};
        
        return new int[]{pqRv.peek(), pq.peek()};
    }
    
    public void clean(PriorityQueue<Integer> pq, Map<Integer, Integer> map) {
        while (!pq.isEmpty() && map.getOrDefault(pq.peek(), 0) == 0) {
            pq.poll();
        }
    }
}