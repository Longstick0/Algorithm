package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.out;

/**
 * 색종이
 */
public class A2563 {

    public static int solution() throws IOException {
        boolean[][] paper = new boolean[101][101];
        int result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfPaper = Integer.parseInt(br.readLine());

        for (int i = 0; i < numberOfPaper; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int bottom = Integer.parseInt(st.nextToken());
            for (int j = left; j < left + 10; j++) {
                for (int k = bottom; k < bottom + 10; k++) {
                    paper[j][k] = true;
                }
            }
        }
        for (boolean[] booleans : paper) {
            for (boolean aBoolean : booleans)
                if (aBoolean) {
                    result++;
                }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        out.println(solution());
    }

}
