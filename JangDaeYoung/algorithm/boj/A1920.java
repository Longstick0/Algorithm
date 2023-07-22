package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;

/**
 * 수 찾기
 */
public class A1920 {
    public static void solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        for (int j : arrayB) {
            if (binarySearch(arrayA, j) >= 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

        }
    }

    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int hi = arr.length - 1;

        while (low <= hi) {
            int mid = (low + hi) / 2;

            if (key < arr[mid]) {
                hi = mid - 1;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int sizeA = Integer.parseInt(br.readLine());
        int[] arrayA = new int[sizeA];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sizeA; i++) {
            arrayA[i] = Integer.parseInt(st.nextToken());
        }

        int sizeB = Integer.parseInt(br.readLine());
        int[] arrayB = new int[sizeB];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sizeB; i++) {
            arrayB[i] = Integer.parseInt(st.nextToken());
        }

        solution(arrayA, arrayB);
    }
}
