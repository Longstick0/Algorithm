package boj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class boj1920 {
    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            map.put(in.nextInt(), 1);
        }

        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int input = in.nextInt();
            System.out.println(map.getOrDefault(input, 0));
        }
    }
}
