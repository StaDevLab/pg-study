class Solution {
    public int solution(int n) {

        int[] memo = new int[100001];

        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {

            memo[i] = (memo[i-1] + memo[i-2]) % 1234567;

        }

        return memo[n];

    }

}