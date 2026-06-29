class Solution {

    public int solution(int n, int[] lost, int[] reserve) {

        // 학생별 체육복 개수 저장
        int[] clothes = new int[n + 2];

        // 모든 학생은 기본적으로 체육복 1벌을 가지고 있음
        for (int i = 1; i <= n; i++) {
            clothes[i] = 1;
        }

        // 도난당한 학생은 체육복 1벌 감소
        for (int student : lost) {
            clothes[student]--;
        }

        // 여벌이 있는 학생은 체육복 1벌 증가
        for (int student : reserve) {
            clothes[student]++;
        }

        // 1번 학생부터 차례대로 확인
        for (int i = 1; i <= n; i++) {

            // 체육복이 없는 학생만 빌려야 함
            if (clothes[i] == 0) {

                // 앞번호 학생이 여벌을 가지고 있으면 빌림
                if (clothes[i - 1] == 2) {
                    clothes[i - 1]--;
                    clothes[i]++;
                }

                // 뒷번호 학생이 여벌을 가지고 있으면 빌림
                else if (clothes[i + 1] == 2) {
                    clothes[i + 1]--;
                    clothes[i]++;
                }
            }
        }

        // 체육수업을 들을 수 있는 학생 수
        int answer = 0;

        // 체육복이 1벌 이상 있으면 수업 가능
        for (int i = 1; i <= n; i++) {
            if (clothes[i] >= 1) {
                answer++;
            }
        }

        // 정답 반환
        return answer;
    }
}