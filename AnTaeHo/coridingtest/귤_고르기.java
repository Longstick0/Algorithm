package coridingtest;

import java.util.*;

public class 귤_고르기 {
    public static void main(String[] args) {
        int solution = solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
        System.out.println("solution = " + solution);
    }

    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : tangerine) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        for(int i : keySet) {
            k -= map.get(i);
            answer++;
            if(k <= 0) return answer;
        }
        return answer;
    }
}
