class Solution {

    public int[] solution(int brown, int yellow) {

        // 전체 격자 수
        int total = brown + yellow;

        // 세로 길이를 작은 값부터 확인
        for (int height = 3; height * height <= total; height++) {

            // total이 height로 나누어떨어져야 직사각형 가능
            if (total % height != 0) {
                continue;
            }

            // 가로 길이
            int width = total / height;

            // 안쪽 노란색 영역의 크기 확인
            if ((width - 2) * (height - 2) == yellow) {
                return new int[]{width, height};
            }
        }

        // 문제 조건상 여기까지 오지 않음
        return new int[]{};
    }
}