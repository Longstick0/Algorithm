package boj;

import java.util.Scanner;

public class TooEasy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime(in.nextInt())) {
                answer++;
            }
        }

        System.out.println(answer);

    }

    private static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        } else if (number == 2) {
            return true;
        }

        for (int i = 2 ; i < Math.sqrt(number) + 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
