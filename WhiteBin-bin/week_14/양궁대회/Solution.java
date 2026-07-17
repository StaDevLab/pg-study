class Solution {

    private int[] apeach;
    private int[] answer;
    private int maxDifference = 0;

    public int[] solution(int n, int[] info) {
        apeach = info;
        answer = new int[11];

        int[] ryan = new int[11];

        dfs(0, n, ryan);

        if (maxDifference == 0) {
            return new int[]{-1};
        }

        return answer;
    }

    private void dfs(int index, int remainingArrow, int[] ryan) {
        // 10점부터 1점까지 선택이 끝난 경우
        if (index == 10) {
            // 남은 화살은 모두 0점에 배치
            ryan[10] = remainingArrow;

            int difference = calculateDifference(ryan);

            if (difference > maxDifference) {
                maxDifference = difference;
                answer = ryan.clone();
            } else if (difference == maxDifference
                    && difference > 0
                    && isBetter(ryan, answer)) {
                answer = ryan.clone();
            }

            ryan[10] = 0;
            return;
        }

        int requiredArrow = apeach[index] + 1;

        if (remainingArrow >= requiredArrow) {
            ryan[index] = requiredArrow;

            dfs(
                index + 1,
                remainingArrow - requiredArrow,
                ryan
            );

            ryan[index] = 0;
        }

        dfs(index + 1, remainingArrow, ryan);
    }

    private int calculateDifference(int[] ryan) {
        int ryanScore = 0;
        int apeachScore = 0;

        for (int i = 0; i < 11; i++) {

            if (ryan[i] == 0 && apeach[i] == 0) {
                continue;
            }

            int score = 10 - i;

            if (ryan[i] > apeach[i]) {
                ryanScore += score;
            } else {
                apeachScore += score;
            }
        }

        return ryanScore - apeachScore;
    }

    private boolean isBetter(int[] candidate, int[] currentAnswer) {
        
        for (int i = 10; i >= 0; i--) {
            if (candidate[i] > currentAnswer[i]) {
                return true;
            }

            if (candidate[i] < currentAnswer[i]) {
                return false;
            }
        }

        return false;
    }
}