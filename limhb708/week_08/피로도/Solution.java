class Solution {

    // 탐험할 수 있는 최대 던전 수를 저장하는 변수
    static int answer;

    // 각 던전을 방문했는지 확인하는 배열
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {

        // 최대 탐험 던전 수를 0으로 초기화
        answer = 0;

        // 던전 개수만큼 방문 배열을 생성합니다.
        visited = new boolean[dungeons.length];

        // 현재 피로도 k에서 DFS 탐색을 시.
        dfs(k, dungeons, 0);

        // 최대로 탐험할 수 있는 던전 수를 반환
        return answer;
    }

    public void dfs(int currentFatigue, int[][] dungeons, int count) {

        // 현재까지 탐험한 던전 수와 기존 최대값을 비교해 더 큰 값으로 갱신
        answer = Math.max(answer, count);

        // 모든 던전을 하나씩 확인
        for (int i = 0; i < dungeons.length; i++) {

            // i번째 던전의 최소 필요 피로도
            int requiredFatigue = dungeons[i][0];

            // i번째 던전의 소모 피로도
            int usedFatigue = dungeons[i][1];

            // 아직 방문하지 않은 던전이고 현재 피로도가 최소 필요 피로도 이상이라면 탐험할 수 있음
            if (!visited[i] && currentFatigue >= requiredFatigue) {

                // i번째 던전을 방문 처
                visited[i] = true;

                // i번째 던전을 탐험한 뒤 소모 피로도를 뺀 상태로 다음 DFS를 진행
                dfs(currentFatigue - usedFatigue, dungeons, count + 1);

                // 다른 순서의 경우도 확인해야 하므로 방문 처리를 다시 취소
                visited[i] = false;
            }
        }
    }
}
