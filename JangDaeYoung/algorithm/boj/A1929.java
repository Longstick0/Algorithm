package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 소수 구하기
 */
public class A1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[end + 1];

        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(end); i++) {
            if(prime[i]) continue;
            for (int j = i * i; j <= end; j += i) {
                prime[j] = true;
            }
        }
        for (int i = start; i <= end; i++) {
            if (!prime[i]) {
                System.out.println(i);
            }
        }

    }
}
