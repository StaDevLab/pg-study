import java.util.*;

class Solution {
    public int solution(String[][] clothes) {

        Map<String, Integer> map = new HashMap<>();

        // 종류별 개수 갱신
        for (String[] cloth : clothes) {
            String type = cloth[1];

            if (map.containsKey(type)) {
                // 이미 해당 종류가 있으면 기존 값 꺼내서 +1
                int currentCount = map.get(type);
                map.put(type, currentCount + 1);
            } else {
                // 없으면 새로 1로 초기화
                map.put(type, 1);
            }
        }

        int answer = 1;

        // 경우의 수 계산
        for (int count : map.values()) {
            answer *= (count + 1); // (입는 경우 + 안 입는 경우)
        }

        return answer - 1; // 아무것도 안 입는 경우 제외
    }
}