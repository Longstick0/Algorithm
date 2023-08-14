package boj;

import java.util.*;

public class boj1764 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        int a = in.nextInt();
        int b = in.nextInt();

        for (int i = 0; i < a; i++) {
            map.put(in.next(), 1);
        }

        for (int i = 0; i < b; i++) {
            String next = in.next();
            if (map.containsKey(next)) {
                list.add(next);
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
