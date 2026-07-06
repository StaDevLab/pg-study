class Solution {

    public int solution(int m, int n, int[][] puddles) {

        // 나머지 연산 값
        int MOD = 1_000_000_007;

        // puddle[row][col] = 물에 잠긴 칸인지 여부
        boolean[][] puddle = new boolean[n + 1][m + 1];

        // 물에 잠긴 지역 표시
        for (int[] p : puddles) {

            // 문제에서 좌표는 [x, y] 순서로 들어옴
            int col = p[0];
            int row = p[1];

            puddle[row][col] = true;
        }

        // dp[row][col] = 해당 칸까지 오는 최단 경로 개수
        int[][] dp = new int[n + 1][m + 1];

        // 시작점
        dp[1][1] = 1;

        // 위에서 아래로, 왼쪽에서 오른쪽으로 이동
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= m; col++) {

                // 물에 잠긴 칸은 갈 수 없음
                if (puddle[row][col]) {
                    dp[row][col] = 0;
                    continue;
                }

                // 시작점은 이미 1로 설정했으므로 건너뜀
                if (row == 1 && col == 1) {
                    continue;
                }

                // 위쪽에서 오는 경우 + 왼쪽에서 오는 경우
                dp[row][col] = (dp[row - 1][col] + dp[row][col - 1]) % MOD;
            }
        }

        // 학교 위치까지 가는 경로 수 반환
        return dp[n][m];
    }
}