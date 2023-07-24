package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 쉬운 최단거리
 */
public class A14940 {

    static int[][] board;
    static int[][] dis;
    static boolean[][] isVisited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;

    static class Point {
        public int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        isVisited[x][y] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i <= 3; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(board[nx][ny] == 0) continue;
                if (isVisited[nx][ny]) continue;

                queue.add(new Point(nx, ny));
                dis[nx][ny] = dis[point.x][point.y] + 1;
                isVisited[nx][ny] = true;

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n + 1][m + 1];
        dis = new int[n][m];
        isVisited = new boolean[n][m];

        int initialPointX = 0;
        int initialPointY = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 2) {
                    initialPointX = i;
                    initialPointY = j;
                }
                board[i][j] = value;
            }
        }
        BFS(initialPointX, initialPointY);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (!isVisited[i][j] && board[i][j] == 1)
                    sb.append(-1 + " ");
                else
                    sb.append(dis[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
