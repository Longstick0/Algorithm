package algorithm.boj;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 나는야 포켓몬 마스터 이다솜
 */
public class A1620 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int dogamSize = Integer.parseInt(st.nextToken());
        int testSize = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> dogam = new HashMap<>();
        String[] dogam2 = new String[dogamSize + 1];

        for (int i = 1; i <= dogamSize; i++) {
            String line = br.readLine();
            dogam.put(line, i);
            dogam2[i] = line;
        }
        for (int i = 0; i < testSize; i++) {
            String line = br.readLine();
            if (Character.isDigit(line.charAt(0))) {
                bw.write(dogam2[Integer.parseInt(line)] + "\n");
            } else {
                bw.write(dogam.get(line) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
