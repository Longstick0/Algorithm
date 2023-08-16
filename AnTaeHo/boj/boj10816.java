package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> hash = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            hash.merge(input, 1, Integer::sum);
        }


        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int input = Integer.parseInt(st.nextToken());
            if(hash.get(input) == null) sb.append(0).append(" ");
            else sb.append(hash.get(input)).append(" ");
        }
        System.out.println(sb);
    }
}
