package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 유기농 배추
 */
public class A1012 {

    static int width;
    static int length;
    static int cabbageCount;
    static int[][] board;

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testSize = Integer.parseInt(br.readLine());

        for (int i = 0; i < testSize; i++) {
            int result = 0;
            st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            length = Integer.parseInt(st.nextToken());
            board = new int[length][width];
            cabbageCount = Integer.parseInt(st.nextToken());

            for (int j = 0; j < cabbageCount; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[y][x] = 1;
            }
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < width; k++) {
                    if (board[j][k] == 1) {
                        result++;
                        BFS(new Point(k, j));
                    }
                }
            }
            System.out.println(result);
        }
    }

    public static void BFS(Point point) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= width || nextY >= length) continue;
                if (board[nextY][nextX] == 0) continue;

                board[nextY][nextX] = 0;
                queue.add(new Point(nextX, nextY));
            }
        }
    }
}
