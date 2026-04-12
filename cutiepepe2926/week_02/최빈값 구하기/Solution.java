import java.util.*;

class Solution {
    public int solution(int[] array) {

        // 최빈값이면 Map이 편리
        HashMap<Integer, Integer> cntNum = new HashMap<>();

        // 각 key 값 별로 +1씩 처리
        for (int a : array) {
            cntNum.put(a, cntNum.getOrDefault(a, 0) + 1);
        }

        // 최빈값 여러 개 체크용 변수
        int key = -1; // 최빈값
        int beando = -1; // 빈도 수
        boolean dup = false; // 여러 개 체크용

        // cntNum 순회 체크
        for (Map.Entry<Integer, Integer> entry : cntNum.entrySet()) {
            if (entry.getValue() > beando) {
                key = entry.getKey();
                beando = entry.getValue();
                dup = false;
            }
            else if (entry.getValue() == beando) {
                dup = true;
            }
            else {
                continue;
            }
        }

        if (dup) {
            return -1;
        }

        return key;

    }
}