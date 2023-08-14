package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj11399 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        int total = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int input = in.nextInt();
            list.add(input);
            sum += input;
        }
        list.sort(Collections.reverseOrder());

        for (Integer i : list) {
            total += sum;
            sum -= i;
        }

        System.out.println(total);

    }
}
