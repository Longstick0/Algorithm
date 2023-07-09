package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.out;

/**
 * ATM
 */
public class A11399 {

    static int size;
    static int result = 0;

    public static void solution() {
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int temp = 0;
        for (int i : arr) {
            temp += i;
            result += temp;
        }
        out.println(result);
    }

}
