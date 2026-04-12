import java.util.*;

class Solution {
    public int solution(String[][] clothes) {

        // 의상 종류 및 몇개인지 파악 * 이름은 필요없음
        HashMap<String, Integer> cabinets = new HashMap<>();

        // 의상 종류 별로 추출 후 갯수 증가
        for (int i = 0; i < clothes.length; i++) {
            cabinets.put(clothes[i][1], cabinets.getOrDefault(clothes[i][1], 0) + 1);
        }

        // 반환 값
        int answer = 1;

        // 각 의상 종류의 갯수에 + 1씩 더하고 모두 곱하면 나올 수 있는 모든 경우의 수가 나온다.
        for (Map.Entry<String, Integer> entry : cabinets.entrySet()) {
            answer = answer * (entry.getValue() + 1);
        }

        // 아예 안 입은 경우는 없으므로 - 1 후 반환
        return answer - 1;
    }
}