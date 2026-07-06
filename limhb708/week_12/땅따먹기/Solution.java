class Solution {

    public int solution(int[][] land) {

        // 행의 개수
        int n = land.length;

        // 두 번째 행부터 DP 갱신
        for (int row = 1; row < n; row++) {

            // 현재 행 0번 열을 밟는 경우
            land[row][0] += Math.max(
                    Math.max(land[row - 1][1], land[row - 1][2]),
                    land[row - 1][3]
            );

            // 현재 행 1번 열을 밟는 경우
            land[row][1] += Math.max(
                    Math.max(land[row - 1][0], land[row - 1][2]),
                    land[row - 1][3]
            );

            // 현재 행 2번 열을 밟는 경우
            land[row][2] += Math.max(
                    Math.max(land[row - 1][0], land[row - 1][1]),
                    land[row - 1][3]
            );

            // 현재 행 3번 열을 밟는 경우
            land[row][3] += Math.max(
                    Math.max(land[row - 1][0], land[row - 1][1]),
                    land[row - 1][2]
            );
        }

        // 마지막 행에서 가장 큰 값이 정답
        return Math.max(
                Math.max(land[n - 1][0], land[n - 1][1]),
                Math.max(land[n - 1][2], land[n - 1][3])
        );
    }
}