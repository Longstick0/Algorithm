package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 소수의 연속합
 */
public class A1644 {

    static ArrayList<Integer> primeList = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        getPrime();
        int left = 0, right = 0;
        int ans = 0, sum = 2;
        int size = primeList.size();

        while(left < size && right < size) {
            if(sum == N) {
                ans++;
                sum -= primeList.get(left);
                left++;
            }
            else if(sum > N) {
                sum -= primeList.get(left);
                left++;
            }else {
                right++;
                if(right >= size) break;
                sum += primeList.get(right);
            }
        }

        System.out.println(ans);
    }

    public static void getPrime() {
        int temp[] = new int[N+1];
        int rootN = (int)Math.sqrt(N);
        for(int i=2; i<=N; i++) {
            temp[i] = i;
        }
        for(int i=2; i<=rootN; i++) {
            if(temp[i] != 0 ) {
                for(int j=i+i; j<=N; j+=i) {
                    temp[j] = 0;
                }
            }
        }
        for(int i=2; i<=N; i++) {
            if(temp[i] != 0) {
                //System.out.println(temp[i]); 디버깅용
                primeList.add(temp[i]);
            }
        }
    }
}
