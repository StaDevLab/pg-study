import java.util.HashSet;
import java.util.Set;

class Solution {

    public int solution(String dirs) {

        // 캐릭터의 현재 x좌표를 0으로 초기화
        int x = 0;

        // 캐릭터의 현재 y좌표를 0으로 초기화
        int y = 0;

        // 이미 지나간 길을 저장할 Set 생성
        // Set은 중복된 값을 자동으로 제거한다.
        Set<String> visitedEdges = new HashSet<>();

        // 명령어 문자열을 문자 하나씩 순회
        for (char command : dirs.toCharArray()) {

            // 다음 x좌표를 현재 x좌표로 초기화
            int nextX = x;

            // 다음 y좌표를 현재 y좌표로 초기화
            int nextY = y;

            // 현재 명령어에 따라 다음 좌표 계산
            switch (command) {

                // 위쪽으로 한 칸 이동
                case 'U':
                    nextY++;
                    break;

                // 아래쪽으로 한 칸 이동
                case 'D':
                    nextY--;
                    break;

                // 오른쪽으로 한 칸 이동
                case 'R':
                    nextX++;
                    break;

                // 왼쪽으로 한 칸 이동
                case 'L':
                    nextX--;
                    break;
            }

            // 다음 좌표가 좌표평면의 범위를 벗어나면
            if (nextX < -5 || nextX > 5
                    || nextY < -5 || nextY > 5) {

                // 해당 명령을 무시하고 다음 명령으로 이동
                continue;
            }

            // 현재 좌표와 다음 좌표를 하나의 길로 만들어 Set에 저장
            visitedEdges.add(makeEdge(x, y, nextX, nextY));

            // 현재 x좌표를 다음 x좌표로 변경
            x = nextX;

            // 현재 y좌표를 다음 y좌표로 변경
            y = nextY;
        }

        // 중복을 제외한 처음 지나간 길의 개수를 반환
        return visitedEdges.size();
    }

    private String makeEdge(int x1, int y1, int x2, int y2) {

        // 두 좌표의 순서를 일정하게 만들기 위한 조건
        // x1이 x2보다 크거나
        // x좌표가 같으면서 y1이 y2보다 크다면 두 좌표를 교환
        if (x1 > x2 || (x1 == x2 && y1 > y2)) {

            // 첫 번째 x좌표를 임시 변수에 저장
            int tempX = x1;

            // 첫 번째 y좌표를 임시 변수에 저장
            int tempY = y1;

            // 두 번째 x좌표를 첫 번째 x좌표에 저장
            x1 = x2;

            // 두 번째 y좌표를 첫 번째 y좌표에 저장
            y1 = y2;

            // 기존 첫 번째 x좌표를 두 번째 x좌표에 저장
            x2 = tempX;

            // 기존 첫 번째 y좌표를 두 번째 y좌표에 저장
            y2 = tempY;
        }

        // 두 좌표를 하나의 문자열로 만들어 반환
        // 왕복한 길도 같은 문자열로 저장된다.
        return x1 + "," + y1 + ":" + x2 + "," + y2;
    }
}