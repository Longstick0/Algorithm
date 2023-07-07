package coridingtest;

public class N개의_최소공배수 {

    public static void main(String[] args) {

    }

    public int solution(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int now = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int gcd = gcd(now, arr[i]);
            now = (now * arr[i])/gcd;
        }
        return now;
    }

    private int gcd(int a, int b) {
        int r = a % b;
        if(r == 0) return b;
        else return gcd(b, r);
    }
}
