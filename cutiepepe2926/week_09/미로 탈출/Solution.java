import java.util.*;

class Solution {

    static char[][] map;
    static boolean[][] visited;
    static int[] sero = {-1, 1, 0, 0}; // 세로 이동
    static int[] garo = {0, 0, -1, 1}; // 가로 이동

    public int solution(String[] maps) {

        int m = maps.length;
        int n = maps[0].length();

        map = new char[m][n];

        // 시작 지점 S의 좌표
        int startS = 0;
        int startG = 0;

        // 레버 L의 좌표
        int leverS = 0;
        int leverG = 0;

        // 출구 E의 좌표
        int endS = 0;
        int endG = 0;

        // String[] 형태의 maps를 char[][] 형태로 변환하면서
        // 시작 지점 S, 레버 L, 출구 E의 위치를 찾는다.
        for (int s = 0; s < m; s++) {
            for (int g = 0; g < n; g++) {

                map[s][g] = maps[s].charAt(g);

                // 시작 지점 위치 저장
                if (map[s][g] == 'S') {
                    startS = s;
                    startG = g;
                }

                // 레버 위치 저장
                if (map[s][g] == 'L') {
                    leverS = s;
                    leverG = g;
                }

                // 출구 위치 저장
                if (map[s][g] == 'E') {
                    endS = s;
                    endG = g;
                }
            }
        }

        // 시작 지점 S에서 레버 L까지의 최단거리
        int sTol = bfs(startS, startG, leverS, leverG, m, n);

        if (sTol == -1) {
            return -1;
        }

        // 레버 L에서 출구 E까지의 최단거리
        int lToe = bfs(leverS, leverG, endS, endG, m, n);

        if (lToe == -1) {
            return -1;
        }

        return sTol + lToe;
    }

    static int bfs(int startS, int startG, int targetS, int targetG, int m, int n) {

        Queue<int[]> queue = new LinkedList<>();

        // BFS를 두 번 실행이라 방문 배열을 미초기화 시 오류 발생함
        visited = new boolean[m][n];

        visited[startS][startG] = true;

        queue.offer(new int[] {startS, startG, 0});

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int s = current[0];      // 현재 세로 위치
            int g = current[1];      // 현재 가로 위치
            int count = current[2];  // 현재까지 이동한 횟수

            // 현재 위치가 목표 위치라면 최단거리 반환
            if (s == targetS && g == targetG) {
                return count;
            }

            for (int i = 0; i < 4; i++) {

                int ns = s + sero[i];
                int ng = g + garo[i];

                // 지도 범위를 초과
                if (ns < 0 || ns >= m || ng < 0 || ng >= n) {
                    continue;
                }

                // 이미 방문
                if (visited[ns][ng]) {
                    continue;
                }

                // 벽
                if (map[ns][ng] == 'X') {
                    continue;
                }

                visited[ns][ng] = true;
                queue.offer(new int[] {ns, ng, count + 1});
            }
        }

        // 목표 미도달 시 -1 반환
        return -1;
    }
}