package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 숨바꼭질
 */
public class A1697 {

    static int level = 0;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] dis = {-1, 1, 2};
    static int[] temp = new int[100001];

    public static int BFS(int N, int K) {
        queue.offer(N);
        temp[N] = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer num = queue.poll();
                for (int j = 0; j < 3; j++) {
                    int ny;
                    if (j == 2) {
                        ny = num * 2;
                    } else {
                        ny = num + dis[j];
                    }
                    if (ny == K) {
                        return level;
                    }
                    if (ny >= 0 && ny <= 100000 && temp[ny] == 0) {
                        temp[ny] = 1;
                        queue.offer(ny);
                    }
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if (N == K) {
            System.out.println(0);
            return;
        }
        System.out.println(BFS(N, K) + 1);
    }
}
