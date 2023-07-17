package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 팰린드롬 수
 */
public class A1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String input = br.readLine();
            if(Integer.parseInt(input) == 0) break;

            String solve = solve(input);
            System.out.println(solve);
        }
    }
    private static String solve(String input){
        StringBuilder sb = new StringBuilder(input);
        String str = sb.reverse().toString();
        return input.equals(str) ? "yes" : "no";
    }
}
