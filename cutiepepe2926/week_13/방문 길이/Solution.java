import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;

        // 현재 위치
        int sero = 0;
        int garo = 0;

        // 이미 지나간 길 저장
        Set<String> visited = new HashSet<>();

        for (int i = 0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);

            int nextSero = sero;
            int nextGaro = garo;

            // 명령어에 따라 다음 위치 계산
            if (dir == 'U') {
                nextSero++;
            } else if (dir == 'D') {
                nextSero--;
            } else if (dir == 'R') {
                nextGaro++;
            } else if (dir == 'L') {
                nextGaro--;
            }

            // 좌표평면 범위를 벗어나면 이동하지 않음
            if (nextSero < -5 || nextSero > 5 || nextGaro < -5 || nextGaro > 5) {
                continue;
            }

            // 현재 위치 -> 다음 위치
            String path = sero + "," + garo + "->" + nextSero + "," + nextGaro;

            // 다음 위치 -> 현재 위치
            String reversePath = nextSero + "," + nextGaro + "->" + sero + "," + garo;

            // 처음 지나가는 길이면 answer 증가
            if (!visited.contains(path) && !visited.contains(reversePath)) {
                answer++;
            }

            // 양방향 모두 저장
            visited.add(path);
            visited.add(reversePath);

            // 실제 위치 이동
            sero = nextSero;
            garo = nextGaro;
        }

        return answer;
    }
}