import java.util.*;

class Solution {

    static boolean[][] visited;
    static char[][] map;

    static int[] sero = {-1, 1, 0, 0}; // 세로
    static int[] garo = {0, 0, -1, 1}; // 가로

    public int solution(String[] board) {

        int m = board.length;
        int n = board[0].length();

        map = new char[m][n];
        visited = new boolean[m][n];

        int startS = 0;
        int startG = 0;

        for (int s = 0; s < m; s++) {
            for (int g = 0; g < n; g++) {

                map[s][g] = board[s].charAt(g);

                if (map[s][g] == 'R') {
                    startS = s;
                    startG = g;
                }
            }
        }

        return bfs(startS, startG, m, n);
    }

    static int bfs(int startS, int startG, int m, int n) {

        Queue<int[]> queue = new LinkedList<>();

        visited[startS][startG] = true;
        queue.offer(new int[] {startS, startG, 0});

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int s = current[0];
            int g = current[1];
            int count = current[2];

            // 목표 지점에 멈춘 경우
            if (map[s][g] == 'G') {
                return count;
            }

            for (int i = 0; i < 4; i++) {

                int ns = s;
                int ng = g;

                // 한 방향으로 벽 또는 장애물을 만나기 전까지 이동
                // 기존처럼 하나 이동하고 끝내면 오류 생김
                while (true) {

                    int nextS = ns + sero[i];
                    int nextG = ng + garo[i];

                    // 범위 초과 시 멈춤
                    if (nextS < 0 || nextS >= m || nextG < 0 || nextG >= n) {
                        break;
                    }

                    // 장애물 발견 시 멈춤
                    if (map[nextS][nextG] == 'D') {
                        break;
                    }

                    ns = nextS;
                    ng = nextG;
                }

                // 재방문 시
                if (visited[ns][ng]) {
                    continue;
                }

                visited[ns][ng] = true;
                queue.offer(new int[] {ns, ng, count + 1});
            }
        }

        return -1;
    }
}