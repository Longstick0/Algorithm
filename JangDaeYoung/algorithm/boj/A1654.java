package algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 랜선 자르기
 */
public class A1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];

        long max = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        max++;
        long min = 0;
        long mid;
        while (min < max) {
            mid = (max + min) / 2;
            long count = 0;
            for (int j : arr) {
                count += (j / mid);
            }
            if(count < N) {
                max = mid;
            }
            else {
                min = mid + 1;
            }


        }
        System.out.println(min - 1);
    }
}