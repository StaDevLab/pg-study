import java.util.*;

class Solution {

    public int solution(int distance, int[] rocks, int n) {

        Arrays.sort(rocks);

        int start = 1;
        int end = distance;
        int answer = 0;

        while (start <= end) {

            int mid = (start + end) / 2;

            // mid 거리 이상을 유지하면서 제거 가능한지 확인
            if (canRemove(rocks, distance, n, mid)) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return answer;
    }

    static boolean canRemove(int[] rocks, int distance, int n, int minDistance) {

        int removeCount = 0;
        int prev = 0;

        for (int i = 0; i < rocks.length; i++) {

            // 이전에 남긴 지점과 현재 바위 사이 거리가 minDistance보다 작으면 제거
            if (rocks[i] - prev < minDistance) {
                removeCount++;
            } else {
                prev = rocks[i];
            }
        }

        // 마지막 남긴 바위와 도착지점 사이 거리도 확인
        if (distance - prev < minDistance) {
            removeCount++;
        }

        return removeCount <= n;
    }
}