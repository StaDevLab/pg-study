class Solution {

    static boolean[] visited; // 방문체크용
    static int[][] network;

    public int solution(int n, int[][] computers) {

        int answer = 0;
        visited = new boolean[n];
        network = computers;

        // 각 컴퓨터를 순회
        for (int i = 0; i < n; i++) {

            // 이미 방문했다면 무시
            if (!visited[i]) {

                // dfs 순회로 연결된 네트워크 탐지
                dfs(i);

                answer++;
            }

        }

        return answer;

    }

    static void dfs(int node) {

        // 해당 노드 방문 체크
        visited[node] = true;

        // 연결된 만큼 방문 + 방문여부 체크
        for (int i = 0; i < network.length; i++) {
            if (network[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }

    }

}