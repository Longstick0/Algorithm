package coridingtest;

import java.util.Stack;

public class 짝지어_제거하기 {
    public static void main(String[] args) {

    }

    public int solution(String s) {
        String[] split = s.split("");
        Stack<String> stack = new Stack<>();
        for (String s1 : split) {
            if (!stack.isEmpty() && stack.peek().equals(s1)) {
                stack.pop();
            } else {
                stack.push(s1);
            }
        }
        return stack.empty() ? 1 : 0;
    }
}
