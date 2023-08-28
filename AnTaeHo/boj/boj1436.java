package boj;

import java.util.Scanner;

public class boj1436 {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();

        int num = 666;
        int count = 1;

        while(count != N) {
            num++;

            if(String.valueOf(num).contains("666")) {
                count++;
            }
        }
        System.out.println(num);
    }
}
