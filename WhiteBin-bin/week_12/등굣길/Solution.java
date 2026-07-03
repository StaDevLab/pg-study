class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1_000_000_007;

        int[][] dp = new int[n + 1][m + 1];
        boolean[][] blocked = new boolean[n + 1][m + 1];

        for (int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];
            blocked[y][x] = true;
        }

        dp[1][1] = 1;

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= m; col++) {
                if (blocked[row][col]) {
                    dp[row][col] = 0;
                    continue;
                }

                if (row == 1 && col == 1) {
                    continue;
                }

                dp[row][col] = (dp[row - 1][col] + dp[row][col - 1]) % MOD;
            }
        }

        return dp[n][m];
    }
}