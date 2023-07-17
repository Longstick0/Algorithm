package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * solved.ac
 */
public class A18110 {

    static int[] arr;
    static int cuttingAvg;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        cuttingAvg = Math.round((float) (size * 15) / 100);

        int sum = 0;

        for (int i = cuttingAvg; i < size - cuttingAvg; i++) {
            sum += arr[i];
        }
        int result = Math.round((float) sum / (size - (cuttingAvg * 2)));
        System.out.println(result);

    }
}
