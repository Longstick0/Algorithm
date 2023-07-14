package coridingtest;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        Queue<Integer> bridge = new LinkedList<>();
        for (int truck : truck_weights) {
            while(true) {
                if(bridge.isEmpty()) {
                    bridge.offer(truck);
                    sum += truck;
                    answer++;
                    break;
                } else if(bridge.size() == bridge_length) {
                    sum -= bridge.poll();
                } else {
                    if(sum + truck > weight) {
                        bridge.offer(0);
                        answer++;
                    }
                    else {
                        bridge.offer(truck);
                        sum += truck;
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer + bridge_length;
    }
}
