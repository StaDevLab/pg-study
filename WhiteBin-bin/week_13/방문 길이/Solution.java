class Solution {

    public int solution(String dirs) {

        boolean[][][] visited = new boolean[11][11][4];

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int x = 5;
        int y = 5;
        int length = 0;

        for (char cmd : dirs.toCharArray()) {
            int direction = getDirection(cmd);

            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx < 0 || nx > 10 || ny < 0 || ny > 10) {
                continue;
            }

            if (!visited[x][y][direction]) {
                visited[x][y][direction] = true;

                int reverseDirection = getReverseDirection(direction);
                visited[nx][ny][reverseDirection] = true;

                length++;
            }

            x = nx;
            y = ny;
        }

        return length;
    }

    private int getDirection(char command) {
        if (command == 'U') {
            return 0;
        }

        if (command == 'D') {
            return 1;
        }

        if (command == 'R') {
            return 2;
        }

        return 3;
    }

    private int getReverseDirection(int direction) {
        if (direction == 0) {
            return 1;
        }

        if (direction == 1) {
            return 0;
        }

        if (direction == 2) {
            return 3;
        }

        return 2;
    }
}