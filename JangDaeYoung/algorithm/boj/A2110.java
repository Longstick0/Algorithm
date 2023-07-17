package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.out;

/**
 * 공유기 설치
 */
public class A2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int length = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int lt = 1;
        int rt = arr[length - 1];

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int result = getCount(mid, arr);

            if (result >= distance) {
                answer = result;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        out.println(answer);
    }

    public static int getCount(int mid, int[] arr) {
        int count = 1;
        int endPoint = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int gap = arr[i] - endPoint;
            if (gap >= mid) {
                endPoint = arr[i];
                count++;
            }
        }
        return count;
    }
}
