package boj;

import java.util.Scanner;
import java.util.Stack;

public class boj10773 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int input = in.nextInt();
            if (input == 0) {
                stack.pop();
            } else {
                stack.push(input);
            }
        }
        int sum = 0;

        for(int o : stack) {
            sum += o;
        }
        System.out.println(sum);
    }
}
