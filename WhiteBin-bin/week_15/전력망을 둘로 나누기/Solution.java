class Solution {

    private int[] parent;

    public int solution(int n, int[][] wires) {
        int answer = n;

        for (int cut = 0; cut < wires.length; cut++) {
            parent = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < wires.length; i++) {
                if (i == cut) {
                    continue;
                }

                int a = wires[i][0];
                int b = wires[i][1];

                union(a, b);
            }

            int count = 0;
            int root = find(1);

            for (int i = 1; i <= n; i++) {
                if (find(i) == root) {
                    count++;
                }
            }

            int other = n - count;
            answer = Math.min(answer, Math.abs(count - other));
        }

        return answer;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return;
        }

        parent[rootB] = rootA;
    }
}