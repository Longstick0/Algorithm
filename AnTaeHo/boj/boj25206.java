package boj;

import java.util.Scanner;

public class boj25206 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double aa = 0;
        double point = 0;

        for (int i = 0; i < 20; i++) {
            String title = scanner.next();
            double a = scanner.nextDouble();
            String b = scanner.next();
            switch (b) {
                case "A+" -> {
                    aa += a * 4.5;
                    point += a;
                }
                case "A0" -> {
                    aa += a * 4.0;
                    point += a;
                }
                case "B+" -> {
                    aa += a * 3.5;
                    point += a;
                }
                case "B0" -> {
                    aa += a * 3.0;
                    point += a;
                }
                case "C+" -> {
                    aa += a * 2.5;
                    point += a;
                }
                case "C0" -> {
                    aa += a * 2.0;
                    point += a;
                }
                case "D+" -> {
                    aa += a * 1.5;
                    point += a;
                }
                case "D0" -> {
                    aa += a;
                    point += a;
                }
                case "F" -> {
                    aa += a * 0.0;
                    point += a;
                }
            }
        }

        System.out.printf("%.6f", aa / point);
    }
}
