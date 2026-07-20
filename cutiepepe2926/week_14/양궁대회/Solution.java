class Solution {

    int maxDiff = -1;
    int[] answer = new int[11];

    public int[] solution(int n, int[] info) {

        // 라이언
        int[] lion = new int[11];

        dfs(0, n, info, lion);

        if (maxDiff == -1) {
            return new int[] {-1};
        }

        return answer;
    }

    // idx : 현재 점수(0 = 10점, 10 = 0점)
    // remain : 남은 화살
    void dfs(int idx, int remain, int[] info, int[] lion) {

        // 모든 점수를 확인했거나 화살을 모두 사용한 경우
        if (idx == 11 || remain == 0) {

            // 남은 화살은 모두 0점에 사용
            if (remain > 0) {
                lion[10] += remain;
            }

            checkScore(info, lion);

            if (remain > 0) {
                lion[10] -= remain;
            }

            return;
        }

        // 현재 점수를 가져가는 경우
        if (remain > info[idx]) {

            lion[idx] = info[idx] + 1;

            dfs(idx + 1,
                    remain - (info[idx] + 1),
                    info,
                    lion);

            lion[idx] = 0;
        }

        // 2. 현재 점수를 포기하는 경우
        dfs(idx + 1, remain, info, lion);
    }

    // 점수 계산
    void checkScore(int[] info, int[] lion) {

        int lionScore = 0;
        int apeachScore = 0;

        for (int i = 0; i < 11; i++) {

            int score = 10 - i;

            // 둘 다 안 맞춘 경우
            if (info[i] == 0 && lion[i] == 0) {
                continue;
            }

            if (lion[i] > info[i]) {
                lionScore += score;
            } else {
                apeachScore += score;
            }
        }

        int diff = lionScore - apeachScore;

        // 이기지 못하면 종료
        if (diff <= 0) {
            return;
        }

        // 더 큰 점수 차 발견
        if (diff > maxDiff) {

            maxDiff = diff;
            answer = lion.clone();
        }

        // 점수 차가 같으면
        else if (diff == maxDiff) {

            // 낮은 점수를 더 많이 맞힌 경우 선택
            for (int i = 10; i >= 0; i--) {

                if (lion[i] > answer[i]) {
                    answer = lion.clone();
                    return;
                }

                if (lion[i] < answer[i]) {
                    return;
                }
            }
        }
    }
}