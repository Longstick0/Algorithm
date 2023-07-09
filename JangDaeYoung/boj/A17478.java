package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.out;

/**
 * 재귀함수가 뭔가요?
 */
public class A17478 {

    static String underBar = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recursive(n);
    }

    public static void recursive(int n) {
        String line = underBar;
        if (n == 0) {
            out.println(line + "\"재귀함수가 뭔가요?\"\n" +
                    line + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n" +
                    line + "라고 답변하였지.");
            return;
        }
        out.println(line + "\"재귀함수가 뭔가요?\"\n" +
                line + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" +
                line + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" +
                line + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
        underBar += "____";
        recursive(n - 1);
        out.println(line + "라고 답변하였지.");
    }

}
