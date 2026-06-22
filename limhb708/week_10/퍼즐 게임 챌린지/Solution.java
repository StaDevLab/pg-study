class Solution {

    public int solution(int[] diffs, int[] times, long limit) {

        // 최대 난이도 저장
        int maxDiff = 1;

        // 최대 난이도 찾기
        for (int diff : diffs) {
            maxDiff = Math.max(maxDiff, diff);
        }

        // 최소 숙련도
        int left = 1;

        // 최대 숙련도
        int right = maxDiff;

        // 최소 가능한 숙련도 탐색
        while (left < right) {

            // 중간 숙련도
            int mid = left + (right - left) / 2;

            // 제한 시간 안에 가능
            if (canSolve(diffs, times, limit, mid)) {

                // 더 작은 숙련도 확인
                right = mid;
            }
            // 제한 시간 초과
            else {

                // 숙련도 증가
                left = mid + 1;
            }
        }
        
        return left;
    }

    private boolean canSolve(
            int[] diffs,
            int[] times,
            long limit,
            int level
    ) {

        // 첫 퍼즐 시간
        long total = times[0];

        // 이미 제한 시간 초과
        if (total > limit) {
            return false;
        }

        // 두 번째 퍼즐부터 확인
        for (int i = 1; i < diffs.length; i++) {

            // 숙련도가 충분한 경우
            if (diffs[i] <= level) {

                // 현재 퍼즐 시간 추가
                total += times[i];
            }
            // 숙련도가 부족한 경우
            else {

                // 틀리는 횟수
                long fail = (long) diffs[i] - level;

                // 실패 시간 + 성공 시간 추가
                total += fail * ((long) times[i] + times[i - 1])
                        + times[i];
            }

            // 제한 시간 초과
            if (total > limit) {
                return false;
            }
        }

        return true;
    }
}