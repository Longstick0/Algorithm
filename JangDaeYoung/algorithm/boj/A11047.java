package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 동전 0
 */
public class A11047 {

    static int n;
    static int price;
    static ArrayList<Integer> arr = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        price = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            if (price < value) {
                break;
            }
            arr.add(value);
        }

        for (int i = arr.size() - 1; i >= 0; i--) {
            Integer value = arr.get(i);
            result += price / value;
            price = price % value;
        }
        System.out.println(result);

    }
}
