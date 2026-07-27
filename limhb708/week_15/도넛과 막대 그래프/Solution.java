import java.util.*;

class Solution {

    public int[] solution(int[][] edges) {

        // 정점 번호의 최댓값 저장
        int maxNode = 0;

        // 최대 정점 번호 찾기
        for (int[] edge : edges) {

            maxNode = Math.max(maxNode, Math.max(edge[0], edge[1]));
        }

        // 진입 차수 저장
        int[] indegree = new int[maxNode + 1];

        // 진출 차수 저장
        int[] outdegree = new int[maxNode + 1];

        // 모든 간선 확인
        for (int[] edge : edges) {

            // 출발 정점
            int from = edge[0];

            // 도착 정점
            int to = edge[1];

            // 진출 차수 증가
            outdegree[from]++;

            // 진입 차수 증가
            indegree[to]++;
        }

        // 생성한 정점 번호
        int createdNode = 0;

        // 막대 그래프 개수
        int stick = 0;

        // 8자 그래프 개수
        int eight = 0;

        // 모든 정점 확인
        for (int i = 1; i <= maxNode; i++) {

            // 생성한 정점 찾기
            if (indegree[i] == 0 && outdegree[i] >= 2) {

                createdNode = i;
            }

            // 막대 그래프의 끝 정점
            if (indegree[i] >= 1 && outdegree[i] == 0) {

                stick++;
            }

            // 8자 그래프 중심 정점
            if (indegree[i] >= 2 && outdegree[i] == 2) {

                eight++;
            }
        }

        // 생성 정점에서 나가는 간선 수
        int totalGraph = outdegree[createdNode];

        // 도넛 그래프 개수 계산
        int donut = totalGraph - stick - eight;

        // 정답 반환
        return new int[]{
                createdNode,
                donut,
                stick,
                eight
        };
    }
}