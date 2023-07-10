package coridingtest;

public class k진수에서_소수_개수_구하기 {

    public int solution(int n, int k) {
        int count = 0;
        String string = Integer.toString(n, k);
        String[] split = string.split("0");
        if (split.length == 0) {
            return 0;
        }
        for (String s : split) {
            if (s.equals("")) {
                continue;
            }
            count += checkPrime(Long.parseLong(s));
        }
        return count;
    }

    private int checkPrime(long s) {
        if(s < 2) return 0;
        for(int i=2;i<=Math.sqrt(s);i++){
            if(s % i==0){
                return 0;
            }
        }
        return 1;
    }

}
