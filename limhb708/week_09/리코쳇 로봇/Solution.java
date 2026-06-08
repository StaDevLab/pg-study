import java.util.*;

class Solution {

    // 상하좌우 이동 방향
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(String[] board) {

        // 세로 길이
        int rows = board.length;

        // 가로 길이
        int cols = board[0].length();

        // 시작 위치
        int startX = 0;
        int startY = 0;

        // 목표 위치
        int goalX = 0;
        int goalY = 0;

        // 시작 위치와 목표 위치 찾기
        for (int i = 0; i < rows; i++) {

            // 각 행의 열을 하나씩 확인
            for (int j = 0; j < cols; j++) {

                // 현재 칸의 문자
                char current = board[i].charAt(j);

                // 로봇 시작 위치라면 저장
                if (current == 'R') {
                    startX = i;
                    startY = j;
                }

                // 목표 위치라면 저장
                if (current == 'G') {
                    goalX = i;
                    goalY = j;
                }
            }
        }

        // BFS 탐색을 위한 큐 생성
        Queue<int[]> queue = new LinkedList<>();

        // 방문 여부를 저장하는 배열
        boolean[][] visited = new boolean[rows][cols];

        // 시작 위치와 이동 횟수 0을 큐에 넣음
        queue.offer(new int[]{startX, startY, 0});

        // 시작 위치 방문 처리
        visited[startX][startY] = true;

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {

            // 현재 위치와 이동 횟수를 꺼냄
            int[] current = queue.poll();

            // 현재 행
            int x = current[0];

            // 현재 열
            int y = current[1];

            // 현재까지 이동 횟수
            int count = current[2];

            // 현재 위치가 목표 위치라면 이동 횟수 반환
            if (x == goalX && y == goalY) {
                return count;
            }

            // 상하좌우 네 방향으로 이동 시도
            for (int i = 0; i < 4; i++) {

                // 현재 위치에서 출발
                int nextX = x;
                int nextY = y;

                // 벽이나 장애물을 만나기 전까지 계속 미끄러짐
                while (true) {

                    // 다음으로 이동할 위치
                    int moveX = nextX + dx[i];
                    int moveY = nextY + dy[i];

                    // 다음 위치가 범위를 벗어나면 멈춤
                    if (moveX < 0 || moveX >= rows || moveY < 0 || moveY >= cols) {
                        break;
                    }

                    // 다음 위치가 장애물이면 멈춤
                    if (board[moveX].charAt(moveY) == 'D') {
                        break;
                    }

                    // 이동 가능한 위치라면 실제 위치 갱신
                    nextX = moveX;
                    nextY = moveY;
                }

                // 이미 방문한 위치라면 건너뜀
                if (visited[nextX][nextY]) {
                    continue;
                }

                // 새로 멈춘 위치를 방문 처리
                visited[nextX][nextY] = true;

                // 이동 횟수를 1 증가시켜 큐에 넣음
                queue.offer(new int[]{nextX, nextY, count + 1});
            }
        }

        // BFS가 끝날 때까지 목표에 도달하지 못했다면 -1 반환
        return -1;
    }
}