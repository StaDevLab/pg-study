class Solution {

    int[] parent;
    int[] size;

    public int solution(int n, int[][] wires) {

        int answer = Integer.MAX_VALUE;

        // 전선을 하나씩 끊어보기
        for (int cut = 0; cut < wires.length; cut++) {

            parent = new int[n + 1];
            size = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }

            // 끊은 전선을 제외하고 연결
            for (int i = 0; i < wires.length; i++) {

                if (i == cut) {
                    continue;
                }

                int start = wires[i][0];
                int end = wires[i][1];

                union(start, end);
            }

            int start = wires[cut][0];
            int root = find(start);

            int count = size[root];
            int otherCount = n - count;

            answer = Math.min(
                    answer,
                    Math.abs(count - otherCount)
            );
        }

        return answer;
    }

    public int find(int node) {

        if (parent[node] == node) {
            return node;
        }

        return parent[node] = find(parent[node]);
    }

    public void union(int node1, int node2) {

        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 == root2) {
            return;
        }

        // 크기가 작은 그룹을 큰 그룹에 연결
        if (size[root1] < size[root2]) {
            int temp = root1;
            root1 = root2;
            root2 = temp;
        }

        parent[root2] = root1;
        size[root1] += size[root2];
    }
}