package coridingtest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 신고_결과_받기 {

    public static void main(String[] args) {

    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> reportList = new HashMap<>();
        Map<String, Integer> reportResult = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            reportList.put(name, new HashSet<>());
            reportResult.put(name, i);
        }
        for (String s : report) {
            String[] split = s.split(" ");
            String from = split[0];
            String to = split[1];
            reportList.get(to).add(from);
        }
        for (String s : id_list) {
            HashSet<String> send = reportList.get(s);
            if (send.size() >= k) {
                for (String name : send) {
                    answer[reportResult.get(name)]++;
                }
            }
        }
        return answer;
    }
}
