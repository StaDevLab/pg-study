import java.util.Arrays;

class Solution {

    public int solution(int distance, int[] rocks, int n) {

        // 바위 정렬
        Arrays.sort(rocks);

        // 최소 거리 후보
        int left = 1;

        // 최대 거리 후보
        int right = distance;

        // 정답 저장
        int answer = 0;

        // 최대 최소거리 탐색
        while (left <= right) {

            // 중간 거리
            int mid = left + (right - left) / 2;

            // mid 거리 확보 가능
            if (canMakeDistance(rocks, distance, n, mid)) {

                // 정답 갱신
                answer = mid;

                // 더 큰 거리 확인
                left = mid + 1;
            }
            // 거리 확보 불가능
            else {

                // 거리 감소
                right = mid - 1;
            }
        }
        
        return answer;
    }

    private boolean canMakeDistance(
            int[] rocks,
            int distance,
            int n,
            int minDistance
    ) {

        // 제거한 바위 개수
        int removed = 0;

        // 마지막으로 남긴 위치
        int previous = 0;

        // 모든 바위 확인
        for (int rock : rocks) {

            // 거리 부족
            if (rock - previous < minDistance) {

                // 현재 바위 제거
                removed++;

                // 제거 개수 초과
                if (removed > n) {
                    return false;
                }
            }
            // 거리 충분
            else {

                // 현재 바위 유지
                previous = rock;
            }
        }

        // 마지막 구간 확인
        if (distance - previous < minDistance) {
            removed++;
        }

        // 제거 가능 여부 반환
        return removed <= n;
    }
}