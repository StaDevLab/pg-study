import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int row = maps.length;
        int col = maps[0].length();

        int startX = 0;
        int startY = 0;

        int leverX = 0;
        int leverY = 0;

        int exitX = 0;
        int exitY = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char c = maps[i].charAt(j);

                if (c == 'S') {
                    startX = i;
                    startY = j;
                } else if (c == 'L') {
                    leverX = i;
                    leverY = j;
                } else if (c == 'E') {
                    exitX = i;
                    exitY = j;
                }
            }
        }

        int startToLever = bfs(maps, startX, startY, leverX, leverY);
        int leverToExit = bfs(maps, leverX, leverY, exitX, exitY);

        if (startToLever == -1 || leverToExit == -1) {
            return -1;
        }

        return startToLever + leverToExit;
    }

    private int bfs(String[] maps, int startX, int startY, int targetX, int targetY) {
        int row = maps.length;
        int col = maps[0].length();

        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];
            int count = current[2];

            if (x == targetX && y == targetY) {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (maps[nx].charAt(ny) == 'X') {
                    continue;
                }

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, count + 1});
            }
        }

        return -1;
    }
}