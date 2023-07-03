package coridingtest;

import java.util.Stack;

public class 영어_끝말잇기 {
    public static void main(String[] args) {

    }

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int i;
        int pin = 0;
        Stack<String> record = new Stack<>();
        record.push(words[0]);
        for (i = 1; i < words.length; i++) {
            String past = record.peek();
            String now = words[i];
            if (record.contains(now)) {
                pin = i;
                break;
            }
            if (past.charAt(past.length()-1) != now.charAt(0)) {
                pin = i;
                break;
            }
            record.push(now);
        }
        if (pin == 0) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = pin%n + 1;
            answer[1] = pin/n + 1;
        }
        return answer;
    }
}
