package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 덩치
 */
public class A7568 {

    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        size = Integer.parseInt(br.readLine());

        int[] weight = new int[size];
        int[] height = new int[size];
        int[] rank = new int[size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            height[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < size; i++) {
            int cnt = 1;
            for (int j = 0; j < size; j++) {
                if(i == j) continue;

                if(weight[i] < weight[j] && height[i] < height[j]) {
                    cnt += 1;
                }
            }
            rank[i] = cnt;
        }

        for (int i = 0; i < size; i++) {
            System.out.print(rank[i] + " ");
        }
    }
}
