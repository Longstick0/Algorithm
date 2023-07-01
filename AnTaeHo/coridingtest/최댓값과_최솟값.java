package coridingtest;

import java.util.ArrayList;
import java.util.Collections;

public class 최댓값과_최솟값 {
    public static void main(String[] args) {

    }

    public String solution(String s) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        String[] str = s.split(" ");

        for (String value : str) {
            arr.add(Integer.parseInt(value));
        }

        return Collections.min(arr) + " " + Collections.max(arr);
    }
}
