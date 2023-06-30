public class JadenCase_문자열_만들기 {
    public static void main(String[] args) {

    }

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] arr = s.split(" ");
        for (String now : arr) {
            if (now.length() == 0) {
                answer.append(" ");
            }
            else {
                answer.append(now.substring(0, 1).toUpperCase());
                answer.append(now.substring(1).toLowerCase());
                answer.append(" ");
            }
        }
        if(s.charAt(s.length() - 1) == ' '){
            return answer.toString();
        }
        return answer.substring(0, answer.length()-1);
    }
}
