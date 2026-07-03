class Solution {
    int solution(int[][] land) {
        int n = land.length;

        for (int row = 1; row < n; row++) {
            land[row][0] += Math.max(
                Math.max(land[row - 1][1], land[row - 1][2]),
                land[row - 1][3]
            );

            land[row][1] += Math.max(
                Math.max(land[row - 1][0], land[row - 1][2]),
                land[row - 1][3]
            );

            land[row][2] += Math.max(
                Math.max(land[row - 1][0], land[row - 1][1]),
                land[row - 1][3]
            );

            land[row][3] += Math.max(
                Math.max(land[row - 1][0], land[row - 1][1]),
                land[row - 1][2]
            );
        }

        return Math.max(
            Math.max(land[n - 1][0], land[n - 1][1]),
            Math.max(land[n - 1][2], land[n - 1][3])
        );
    }
}