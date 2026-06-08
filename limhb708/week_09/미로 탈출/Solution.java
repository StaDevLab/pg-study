import java.util.*;

class Solution {

    // 상하좌우 이동 방향
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(String[] maps) {

        // 미로의 세로 길이
        int rows = maps.length;

        // 미로의 가로 길이
        int cols = maps[0].length();

        // 시작 지점 위치
        int startX = 0;
        int startY = 0;

        // 레버 위치
        int leverX = 0;
        int leverY = 0;

        // 출구 위치
        int exitX = 0;
        int exitY = 0;

        // 미로 전체를 돌면서 S, L, E 위치 찾기
        for (int i = 0; i < rows; i++) {

            // 각 행의 열을 하나씩 확인
            for (int j = 0; j < cols; j++) {

                // 현재 칸의 문자
                char current = maps[i].charAt(j);

                // 시작 지점이면 위치 저장
                if (current == 'S') {
                    startX = i;
                    startY = j;
                }

                // 레버이면 위치 저장
                if (current == 'L') {
                    leverX = i;
                    leverY = j;
                }

                // 출구이면 위치 저장
                if (current == 'E') {
                    exitX = i;
                    exitY = j;
                }
            }
        }

        // 시작 지점에서 레버까지의 최단 거리
        int startToLever = bfs(startX, startY, leverX, leverY, maps);

        // 레버에서 출구까지의 최단 거리
        int leverToExit = bfs(leverX, leverY, exitX, exitY, maps);

        // 둘 중 하나라도 갈 수 없다면 탈출 불가능
        if (startToLever == -1 || leverToExit == -1) {
            return -1;
        }

        // 두 거리의 합이 최소 탈출 시간
        return startToLever + leverToExit;
    }

    public int bfs(int startX, int startY, int targetX, int targetY, String[] maps) {

        // 미로의 세로 길이
        int rows = maps.length;

        // 미로의 가로 길이
        int cols = maps[0].length();

        // 방문 여부를 저장하는 배열
        boolean[][] visited = new boolean[rows][cols];

        // BFS 탐색을 위한 큐 생성
        Queue<int[]> queue = new LinkedList<>();

        // 시작 위치와 이동 시간을 큐에 넣음
        queue.offer(new int[]{startX, startY, 0});

        // 시작 위치 방문 처리
        visited[startX][startY] = true;

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {

            // 현재 위치와 이동 시간을 꺼냄
            int[] current = queue.poll();

            // 현재 행
            int x = current[0];

            // 현재 열
            int y = current[1];

            // 현재까지 걸린 시간
            int time = current[2];

            // 현재 위치가 목표 위치라면 시간 반환
            if (x == targetX && y == targetY) {
                return time;
            }

            // 상하좌우 네 방향 확인
            for (int i = 0; i < 4; i++) {

                // 다음 행 위치
                int nextX = x + dx[i];

                // 다음 열 위치
                int nextY = y + dy[i];

                // 미로 범위를 벗어나면 건너뜀
                if (nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols) {
                    continue;
                }

                // 이미 방문한 칸이면 건너뜀
                if (visited[nextX][nextY]) {
                    continue;
                }

                // 벽이면 이동할 수 없으므로 건너뜀
                if (maps[nextX].charAt(nextY) == 'X') {
                    continue;
                }

                // 이동 가능한 칸이므로 방문 처리
                visited[nextX][nextY] = true;

                // 이동 시간이 1초 증가한 상태로 큐에 넣음
                queue.offer(new int[]{nextX, nextY, time + 1});
            }
        }

        // 목표 위치에 도달할 수 없다면 -1 반환
        return -1;
    }
}