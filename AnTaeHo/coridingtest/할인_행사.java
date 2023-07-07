package coridingtest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class 할인_행사 {
    public static void main(String[] args) {

    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int days = 10;
        Map<String, Integer> wishList = new TreeMap<>();
        for (int i = 0; i < want.length; i++) {
            wishList.put(want[i], number[i]);
        }
        for(int i = 0; i < discount.length - days + 1; i++){
            Map<String, Integer> dMap = new HashMap<>();
            for(int j = 0; j < days; j++){
                dMap.put(discount[i + j], dMap.getOrDefault(discount[i + j], 0) + 1);
            }
            boolean isIdentical = true;
            for(String key : wishList.keySet()){
                if(wishList.get(key) != dMap.get(key)){
                    isIdentical = false;
                    break;
                }
            }
            answer += isIdentical ? 1 : 0;
        }
        return answer;
    }

    private int checkWish(Map<String, Integer> wishList, Map<String, Integer> discountList) {
        Set<String> strings = wishList.keySet();
        for (String string : strings) {
            if (discountList.get(string) <= wishList.get(string)) {
                return 0;
            }
        }
        return 1;
    }
}
