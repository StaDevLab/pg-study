class Solution {

    public int solution(int[] diffs, int[] times, long limit) {

        int answer = 0;

        int left = 1;
        int right = 0;

        // 숙련도는 최대 난이도까지만
        for (int diff : diffs) {
            right = Math.max(right, diff);
        }

        while (left <= right) {

            int mid = (left + right) / 2;

            // mid 숙련도로 제한 시간 안에 풀 수 있으면
            if (check(diffs, times, limit, mid)) {
                answer = mid;
                right = mid - 1;
            }
            // 제한 시간 안에 못 풀면 숙련도 업
            else {
                left = mid + 1;
            }
        }

        return answer;
    }

    static boolean check(int[] diffs, int[] times, long limit, int level) {

        long total = 0;

        for (int i = 0; i < diffs.length; i++) {

            int diff = diffs[i];
            int timeCur = times[i];

            // 현재 숙련도로 바로 풀 수 있는 경우
            if (diff <= level) {
                total += timeCur;
            }
            // 틀리는 경우
            else {
                int timePrev = times[i - 1];
                int wrong = diff - level;

                total += (long) (timeCur + timePrev) * wrong + timeCur;
            }

            // limit 초과 처리
            if (total > limit) {
                return false;
            }
        }

        return total <= limit;
    }
}