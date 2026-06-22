import java.util.*;

class Solution {

    public int[] solution(String[] info, String[] query) {

        // 조건 조합별 점수 목록 저장
        Map<String, List<Integer>> map = new HashMap<>();

        // 모든 지원자 정보 순회
        for (String applicant : info) {

            // 정보 분리
            String[] parts = applicant.split(" ");

            // 점수 추출
            int score = Integer.parseInt(parts[4]);

            // 16가지 조건 조합 생성
            for (int mask = 0; mask < 16; mask++) {

                // 조건 키 생성
                StringBuilder key = new StringBuilder();

                // 언어, 직군, 경력, 음식 처리
                for (int i = 0; i < 4; i++) {

                    // 비트가 켜져 있으면 -
                    if ((mask & (1 << i)) != 0) {
                        key.append("-");
                    }
                    // 비트가 꺼져 있으면 실제 값
                    else {
                        key.append(parts[i]);
                    }

                    // 구분자 추가
                    key.append("#");
                }

                // 키가 없으면 생성 후 점수 저장
                map.computeIfAbsent(key.toString(), k -> new ArrayList<>())
                        .add(score);
            }
        }

        // 모든 점수 리스트 정렬
        for (List<Integer> scores : map.values()) {
            Collections.sort(scores);
        }

        // 정답 배열 생성
        int[] answer = new int[query.length];

        // 모든 쿼리 처리
        for (int i = 0; i < query.length; i++) {

            // and 제거
            String[] parts = query[i]
                    .replace(" and ", " ")
                    .split(" ");

            // 조건 키 생성
            String key = parts[0] + "#"
                    + parts[1] + "#"
                    + parts[2] + "#"
                    + parts[3] + "#";

            // 기준 점수 추출
            int target = Integer.parseInt(parts[4]);

            // 조건에 해당하는 점수 리스트 조회
            List<Integer> scores = map.get(key);

            // 해당 조건 지원자가 없으면 0
            if (scores == null) {
                answer[i] = 0;
                continue;
            }

            // target 이상이 처음 나오는 위치 찾기
            int idx = lowerBound(scores, target);

            // target 이상 개수 계산
            answer[i] = scores.size() - idx;
        }

        return answer;
    }

    private int lowerBound(List<Integer> scores, int target) {

        // 탐색 시작
        int left = 0;

        // 탐색 끝
        int right = scores.size();

        // 이분 탐색
        while (left < right) {

            // 중간 위치
            int mid = left + (right - left) / 2;

            // target 이상이면 왼쪽 탐색
            if (scores.get(mid) >= target) {
                right = mid;
            }
            // 작으면 오른쪽 탐색
            else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}