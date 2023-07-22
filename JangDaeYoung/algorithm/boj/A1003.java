package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 피보나치 함수
 */
public class A1003 {

    static int[][] arr;
    static int[] numArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        arr = new int[2][40 + 1];
        numArr = new int[size];

        for (int i = 0; i < size; i++) {
            numArr[i] = Integer.parseInt(br.readLine());
        }
        int max = Arrays.stream(numArr).max().getAsInt();
        fibo(max);

        print(numArr);
    }

    public static void print(int[] numArr) {
        for (int i : numArr) {
            System.out.println(arr[0][i] + " " + arr[1][i]);
        }
    }

    public static void fibo(int num) {
        arr[0][0] = 1;
        arr[1][0] = 0;
        arr[0][1] = 0;
        arr[1][1] = 1;

        for (int i = 2; i <= num; i++) {
            arr[0][i] = arr[0][i - 2] + arr[0][i - 1];
            arr[1][i] = arr[1][i - 2] + arr[1][i - 1];
        }
    }
}
