package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * 수리공 항승
 */
public class A1449 {

    static int size;
    static int tapeSize;
    static int result = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        tapeSize = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int point = arr[0];

        for (int i = 1; i < size; i++) {
            if (point + tapeSize <= arr[i]) {
                result++;
                if (i == size - 1) {
                    break;
                }
                point = arr[i];
            }
        }
        out.println(result);
    }

}
