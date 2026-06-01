import java.util.*;

class Solution {

    static boolean[][] visited; // 방문체크용
    static char[][] map; // 지도
    static int rL; // 행 길이
    static int cL; // 열 길이

    // 상하좌우 이동용
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public int[] solution(String[] maps) {

        List<Integer> answer = new ArrayList<>();

        rL = maps.length;
        cL = maps[0].length();

        visited = new boolean[rL][cL];
        map = new char[rL][cL];

        // String 배열을 char 배열로 변환
        for (int i = 0; i < rL; i++) {
            map[i] = maps[i].toCharArray();
        }

        // 전체 지도를 순회
        for (int row = 0; row < rL; row++) {

            for (int col = 0; col < cL; col++) {

                // 바다이거나 이미 방문했다면 무시
                if (map[row][col] == 'X' || visited[row][col]) {
                    continue;
                }

                // dfs 순회로 연결된 섬의 식량 합 계산
                int sum = dfs(row, col);

                answer.add(sum);
            }
        }

        // 지낼 수 있는 무인도가 없다면 -1 반환
        if (answer.isEmpty()) {
            return new int[] {-1};
        }

        // 오름차순 정렬
        Collections.sort(answer);

        // List<Integer>를 int[]로 변환
        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    // r는 row, c는 col
    static int dfs(int r, int c) {

        // 해당 위치 방문 체크
        visited[r][c] = true;

        // 현재 칸의 식량 값
        int sum = map[r][c] - '0';

        // 상하좌우 체크
        for (int i = 0; i < 4; i++) {

            int nextR = r + dr[i];
            int nextC = c + dc[i];

            // 지도 범위를 벗어나면 무시
            if (nextR < 0 || nextR >= rL || nextC < 0 || nextC >= cL) {
                continue;
            }

            // 바다이거나 이미 방문했다면 무시
            if (map[nextR][nextC] == 'X' || visited[nextR][nextC]) {
                continue;
            }

            // 연결된 땅이면 dfs로 계속 탐색
            sum += dfs(nextR, nextC);
        }

        return sum;
    }
}