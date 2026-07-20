import java.util.*;

class Solution {

    int answer = 0;
    List<Integer>[] graph;

    public int solution(int[] info, int[][] edges) {

        graph = new ArrayList[info.length];

        for (int i = 0; i < info.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }

        List<Integer> next = new ArrayList<>();
        next.add(0);

        dfs(info, next, 0, 0);

        return answer;
    }

    public void dfs(int[] info, List<Integer> next, int yang, int wolf) {

        for (int now : next) {

            int nextYang = yang;
            int nextWolf = wolf;

            if (info[now] == 0) {
                nextYang++;
            } else {
                nextWolf++;
            }

            // 늑대가 같거나 많아지는 순간 종료
            if (nextWolf >= nextYang) {
                continue;
            }

            answer = Math.max(answer, nextYang);

            List<Integer> nextList = new ArrayList<>(next);
            nextList.remove(Integer.valueOf(now));

            for (int child : graph[now]) {
                nextList.add(child);
            }

            dfs(info, nextList, nextYang, nextWolf);
        }
    }
}