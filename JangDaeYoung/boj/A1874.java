package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 스택 수열
 */
public class A1874 {

    static ArrayList<Character> result = new ArrayList<>();
    static Stack<Integer> stack = new Stack<>();
    static int[] inputArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        inputArr = new int[size + 1];

        int m = 1;

        for (int i = 1; i <= size; i++) {
            inputArr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= size; i++) {
            stack.push(i);
            result.add('+');
            while (!stack.empty() && stack.peek() == inputArr[m]) {
                stack.pop();
                result.add('-');
                m++;
            }
        }
        if (stack.empty()) {
            for (char s : result) {
                System.out.println(s);
            }
        } else {
            System.out.println("NO");
        }
    }
}
