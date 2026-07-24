class Solution {

    private static final int MAX_VERTEX = 1_000_000;

    private int[] parent;
    private int[] rank;

    public int[] solution(int[][] edges) {

        int[] inDegree = new int[MAX_VERTEX + 1];
        int[] outDegree = new int[MAX_VERTEX + 1];
        boolean[] exists = new boolean[MAX_VERTEX + 1];

        int maxVertex = 0;

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            outDegree[from]++;
            inDegree[to]++;

            exists[from] = true;
            exists[to] = true;

            maxVertex = Math.max(maxVertex, Math.max(from, to));
        }

        int createdVertex = 0;

        for (int vertex = 1; vertex <= maxVertex; vertex++) {
            if (inDegree[vertex] == 0 && outDegree[vertex] >= 2) {
                createdVertex = vertex;
                break;
            }
        }

        parent = new int[maxVertex + 1];
        rank = new int[maxVertex + 1];

        for (int vertex = 1; vertex <= maxVertex; vertex++) {
            parent[vertex] = vertex;
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            if (from == createdVertex) {
                continue;
            }

            union(from, to);
        }

        int[] vertexCount = new int[maxVertex + 1];
        int[] edgeCount = new int[maxVertex + 1];

        for (int vertex = 1; vertex <= maxVertex; vertex++) {

            if (!exists[vertex] || vertex == createdVertex) {
                continue;
            }

            int root = find(vertex);
            vertexCount[root]++;
        }

        for (int[] edge : edges) {
            int from = edge[0];

            if (from == createdVertex) {
                continue;
            }

            int root = find(from);
            edgeCount[root]++;
        }

        int donutCount = 0;
        int barCount = 0;
        int eightCount = 0;

        for (int vertex = 1; vertex <= maxVertex; vertex++) {

            if (parent[vertex] != vertex || vertexCount[vertex] == 0) {
                continue;
            }

            int vertices = vertexCount[vertex];
            int graphEdges = edgeCount[vertex];

            if (graphEdges == vertices) {
                donutCount++;
            } else if (graphEdges == vertices - 1) {
                barCount++;
            } else if (graphEdges == vertices + 1) {
                eightCount++;
            }
        }

        return new int[]{
                createdVertex,
                donutCount,
                barCount,
                eightCount
        };
    }

    private int find(int vertex) {

        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent[vertex]);
        }

        return parent[vertex];
    }

    private void union(int vertex1, int vertex2) {

        int root1 = find(vertex1);
        int root2 = find(vertex2);

        if (root1 == root2) {
            return;
        }

        if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
        } else if (rank[root1] > rank[root2]) {
            parent[root2] = root1;
        } else {
            parent[root2] = root1;
            rank[root1]++;
        }
    }
}