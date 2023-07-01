package coridingtest;

public class 카펫 {
    public static void main(String[] args) {

    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        for (int i = 3; i < total/2; i++) {
            int w = i-2;
            int h = total/i - 2;
            if (w*h == yellow) {
                answer[0] = w;
                answer[1] = h;
            }
        }
        return answer;
    }
}
