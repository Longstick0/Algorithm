package algorithm.boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 계단 오르기
 */
public class A2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[][] stairs = new int[2][size];

        stairs[0][0] = stairs[1][0] = Integer.parseInt(br.readLine());
        if (size == 1) {
            System.out.println(stairs[0][0]);
            return;
        } else if (size == 2) {
            System.out.println(stairs[0][0] + Integer.parseInt(br.readLine()));
            return;
        }
        int two = Integer.parseInt(br.readLine());
        stairs[0][1] = two;
        stairs[1][1] = two + stairs[0][0];

        for (int i = 2; i < size; i++) {
            int num = Integer.parseInt(br.readLine());
            stairs[0][i] = (stairs[0][i - 2] >= stairs[1][i - 2]) ? stairs[0][i - 2] + num : stairs[1][i - 2] + num;
            stairs[1][i] = stairs[0][i - 1] + num;
        }
        int i = Math.max(stairs[0][size - 1], stairs[1][size - 1]);
        System.out.println(i);
    }
}
