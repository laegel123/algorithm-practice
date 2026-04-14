
/*
https://school.programmers.co.kr/learn/courses/30/lessons/42583
 */

import java.util.LinkedList;
import java.util.Queue;

public class programmers42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {       
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            q.offer(0);
        }
        int time = 0;
        int truckCount = 0;
        int currentWeight = 0;
        
        while (truckCount < truck_weights.length) {
            time++;
            currentWeight -= q.poll();
            
            if (currentWeight + truck_weights[truckCount] <= weight) {
                q.offer(truck_weights[truckCount]);
                currentWeight += truck_weights[truckCount];
                truckCount++;
            } else {
                q.offer(0);
            }
            
            
        }
        
        return time + bridge_length;
    }
}
