import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (picture[i][j] != 0 && !visited[i][j]) {
                    numberOfArea++;

                    int size = bfs(i, j, m, n, picture, visited);

                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                }
            }
        }

        return new int[]{numberOfArea, maxSizeOfOneArea};
    }

    private int bfs(int startX, int startY, int m, int n, int[][] picture, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();

        int color = picture[startX][startY];
        int size = 1;

        visited[startX][startY] = true;
        queue.offer(new int[]{startX, startY});

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (picture[nx][ny] != color) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
                size++;
            }
        }

        return size;
    }
}