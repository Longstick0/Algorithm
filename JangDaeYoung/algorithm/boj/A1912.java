package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 연속합
 */
public class A1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        for (int i = 0; i < n - 1; i++) {
            int temp = dp[i] + arr[i + 1];
            if (temp > arr[i + 1]) {
                dp[i + 1] = temp;
            } else {
                dp[i + 1] = arr[i + 1];
            }
        }
        int result = Arrays.stream(dp).max().getAsInt();
        System.out.println(result);
    }
}
