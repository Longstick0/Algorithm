package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 팩토리얼 0의 개수
 */
public class A1676 {

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        for (int i = 1; i <= input; i++) {
            int num = i;
            while (num > 0) {
                if (num % 5 == 0) {
                    result++;
                    num /= 5;
                } else break;
            }
        }
        System.out.println(result);
    }
}
