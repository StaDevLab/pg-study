import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {

        // 이미 등장한 단어를 저장할 HashSet
        Set<String> history = new HashSet<>();
        history.add(words[0]); // 첫 단어는 바로 추가

        // 두 번째 단어부터 검사 시작
        for (int i = 1; i < words.length; i++) {
            String before = words[i - 1];   // 이전 단어
            String now = words[i];          // 현재 단어

            // 규칙 위반 조건:
            // 1. 이미 나온 단어인지 확인
            // 2. 끝말잇기 규칙 위반 여부 확인
            boolean duplicate = history.contains(now);
            boolean ruleBreak = before.charAt(before.length() - 1) != now.charAt(0);

            if (duplicate || ruleBreak) {
                int player = (i % n) + 1;   // 몇 번째 사람인지
                int round = (i / n) + 1;    // 몇 번째 차례인지
                return new int[]{player, round}; // 위반 결과 반환
            }

            // 규칙 위반이 없으면 현재 단어를 기록
            history.add(now);
        }

        // 끝까지 규칙 위반이 없으면 [0, 0] 반환
        return new int[]{0, 0};
    }
}