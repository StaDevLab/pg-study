import java.util.*;

class Solution {

    String[] answer;
    boolean[] visited;
    boolean find = false;

    public String[] solution(String[][] tickets) {

        // 사전순으로 정렬
        Arrays.sort(tickets, (o1, o2) -> {
            if (o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        });

        visited = new boolean[tickets.length];

        // 현재까지의 이동 경로
        List<String> path = new ArrayList<>();
        path.add("ICN");

        dfs("ICN", 0, tickets, path);

        return answer;
    }

    public void dfs(String current, int depth, String[][] tickets, List<String> path) {

        // 이미 정답을 찾았다면 더 이상 탐색하지 않음
        if (find) {
            return;
        }

        // 모든 티켓을 사용한 경우
        if (depth == tickets.length) {
            answer = path.toArray(new String[0]);
            find = true;
            return;
        }

        // 사용할 수 있는 티켓 탐색
        for (int i = 0; i < tickets.length; i++) {

            if (visited[i]) {
                continue;
            }

            // 현재 공항에서 출발하는 티켓인지 확인
            if (!tickets[i][0].equals(current)) {
                continue;
            }

            visited[i] = true;
            path.add(tickets[i][1]);

            // 다음 공항으로 이동
            dfs(tickets[i][1], depth + 1, tickets, path);

            // 백트래킹
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}