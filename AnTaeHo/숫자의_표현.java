public class 숫자의_표현 {

    public static void main(String[] args) {

    }

    public int solution(int n) {
        int answer = 1;
        int pin = 1;
        while(pin != n) {
            int nextPin = checkNextPin(pin, n);
            if (nextPin != 0) {
                answer++;
            }
            pin++;
        }
        return answer;
    }

    private int checkNextPin(int pin, int n) {
        for (int i = pin; i <= n; i++) {
            n -= i;
            if (n == 0) {
                return i;
            }
        }
        return 0;
    }
}
