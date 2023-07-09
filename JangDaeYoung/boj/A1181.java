package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * 단어 정렬
 */
public class A1181 {

    public static void solution() {
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            list.add(line);
        }
        list.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                return o1.length() - o2.length();
            }
        });
        for (String s : list) {
            if (!resultList.contains(s)) {
                resultList.add(s);
            }
        }
        for (String s : resultList) {
            out.println(s);
        }
    }

}
