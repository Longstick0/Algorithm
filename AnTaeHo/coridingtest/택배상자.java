package coridingtest;

import java.util.Stack;

public class 택배상자 {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> subLine = new Stack<>();
        int currnetBox = 1;
        for (int e : order) {
            while(currnetBox <= order.length) {
                if (currnetBox == e) {
                    break;
                } else if (!subLine.isEmpty() && subLine.peek() == e) {
                    break;
                } else {
                    subLine.push(currnetBox);
                    currnetBox++;
                }
            }
            if (currnetBox == e) {
                currnetBox++;
                answer++;
            } else if (!subLine.isEmpty() && subLine.peek() == e) {
                subLine.pop();
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}
