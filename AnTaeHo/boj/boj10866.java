package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;

public class boj10866 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            String[] s = br.readLine().split(" ");

            switch (s[0]) {
                case "push_front" -> {
                    dq.addFirst(Integer.parseInt(s[1]));
                }
                case "push_back" -> {
                    dq.addLast(Integer.parseInt(s[1]));
                }
                case "pop_front" -> {
                    if (dq.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(dq.pollFirst()).append('\n');
                    }
                }
                case "pop_back" -> {
                    if (dq.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(dq.pollLast()).append('\n');
                    }
                }
                case "size" -> {
                    sb.append(dq.size()).append('\n');
                }
                case "empty" -> {
                    if (dq.isEmpty()) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                }
                case "front" -> {
                    if (dq.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(dq.peekFirst()).append('\n');
                    }
                }
                case "back" -> {
                    if (dq.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(dq.peekLast()).append('\n');
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
