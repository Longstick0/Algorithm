package boj;

import java.util.Scanner;

public class boj1929 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        boolean[] temp = new boolean[N+1];
        for (int i = M; i <= N; i++) {
            temp[i] = isPrime(i);
        }
        for (int i = M; i <= N; i++) {
            if (temp[i]) {
                System.out.println(i);
            }
        }
    }

    private static boolean isPrime(int number) {
        if (number == 1) {
            return true;
        }
        for (int i = 2; i < Math.sqrt(number) + 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
