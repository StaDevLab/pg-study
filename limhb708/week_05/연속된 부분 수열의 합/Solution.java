class Solution {

    public int[] solution(int[] sequence, int k) {

        // 왼쪽 포인터
        int left = 0;

        // 오른쪽 포인터
        int right = 0;

        // 현재 구간 합
        long sum = 0;

        // 가장 짧은 구간 길이
        int bestLength = Integer.MAX_VALUE;

        // 정답 시작 인덱스
        int bestStart = 0;

        // 정답 끝 인덱스
        int bestEnd = 0;

        // 투 포인터 진행
        while (true) {

            // 합이 k 이상이면 왼쪽을 줄일 수 있음
            if (sum >= k) {

                // 합이 정확히 k인 경우
                if (sum == k) {

                    // 현재 구간은 [left, right - 1]
                    int currentLength = right - left;

                    // 더 짧은 구간이면 정답 갱신
                    if (currentLength < bestLength) {
                        bestLength = currentLength;
                        bestStart = left;
                        bestEnd = right - 1;
                    }
                }

                // 왼쪽 값을 빼고 left 이동
                sum -= sequence[left];
                left++;
            }

            // 합이 k보다 작으면 오른쪽을 늘림
            else {

                // 더 이상 오른쪽으로 늘릴 수 없으면 종료
                if (right == sequence.length) {
                    break;
                }

                // 오른쪽 값을 더하고 right 이동
                sum += sequence[right];
                right++;
            }
        }

        // 정답 반환
        return new int[]{bestStart, bestEnd};
    }
}