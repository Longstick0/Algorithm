package coridingtest;

import java.util.HashSet;

public class 소수_찾기 {
    static HashSet<Integer> set = new HashSet<>();
    static char[] arr;
    static boolean[] visited;

    public int solution(String numbers) {
        arr = new char[numbers.length()];
        visited = new boolean[numbers.length()];
        for(int i=0; i<numbers.length(); i++){
            arr[i] = numbers.charAt(i);
        }
        recursion("",0);
        return set.size();
    }

    public void recursion(String str, int idx){
        int num;
        if(!str.equals("")){
            num = Integer.parseInt(str);
            if(isPrime(num)) set.add(num);
        }
        if(idx==arr.length) return;
        for(int i=0;i<arr.length;i++){
            if(visited[i]) continue;
            visited[i] = true;
            recursion(str+arr[i], idx+1);
            visited[i] = false;
        }
    }

    public boolean isPrime(int num){
        if(num==0||num==1) return false;
        for(int i=2; i*i<=num;i++){
            if(num%i==0) return false;
        }
        return true;
    }
}
