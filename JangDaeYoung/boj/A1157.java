package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 단어공부
 */
public class A1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toUpperCase().toCharArray();
        int[] arr = new int[26];

        for (int i = 0; i < s.length; i++) {
            int tmp = s[i] - 'A';
            arr[tmp]++;
        }

        int max = Arrays.stream(arr).max().getAsInt();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                list.add((char)('A' + i));
            }
        }

        if (list.size() > 1) {
            System.out.println("?");
        } else {
            System.out.println(list.get(0));
        }
    }

}
