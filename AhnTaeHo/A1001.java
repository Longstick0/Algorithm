package study.백준;

import java.util.Scanner;

import static java.lang.System.*;

public class A1001 {
    static int f, g;

    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        f = sc.nextInt();
        g = sc.nextInt();

        if (f > g) {
            out.println(">");
        } else if (f < g) {
            out.println("<");
        } else out.println("==");
    }
}
