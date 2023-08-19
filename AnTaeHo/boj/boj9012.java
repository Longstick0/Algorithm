package boj;

import java.util.Scanner;
import java.util.Stack;

public class boj9012 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String next = in.next();
            if (checkVPS(next)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean checkVPS(String next) {
        Stack<String> stack = new Stack<>();
        String[] split = next.split("");
        stack.push("");
        for (String s : split) {
            if (s.equals("(")) {
                stack.push(s);
            } else {
                if (stack.peek().equals("(")) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        stack.pop();
        return stack.isEmpty();
    }
}
