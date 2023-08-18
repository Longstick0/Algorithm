package boj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class boj10814 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String[][] arr = new String[N][2];
        for(int i = 0; i < N; i++) {
            arr[i][0] = in.next();
            arr[i][1] = in.next();
        }
        Arrays.sort(arr, Comparator.comparingInt(s -> Integer.parseInt(s[0])));
        for(int i = 0; i < N; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
