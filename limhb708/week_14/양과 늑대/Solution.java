import java.util.*;

class Solution {

    // 최대로 모을 수 있는 양의 수
    private int answer = 0;

    // 트리를 저장할 인접리스트
    private List<Integer>[] graph;

    public int solution(int[] info, int[][] edges) {

        // 노드 개수만큼 리스트 생성
        graph = new ArrayList[info.length];

        // 각 노드의 자식 저장 공간 생성
        for (int i = 0; i < info.length; i++) {

            graph[i] = new ArrayList<>();
        }

        // 트리 구성
        for (int[] edge : edges) {

            // 부모 -> 자식 연결
            graph[edge[0]].add(edge[1]);
        }

        // 현재 방문 가능한 노드들
        List<Integer> nextNodes = new ArrayList<>();

        // 처음에는 루트만 방문 가능
        nextNodes.add(0);

        // DFS 시작
        dfs(
                0,
                0,
                nextNodes,
                info
        );

        // 최대 양 개수 반환
        return answer;
    }

    private void dfs(
            int sheep,
            int wolf,
            List<Integer> nextNodes,
            int[] info
    ) {

        // 현재까지 모은 양 수 갱신
        answer = Math.max(answer, sheep);

        // 현재 방문 가능한 모든 노드 확인
        for (int current : nextNodes) {

            // 현재 상태 복사
            int nextSheep = sheep;

            // 현재 상태 복사
            int nextWolf = wolf;

            // 현재 노드가 양인 경우
            if (info[current] == 0) {

                nextSheep++;
            }

            // 현재 노드가 늑대인 경우
            else {

                nextWolf++;
            }

            // 늑대가 같거나 많아지는 순간 실패
            if (nextWolf >= nextSheep) {

                continue;
            }

            // 후보 노드 리스트 복사
            List<Integer> candidates =
                    new ArrayList<>(nextNodes);

            // 현재 방문한 노드는 제거
            candidates.remove(Integer.valueOf(current));

            // 현재 노드의 자식들을 추가
            candidates.addAll(graph[current]);

            // 다음 상태 탐색
            dfs(
                    nextSheep,
                    nextWolf,
                    candidates,
                    info
            );
        }
    }
}