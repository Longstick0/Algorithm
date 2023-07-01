package coridingtest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class 최솟값_만들기 {
    public static void main(String[] args) {

    }

    public int solution(int[] A, int[] B) {
        int answer = 0;
        int length = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < length; i++) {
            answer += A[i]*B[length - i - 1];
        }
        return answer;
    }
}
