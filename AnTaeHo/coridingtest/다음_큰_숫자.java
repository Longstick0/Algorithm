package coridingtest;

public class 다음_큰_숫자 {
    public static void main(String[] args) {

    }

    public int solution(int n) {
        int oneCount = Integer.bitCount(n);
        while(true) {
            n++;
            if (oneCount == Integer.bitCount(n)) {
                return n;
            }
        }
    }
}
