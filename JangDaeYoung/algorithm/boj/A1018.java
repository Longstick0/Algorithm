package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 체스판 다시 칠하기
 */
public class A1018 {
    static int M;
    static int N;
    static int result = Integer.MAX_VALUE;

    static char[] blackFirst = {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'};
    static char[] whiteFirst = {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B','W', 'B', 'W', 'B', 'W', 'B', 'W', 'B','W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'};
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new char[M][N];

        //배열 삽입
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < M - 7; i++) {
            for (int j = 0; j < N - 7; j++) {
                int findResult = find(i, j);
                if (result > findResult) {
                    result = findResult;
                }
            }
        }

        System.out.println(result);
    }

    public static int find(int x, int y) {
        int count = 0;
        char firstPoint = arr[x][y];

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (firstPoint == 'B') {
                    if (arr[i][j] != blackFirst[j]) {
                        count++;
                    }
                } else {
                    if (arr[i][j] != whiteFirst[j]) {
                        count++;
                    }
                }
            }
            if (firstPoint == 'B') {
                firstPoint = 'W';
            } else firstPoint = 'B';
        }
        return count;
    }
}
