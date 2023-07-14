package coridingtest;

import java.util.LinkedList;
import java.util.Queue;

public class 두_큐_합_같게_만들기 {

    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            sum1 += queue1[i];
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }
        while(sum1 != sum2) {
            if(answer > (queue1.length + queue2.length) * 2)
                return -1;
            int val;
            if(sum1 < sum2) {
                val = q2.poll();
                q1.add(val);
                sum1 += val;
                sum2 -= val;
            }
            else {
                val = q1.poll();
                q2.add(val);
                sum1 -= val;
                sum2 += val;
            }
            answer++;
        }
        return answer;
    }
}
