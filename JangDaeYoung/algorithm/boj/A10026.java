package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 적록색약
 */
public class A10026 {

    static class Point {
        public int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static char[][] map;
    static boolean[][] isVisited;
    static int count;

    public static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        isVisited[x][y] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(isVisited[nx][ny]) continue;
                if(map[nx][ny]!=map[point.x][point.y]) continue;
                queue.add(new Point(nx,ny));
                isVisited[nx][ny] = true;
//                if (!isVisited[nx][ny] && map[nx][ny]==map[point.x][point.y]){
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        isVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!isVisited[i][j]) {
                    BFS(i,j);
                    count++;
                }
            }
        }
        System.out.print(count + " ");
        count = 0;
        isVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] == 'G') map[i][j] ='R';
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!isVisited[i][j]) {
                    BFS(i,j);
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}
