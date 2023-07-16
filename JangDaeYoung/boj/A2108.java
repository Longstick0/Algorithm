package boj;

import java.io.*;
import java.util.*;

/**
 * 통계학
 */
public class A2108 {

    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        //산술평균
        int avg = (int) Math.round(list.stream()
                .mapToInt(a -> a)
                .average().orElse(0));
        
        //중앙값
        Collections.sort(list);
        Integer middleValue = list.get(size / 2);

        //최빈값
        int maxFrequency;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer integer : list) {
            map.put(integer, map.getOrDefault(integer, 0) + 1);
        }
        Integer max = Collections.max(map.values());
        List<Integer> keyList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(max)) {
                keyList.add(entry.getKey());
            }
        }
        Collections.sort(keyList);
        if (keyList.size() > 1) {
            maxFrequency = keyList.get(1);
        } else maxFrequency = keyList.get(0);

        //범위
        int range = list.get(size - 1) - list.get(0);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(avg + "\n");
        bw.write(middleValue + "\n");
        bw.write(maxFrequency + "\n");
        bw.write(range + "\n");
        bw.flush();
        bw.close();

    }
}
