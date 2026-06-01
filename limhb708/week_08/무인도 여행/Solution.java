import java.util.*;

class Solution {

    // 상, 하, 좌, 우 이동을 위한 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 방문 여부를 체크하는 배열
    static boolean[][] visited;

    // 지도의 세로 길이
    static int row;

    // 지도의 가로 길이
    static int col;

    // maps를 클래스 전체에서 사용할 수 있도록 저장
    static String[] map;

    public int[] solution(String[] maps) {

        // 입력받은 maps를 전역 변수에 저장
        map = maps;

        // 지도의 세로 길이를 저장
        row = maps.length;

        // 지도의 가로 길이를 저장
        col = maps[0].length();

        // 방문 여부를 저장할 배열을 생성
        visited = new boolean[row][col];

        // 각 섬의 식량 합을 저장할 리스트
        List<Integer> result = new ArrayList<>();

        // 지도의 모든 행을 확인
        for (int i = 0; i < row; i++) {

            // 현재 행의 모든 열을 확인
            for (int j = 0; j < col; j++) {

                // 현재 칸이 바다가 아니고 아직 방문하지 않은 땅이라면
                if (map[i].charAt(j) != 'X' && !visited[i][j]) {

                    // DFS로 연결된 섬 전체를 탐색하고 식량 합을 구함
                    int sum = dfs(i, j);

                    // 구한 섬의 식량 합을 리스트에 저장
                    result.add(sum);
                }
            }
        }

        // 섬이 하나도 없다면 -1을 담은 배열을 반환
        if (result.isEmpty()) {
            return new int[]{-1};
        }

        // 섬의 식량 합들을 오름차순으로 정렬
        Collections.sort(result);

        // 리스트를 int 배열로 변환
        int[] answer = new int[result.size()];

        // 리스트의 값을 배열에 하나씩 옮김
        for (int i = 0; i < result.size(); i++) {

            // 리스트의 i번째 값을 answer 배열에 저장
            answer[i] = result.get(i);
        }

        // 최종 결과 배열을 반환
        return answer;
    }

    public int dfs(int x, int y) {

        // 현재 위치를 방문 처리
        visited[x][y] = true;

        // 현재 칸의 문자 숫자를 정수로 변환하여 sum에 저장
        int sum = map[x].charAt(y) - '0';

        // 상, 하, 좌, 우 네 방향을 확인
        for (int i = 0; i < 4; i++) {

            // 다음으로 이동할 행 위치
            int nx = x + dx[i];

            // 다음으로 이동할 열 위치
            int ny = y + dy[i];

            // 다음 위치가 지도 범위를 벗어나면 넘어감
            if (nx < 0 || ny < 0 || nx >= row || ny >= col) {
                continue;
            }

            // 다음 위치가 바다라면 넘어감
            if (map[nx].charAt(ny) == 'X') {
                continue;
            }

            // 다음 위치를 이미 방문했다면 넘어감
            if (visited[nx][ny]) {
                continue;
            }

            // 연결된 땅이라면 DFS를 이어서 실행하고 그 값을 sum에 더함
            sum += dfs(nx, ny);
        }

        // 현재 섬의 식량 합을 반환
        return sum;
    }
}