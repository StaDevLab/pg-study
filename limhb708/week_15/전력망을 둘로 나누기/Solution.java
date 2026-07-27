import java.util.*;

class Solution {

    // 방문 여부 배열
    private boolean[] visited;

    public int solution(
            int n,
            int[][] wires
    ) {

        // 최소 차이 저장
        int answer = Integer.MAX_VALUE;

        // 모든 전선을 하나씩 끊어본다.
        for (int cut = 0; cut < wires.length; cut++) {

            // 그래프 생성
            List<Integer>[] graph =
                    new ArrayList[n + 1];

            // 인접리스트 초기화
            for (int i = 1; i <= n; i++) {

                graph[i] = new ArrayList<>();
            }

            // 현재 끊을 전선을 제외하고 그래프 구성
            for (int i = 0; i < wires.length; i++) {

                // 현재 전선은 제거
                if (i == cut) {
                    continue;
                }

                // 시작 송전탑
                int a = wires[i][0];

                // 도착 송전탑
                int b = wires[i][1];

                // 양방향 연결
                graph[a].add(b);

                // 양방향 연결
                graph[b].add(a);
            }

            // 방문 배열 생성
            visited = new boolean[n + 1];

            // 한쪽 네트워크 크기 계산
            int count = dfs(
                    1,
                    graph
            );

            // 다른 네트워크 크기
            int other = n - count;

            // 두 네트워크 차이 계산
            int diff = Math.abs(
                    count - other
            );

            // 최소값 갱신
            answer = Math.min(
                    answer,
                    diff
            );
        }

        // 정답 반환
        return answer;
    }

    private int dfs(
            int current,
            List<Integer>[] graph
    ) {

        // 현재 노드 방문 처리
        visited[current] = true;

        // 현재 노드 포함
        int count = 1;

        // 연결된 노드 확인
        for (int next : graph[current]) {

            // 이미 방문했다면 건너뜀
            if (visited[next]) {
                continue;
            }

            // 연결된 노드 개수 누적
            count += dfs(
                    next,
                    graph
            );
        }

        // 현재 네트워크 크기 반환
        return count;
    }
}