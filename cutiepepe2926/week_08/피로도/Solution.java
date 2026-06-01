class Solution {

    static boolean[] visited; // 방문체크용
    static int[][] dungeon; // 던전 정보
    static int answer; // 최대 탐험 가능 던전 수

    public int solution(int k, int[][] dungeons) {

        answer = 0;
        dungeon = dungeons;
        visited = new boolean[dungeons.length];

        // dfs 순회로 모든 던전 순서 탐색
        dfs(k, 0);

        return answer;
    }

    static void dfs(int piro, int count) {

        // 현재까지 탐험한 던전 수 중 최댓값 저장
        answer = Math.max(answer, count);

        // 각 던전을 순회
        for (int i = 0; i < dungeon.length; i++) {

            // 이미 방문했다면 무시
            if (visited[i]) {
                continue;
            }

            // 현재 피로도가 최소 필요 피로도보다 부족하면 무시
            if (piro < dungeon[i][0]) {
                continue;
            }

            // 해당 던전 방문 체크
            visited[i] = true;

            // 던전 탐험 후 남은 피로도로 dfs 순회
            dfs(piro - dungeon[i][1], count + 1);

            // 다른 순서에서도 방문할 수 있도록 방문 해제
            visited[i] = false;
        }
    }
}