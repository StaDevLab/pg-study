import java.util.*;

class Solution {

    static boolean[][] visited;
    static int[] sero = {-1, 1, 0, 0}; // 세로
    static int[] garo = {0, 0, -1, 1}; // 가로

    public int[] solution(int m, int n, int[][] picture) {

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        // 0 은 영역으로 인지 X
        // 상하좌우 미 연결 시, 서로 다른 영역으로 인지
        // BFS 형태로 같은 색상만 탐색

        visited = new boolean[m][n];

        for (int s = 0; s < m; s++) {
            for (int g = 0; g < n; g++) {

                // 빈 공간 무시
                if (picture[s][g] == 0) {
                    continue;
                }

                // 재방문 무시
                if (visited[s][g]) {
                    continue;
                }

                // 영역의 수
                numberOfArea++;

                int areaSize = bfs(s, g, m, n, picture);

                // 영역 중 최대크기 계산
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, areaSize);
            }
        }

        return new int[] {numberOfArea, maxSizeOfOneArea};
    }

    static int bfs(int startS, int startG, int m, int n, int[][] picture) {

        Queue<int[]> queue = new LinkedList<>();

        int color = picture[startS][startG];
        int size = 1;

        visited[startS][startG] = true;
        queue.offer(new int[] {startS, startG});

        while (!queue.isEmpty()) {

            int[] current = queue.poll();
            int s = current[0];
            int g = current[1];

            for (int i = 0; i < 4; i++) {

                int ns = s + sero[i];
                int ng = g + garo[i];

                // 범위 초과 시
                if (ns < 0 || ns >= m || ng < 0 || ng >= n) {
                    continue;
                }

                // 재방문 시
                if (visited[ns][ng]) {
                    continue;
                }

                // 빈 공간 발견 시
                if (picture[ns][ng] == 0) {
                    continue;
                }

                if (picture[ns][ng] != color) {
                    continue;
                }

                visited[ns][ng] = true;
                queue.offer(new int[] {ns, ng});
                size++;
            }
        }

        return size;
    }
}

// 1 1 1 0
// 1 2 2 0
// 1 0 0 1
// 0 0 0 1
// 0 0 0 3
// 0 0 0 3