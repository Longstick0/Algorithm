package boj;

import java.util.Scanner;

//dp[n] = dp[n-1] + dp[n-2] + dp[n3]
public class boj9095 {
    static int[] dp = new int[11];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for(int i = 0; i < t; i++) {
            int n = in.nextInt();
            System.out.println(dp[n]);
        }
    }
}
