package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * 제로
 */
public class A10773 {

    static LinkedList<Integer> list = new LinkedList<>();
    static int size;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                list.add(num);
            } else {
                list.remove(list.size() - 1);
            }
        }
        for (Integer integer : list) {
            result += integer;
        }
        System.out.println(result);

    }
}
