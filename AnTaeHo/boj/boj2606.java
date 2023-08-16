package boj;

import java.util.Scanner;

public class boj2606 {
    static int[][] map;
    static boolean[] visit;
    static int n, m, v;
    static int count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        v = 1;
        map = new int[n+1][n+1];
        visit = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            map[a][b] = map[b][a] = 1;
        }

        System.out.println(dfs(1));
        in.close();
    }

    private static int dfs(int i) {
        visit[i] = true;

        for (int j = 1; j <= n; j++) {
            if (map[i][j] == 1 && !visit[j]) {
                count++;
                dfs(j);
            }
        }
        return count;
    }
}
