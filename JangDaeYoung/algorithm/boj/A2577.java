package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 숫자의 개수
 */
public class A2577 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        Integer calc = a * b * c;
        char[] charArray = String.valueOf(calc).toCharArray();
        int[] arr = new int[10];
        for (char ch : charArray) {
            int i = Integer.parseInt(String.valueOf(ch));
            arr[i]++;
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
