import java.util.*;

class Solution {

    static int n, m;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();

        visited = new boolean[n][m];

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    int sum = dfs(i, j, maps);
                    result.add(sum);
                }
            }
        }

        if (result.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(result);

        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    private int dfs(int x, int y, String[] maps) {
        visited[x][y] = true;

        int sum = maps[x].charAt(y) - '0';

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }

            if (maps[nx].charAt(ny) == 'X') {
                continue;
            }

            if (visited[nx][ny]) {
                continue;
            }

            sum += dfs(nx, ny, maps);
        }

        return sum;
    }
}