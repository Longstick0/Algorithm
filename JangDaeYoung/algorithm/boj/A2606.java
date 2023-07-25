package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 바이러스
 */
public class A2606 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];
        int count = 0;
        boolean[] visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visit[1] = true;
        while (!queue.isEmpty()) {
            Integer temp = queue.poll();

            for (int i = 1; i <= n; i++) {
                if (arr[temp][i] == 1 && !visit[i]) {
                    queue.offer(i);
                    visit[i] = true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
