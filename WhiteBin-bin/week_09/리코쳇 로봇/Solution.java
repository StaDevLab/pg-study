import java.util.*;

class Solution {
    public int solution(String[] board) {
        int row = board.length;
        int col = board[0].length();

        boolean[][] visited = new boolean[row][col];

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i].charAt(j) == 'R') {
                    startX = i;
                    startY = j;
                }
            }
        }

        return bfs(board, visited, startX, startY);
    }

    private int bfs(String[] board, boolean[][] visited, int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();

        int row = board.length;
        int col = board[0].length();

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];
            int count = current[2];

            if (board[x].charAt(y) == 'G') {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;

                while (true) {
                    int nextX = nx + dx[i];
                    int nextY = ny + dy[i];

                    if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                        break;
                    }

                    if (board[nextX].charAt(nextY) == 'D') {
                        break;
                    }

                    nx = nextX;
                    ny = nextY;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, count + 1});
                }
            }
        }

        return -1;
    }
}