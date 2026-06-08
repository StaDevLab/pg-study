import java.util.*;

class Solution {

    // 방문 여부를 저장하는 배열
    static boolean[][] visited;

    // 상하좌우 이동을 위한 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int[] solution(int m, int n, int[][] picture) {

        // 영역의 개수를 저장하는 변수
        int numberOfArea = 0;

        // 가장 큰 영역의 크기를 저장하는 변수
        int maxSizeOfOneArea = 0;

        // 방문 배열을 그림 크기만큼 생성
        visited = new boolean[m][n];

        // 그림의 모든 칸을 하나씩 확인
        for (int i = 0; i < m; i++) {

            // 각 행의 열을 하나씩 확인
            for (int j = 0; j < n; j++) {

                // 현재 칸이 0이 아니고 아직 방문하지 않았다면 새로운 영역 시작
                if (picture[i][j] != 0 && !visited[i][j]) {

                    // 새로운 영역을 발견했으므로 영역 개수 증가
                    numberOfArea++;

                    // BFS로 현재 영역의 크기 계산
                    int areaSize = bfs(i, j, m, n, picture);

                    // 가장 큰 영역의 크기 갱신
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, areaSize);
                }
            }
        }

        // 정답 배열 생성
        int[] answer = new int[2];

        // 첫 번째 값은 영역 개수
        answer[0] = numberOfArea;

        // 두 번째 값은 가장 큰 영역의 크기
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    public int bfs(int x, int y, int m, int n, int[][] picture) {

        // 현재 영역의 색깔 저장
        int color = picture[x][y];

        // 현재 영역의 크기
        int size = 1;

        // BFS 탐색을 위한 큐 생성
        Queue<int[]> queue = new LinkedList<>();

        // 시작 위치를 큐에 넣음
        queue.offer(new int[]{x, y});

        // 시작 위치 방문 처리
        visited[x][y] = true;

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {

            // 큐에서 현재 위치를 꺼냄
            int[] current = queue.poll();

            // 현재 위치의 행
            int currentX = current[0];

            // 현재 위치의 열
            int currentY = current[1];

            // 상하좌우 네 방향 확인
            for (int i = 0; i < 4; i++) {

                // 다음 행 위치
                int nextX = currentX + dx[i];

                // 다음 열 위치
                int nextY = currentY + dy[i];

                // 그림 범위를 벗어나면 건너뜀
                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                    continue;
                }

                // 이미 방문한 칸이면 건너뜀
                if (visited[nextX][nextY]) {
                    continue;
                }

                // 현재 영역의 색깔과 다르면 건너뜀
                if (picture[nextX][nextY] != color) {
                    continue;
                }

                // 같은 영역이므로 방문 처리
                visited[nextX][nextY] = true;

                // 큐에 다음 위치 추가
                queue.offer(new int[]{nextX, nextY});

                // 영역 크기 증가
                size++;
            }
        }
        
        return size;
    }
}