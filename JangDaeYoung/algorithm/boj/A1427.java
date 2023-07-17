package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * 소트인사이드
 */
public class A1427 {
    public static void solution() {
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            int digit = n % 10;
            list.add(digit);
            n /= 10;
        }
        Collections.sort(list);
        for (int i = list.size() - 1; i >= 0; i--) {
            out.print(list.get(i));
        }
    }

}
