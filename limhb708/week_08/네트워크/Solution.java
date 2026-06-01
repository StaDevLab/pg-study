class Solution {

    // 각 컴퓨터를 방문했는지 확인하는 배열
    static boolean[] visited;

    // 컴퓨터 연결 정보를 저장할 배열
    static int[][] computerMap;

    // 컴퓨터 개수를 저장하는 변수
    static int computerCount;

    public int solution(int n, int[][] computers) {

        // 네트워크 개수를 저장할 변수
        int answer = 0;

        // 컴퓨터 개수를 전역 변수에 저장
        computerCount = n;

        // 연결 정보를 전역 변수에 저장
        computerMap = computers;

        // 방문 여부를 저장할 배열을 생성
        visited = new boolean[n];

        // 0번 컴퓨터부터 n - 1번 컴퓨터까지 확인
        for (int i = 0; i < n; i++) {

            // 아직 방문하지 않은 컴퓨터라면 새로운 네트워크
            if (!visited[i]) {

                // 현재 컴퓨터와 연결된 모든 컴퓨터를 DFS로 방문
                dfs(i);

                // DFS가 한 번 실행되면 네트워크 하나를 찾음
                answer++;
            }
        }

        // 최종 네트워크 개수를 반환
        return answer;
    }

    public void dfs(int currentComputer) {

        // 현재 컴퓨터를 방문 처리
        visited[currentComputer] = true;

        // 현재 컴퓨터와 연결된 다른 컴퓨터들을 확인
        for (int nextComputer = 0; nextComputer < computerCount; nextComputer++) {

            // 현재 컴퓨터와 nextComputer가 연결되어 있고
            // nextComputer를 아직 방문하지 않았다면 탐색
            if (computerMap[currentComputer][nextComputer] == 1 && !visited[nextComputer]) {

                // 연결된 컴퓨터로 이동해서 DFS를 계속 진행
                dfs(nextComputer);
            }
        }
    }
}