import java.util.Arrays;

class Solution {

    public int solution(int x, int y, int n) {

        // 도달할 수 없음을 의미하는 큰 값
        int INF = 1_000_001;

        // dp[i] = x에서 i를 만들기 위한 최소 연산 횟수
        int[] dp = new int[y + 1];

        // 처음에는 전부 도달 불가능 처리
        Arrays.fill(dp, INF);

        // 시작 숫자 x는 연산 0번으로 만들 수 있음
        dp[x] = 0;

        // x부터 y까지 차례대로 확인
        for (int i = x; i <= y; i++) {

            // 현재 숫자 i를 만들 수 없다면 건너뜀
            if (dp[i] == INF) {
                continue;
            }

            // i + n 연산
            if (i + n <= y) {
                dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
            }

            // i * 2 연산
            if (i * 2 <= y) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }

            // i * 3 연산
            if (i * 3 <= y) {
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            }
        }

        // y에 도달하지 못했으면 -1
        if (dp[y] == INF) {
            return -1;
        }

        // y를 만드는 최소 연산 횟수 반환
        return dp[y];
    }
}