package boj;

import java.util.Scanner;

public class boj1037 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int input = in.nextInt();
            if (input > max) {
                max = input;
            }
            if (input < min) {
                min = input;
            }
        }

        System.out.println(min*max);
    }
}
