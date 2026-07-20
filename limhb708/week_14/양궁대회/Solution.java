import java.util.*;

class Solution {

    // 최대 점수 차이를 저장하는 변수
    private int maxDiff = 0;

    // 최종 정답
    private int[] answer = {-1};

    public int[] solution(int n, int[] info) {

        // 라이언이 맞힌 화살 개수를 저장하는 배열
        int[] lion = new int[11];

        // DFS 시작
        dfs(
                0,
                n,
                info,
                lion
        );

        return answer;
    }

    private void dfs(
            int idx,
            int remain,
            int[] info,
            int[] lion
    ) {

        // 모든 점수를 확인했다면
        if (idx == 11) {

            // 남은 화살이 있다면 0점에 몰아준다.
            if (remain > 0) {
                lion[10] += remain;
            }

            // 라이언 점수
            int lionScore = 0;

            // 어피치 점수
            int apeachScore = 0;

            // 모든 점수 계산
            for (int i = 0; i < 11; i++) {

                // 현재 점수
                int score = 10 - i;

                // 둘 다 안 맞힌 경우
                if (lion[i] == 0 && info[i] == 0) {
                    continue;
                }

                // 라이언이 더 많이 맞힌 경우
                if (lion[i] > info[i]) {
                    lionScore += score;
                }

                // 어피치가 점수를 가져가는 경우
                else {
                    apeachScore += score;
                }
            }

            // 점수 차이 계산
            int diff = lionScore - apeachScore;

            // 라이언이 이긴 경우만 확인
            if (diff > 0) {

                // 더 큰 점수 차이 발견
                if (diff > maxDiff) {

                    maxDiff = diff;

                    answer = lion.clone();
                }

                // 점수 차이가 같은 경우
                else if (diff == maxDiff) {

                    // 더 좋은 배치인지 비교
                    if (isBetter(lion, answer)) {

                        answer = lion.clone();
                    }
                }
            }

            // 0점에 넣었던 화살 복구
            if (remain > 0) {
                lion[10] -= remain;
            }

            return;
        }

        // 현재 점수를 가져가기 위해 필요한 화살 수
        int need = info[idx] + 1;

        // 가져갈 수 있는 경우
        if (remain >= need) {

            // 라이언 화살 배치
            lion[idx] = need;

            // 다음 점수 탐색
            dfs(
                    idx + 1,
                    remain - need,
                    info,
                    lion
            );

            // 백트래킹
            lion[idx] = 0;
        }

        // 현재 점수를 포기하는 경우
        dfs(
                idx + 1,
                remain,
                info,
                lion
        );
    }

    private boolean isBetter(
            int[] current,
            int[] best
    ) {

        // 낮은 점수부터 비교
        for (int i = 10; i >= 0; i--) {

            // 현재 경우가 더 많이 맞힌 경우
            if (current[i] > best[i]) {
                return true;
            }

            // 기존 정답이 더 좋은 경우
            if (current[i] < best[i]) {
                return false;
            }
        }

        return false;
    }
}