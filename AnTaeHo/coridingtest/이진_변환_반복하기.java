package coridingtest;

public class 이진_변환_반복하기 {
    public static void main(String[] args) {

    }

    int count = 0;
    int zeroCount = 0;

    public int[] solution(String s) {
        int[] answer = new int[2];
        while(!s.equals("1")) {
            String stepOne = removeZero(s);
            s = Integer.toBinaryString(stepOne.length());
            count++;
        }
        answer[0] = count;
        answer[1] = zeroCount;
        return answer;
    }

    private String removeZero(String input) {
        StringBuilder result = new StringBuilder();
        String[] split = input.split("");
        for (String s : split) {
            if (s.equals("0")) {
                zeroCount++;
            }
            if (s.equals("1")) {
                result.append(s);
            }
        }
        return result.toString();
    }
}
