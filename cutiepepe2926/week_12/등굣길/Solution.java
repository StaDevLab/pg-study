class Solution {
    public int solution(int m, int n, int[][] puddles) {

        // m = 가로 길이, n = 세로 길이
        int[][] dp = new int[n + 1][m + 1];

        // 웅덩이 표시용 배열
        boolean[][] isPuddle = new boolean[n + 1][m + 1];

        for (int[] puddle : puddles) {
            int garo = puddle[0];
            int sero = puddle[1];

            isPuddle[sero][garo] = true;
        }

        // 0은 헷갈려서 1로 진행
        dp[1][1] = 1;

        for (int sero = 1; sero <= n; sero++) {
            for (int garo = 1; garo <= m; garo++) {

                // 시작 지점 패스
                if (sero == 1 && garo == 1) {
                    continue;
                }

                // 웅덩이면 지나갈 수 없으므로 경로 개수는 0
                if (isPuddle[sero][garo]) {
                    dp[sero][garo] = 0;
                    continue;
                }

                dp[sero][garo] = (dp[sero - 1][garo] + dp[sero][garo - 1]) % 1000000007;
            }
        }

        return dp[n][m];
    }
}