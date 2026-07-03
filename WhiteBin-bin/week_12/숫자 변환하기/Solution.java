import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int INF = 1_000_001;
        int[] dp = new int[y + 1];

        Arrays.fill(dp, INF);
        dp[x] = 0;

        for (int i = x; i <= y; i++) {
            if (dp[i] == INF) continue;

            if (i + n <= y) {
                dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
            }

            if (i * 2 <= y) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }

            if (i * 3 <= y) {
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            }
        }

        return dp[y] == INF ? -1 : dp[y];
    }
}