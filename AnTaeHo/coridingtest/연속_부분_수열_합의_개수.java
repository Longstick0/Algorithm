package coridingtest;

import java.util.HashSet;
import java.util.Set;

public class 연속_부분_수열_합의_개수 {

    public static void main(String[] args) {

    }

    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int len = elements.length;
        for (int size = 1; size <= len; size++) {
            for (int i = 0; i < len; i++) {
                int sum = 0;
                for (int j = i; j < i + size; j++) {
                    sum += elements[j % len];
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}
