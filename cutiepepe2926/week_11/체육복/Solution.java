import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n + 1];

        // 체육복 1개 기본 셋팅
        Arrays.fill(clothes, 1);

        // 도난 시 개수 감소
        for (int num : lost) {
            clothes[num]--;
        }

        // 여벌 보유 시 체육복 개수 증가
        for (int num : reserve) {
            clothes[num]++;
        }

        // 앞 번호부터 확인하면서 체육복이 없는 학생에게 빌려줌
        for (int i = 1; i <= n; i++) {
            if (clothes[i] == 0) {

                // 왼쪽 학생이 여벌이 있으면 먼저 빌림
                if (i - 1 >= 1 && clothes[i - 1] == 2) {
                    clothes[i]++;
                    clothes[i - 1]--;
                }
                // 왼쪽에서 못 빌리면 오른쪽 학생에게 빌림
                else if (i + 1 <= n && clothes[i + 1] == 2) {
                    clothes[i]++;
                    clothes[i + 1]--;
                }
            }
        }

        int answer = 0;

        // 체육복이 1개 이상 있으면 수업 참여 가능
        for (int i = 1; i <= n; i++) {
            if (clothes[i] >= 1) {
                answer++;
            }
        }

        return answer;
    }
}