package coridingtest;

import java.util.ArrayList;
import java.util.Comparator;

public class 무인도_여행 {
    public static void main(String[] args) {

    }

    int cnt;

    public int[] solution(String[] maps) {
        int[] answer;

        int[][] foodMap = new int[maps.length][maps[0].length()];

        changeStringToIntMap(maps, foodMap);

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (foodMap[i][j] != 0) {
                    cnt = 0;
                    dfs(foodMap, i, j); //하나의 덩이리 탐색
                    list.add(cnt);
                }
            }
        }

        if(list.size() == 0) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            list.sort(Comparator.naturalOrder());
            answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++)
                answer[i] = list.get(i);
        }

        return answer;
    }

    private static void changeStringToIntMap(String[] maps, int[][] foodMap) {
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                foodMap[i][j] = maps[i].charAt(j) == 'X' ? 0 : Character.getNumericValue(maps[i].charAt(j));
            }
        }
    }

    public void dfs(int[][] foodMap, int r, int c) {
        //인덱스 범위 검사
        if (r < 0 || c < 0 || r >= foodMap.length || c >= foodMap[0].length)
            return;

        //바다 검사
        if (foodMap[r][c] == 0)
            return;

        //음식을 더해주고 0으로 초기화
        cnt += foodMap[r][c];
        foodMap[r][c] = 0;

        //4방향 탐색
        dfs(foodMap, r + 1, c);
        dfs(foodMap, r - 1, c);
        dfs(foodMap, r, c + 1);
        dfs(foodMap, r, c - 1);
    }
}
