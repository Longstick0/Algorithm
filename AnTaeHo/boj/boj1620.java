package boj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class boj1620 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        for (int i = 0; i < n; i++) {
            String next = in.next();
            map.put(i+1, next);
            map2.put(next, i+1);
        }

        for (int j = 0; j < m; j++) {
            String next = in.next();
            try {
                int i = Integer.parseInt(next);
                System.out.println(map.get(i));
            } catch (NumberFormatException e) {
                System.out.println(map2.get(next));
            }
        }
    }
}
