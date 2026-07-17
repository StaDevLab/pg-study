import java.util.*;

class Solution {

    private int[] info;
    private List<Integer>[] children;
    private int answer;

    public int solution(int[] info, int[][] edges) {
        this.info = info;
        this.answer = 0;

        children = new ArrayList[info.length];

        for (int i = 0; i < info.length; i++) {
            children[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];

            children[parent].add(child);
        }

        List<Integer> candidates = new ArrayList<>();
        candidates.add(0);

        dfs(0, 0, candidates);

        return answer;
    }

    private void dfs(
        int sheep,
        int wolf,
        List<Integer> candidates
    ) {
        for (int i = 0; i < candidates.size(); i++) {
            int current = candidates.get(i);

            int nextSheep = sheep;
            int nextWolf = wolf;

            if (info[current] == 0) {
                nextSheep++;
            } else {
                nextWolf++;
            }

            if (nextWolf >= nextSheep) {
                continue;
            }

            answer = Math.max(answer, nextSheep);

            List<Integer> nextCandidates = new ArrayList<>(candidates);
            nextCandidates.remove(i);

            nextCandidates.addAll(children[current]);

            dfs(nextSheep, nextWolf, nextCandidates);
        }
    }
}