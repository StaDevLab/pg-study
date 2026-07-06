class Solution {

    public int solution(int[][] sizes) {

        // 지갑의 가로 후보
        int maxWidth = 0;

        // 지갑의 세로 후보
        int maxHeight = 0;

        // 모든 명함 확인
        for (int[] card : sizes) {

            // 긴 쪽을 가로로 둔다
            int width = Math.max(card[0], card[1]);

            // 짧은 쪽을 세로로 둔다
            int height = Math.min(card[0], card[1]);

            // 필요한 가로 최대값 갱신
            maxWidth = Math.max(maxWidth, width);

            // 필요한 세로 최대값 갱신
            maxHeight = Math.max(maxHeight, height);
        }

        // 지갑 넓이 반환
        return maxWidth * maxHeight;
    }
}