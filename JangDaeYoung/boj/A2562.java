package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * 최댓값
 */
public class A2562 {
    public static void solution() {
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        Integer max = Collections.max(arr);
        out.println(max);
        int count = 0;
        for (Integer integer : arr) {
            count++;
            if (max.equals(integer)) {
                out.println(count);
            }
        }
    }

}
