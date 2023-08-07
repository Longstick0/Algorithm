package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구간합
 */
public class A11659 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        arr = new int[size + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= size; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int lt = Integer.parseInt(st.nextToken());
            int rt = Integer.parseInt(st.nextToken());
            System.out.println(arr[rt]-arr[lt-1]);
        }

    }
}
