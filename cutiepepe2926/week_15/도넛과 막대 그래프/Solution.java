class Solution {

    //테케 35번이 계속 실패가 됨.
    //문제에는 없는데, 정점의 번호가 순차적으로 주어진다는 보장이 없어서 해당 테스트 케이스에서
    //문제가 생겼던거였음...

    public int[] solution(int[][] edges) {

        int maxNode = 1000000;

        int[] in = new int[maxNode + 1];
        int[] out = new int[maxNode + 1];

        // 실제 존재하는 정점인지 확인
        boolean[] exists = new boolean[maxNode + 1];

        for (int[] edge : edges) {

            int from = edge[0];
            int to = edge[1];

            out[from]++;
            in[to]++;

            exists[from] = true;
            exists[to] = true;
        }

        int createNode = 0;

        // 생성한 정점 찾기
        for (int node = 1; node <= maxNode; node++) {

            if (!exists[node]) {
                continue;
            }

            if (in[node] == 0 && out[node] >= 2) {
                createNode = node;
                break;
            }
        }

        int bar = 0;
        int eight = 0;

        for (int node = 1; node <= maxNode; node++) {

            if (!exists[node] || node == createNode) {
                continue;
            }

            // 막대 그래프의 마지막 정점
            if (out[node] == 0) {
                bar++;
            }

            // 8자 그래프의 중앙 정점
            if (in[node] >= 2 && out[node] == 2) {
                eight++;
            }
        }

        int total = out[createNode];
        int donut = total - bar - eight;

        return new int[]{createNode, donut, bar, eight};
    }
}