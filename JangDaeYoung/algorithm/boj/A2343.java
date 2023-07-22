package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 기타 레슨
 */
public class A2343 {
    public static void solution(int length, int m, int[] arr) {
        int hi = Arrays.stream(arr).sum();
        int low = Arrays.stream(arr).max().getAsInt();

        int result = 0;

        while (low <= hi) {
            int mid = (low + hi) / 2;

            if (count(arr, mid) < m) {
                hi = mid - 1;
            } else if (count(arr, mid) > m) {
                low = mid + 1;
            } else {
                result = mid;
                break;
            }
        }

        System.out.println(result);
    }

    public static int count(int[] arr, int mid) { //mid의 용량으로 CD를 몇 개 만들 수 있는지
        int temp = 0;
        int cnt = 0;
        for (int i : arr) {
            temp += i;
            if (temp >= mid) {
                cnt++;
                temp = 0;
                temp += i;
            }
        }
        if (temp > mid) return cnt - 1;
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[length];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution(length, m, arr);
    }

}
