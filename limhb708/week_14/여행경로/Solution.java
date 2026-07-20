import java.util.*;

class Solution {

    // 최종 정답 경로를 저장할 리스트
    private List<String> answer = new ArrayList<>();

    // 정답을 찾았는지 여부
    private boolean found = false;

    public String[] solution(String[][] tickets) {

        // 사전순 경로를 먼저 찾기 위해 티켓을 정렬한다.
        Arrays.sort(tickets, (a, b) -> {

            // 출발지가 같으면 도착지 기준 정렬
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }

            // 출발지가 다르면 출발지 기준 정렬
            return a[0].compareTo(b[0]);
        });

        // 각 티켓의 사용 여부를 저장하는 배열
        boolean[] visited = new boolean[tickets.length];

        // 현재 만들고 있는 여행 경로
        List<String> path = new ArrayList<>();

        // 항상 ICN에서 출발
        path.add("ICN");

        // DFS 백트래킹 시작
        dfs(
                "ICN",
                tickets,
                visited,
                path
        );

        // List를 String 배열로 변환 후 반환
        return answer.toArray(new String[0]);
    }

    private void dfs(
            String current,
            String[][] tickets,
            boolean[] visited,
            List<String> path
    ) {

        // 이미 정답을 찾았다면 종료
        if (found) {
            return;
        }

        // 모든 티켓을 사용했다면
        if (path.size() == tickets.length + 1) {

            // 현재 경로를 복사해서 저장
            answer = new ArrayList<>(path);

            // 정답 찾음 표시
            found = true;

            return;
        }

        // 모든 티켓을 확인
        for (int i = 0; i < tickets.length; i++) {

            // 이미 사용한 티켓이면 건너뜀
            if (visited[i]) {
                continue;
            }

            // 현재 공항에서 출발하는 티켓이 아니면 건너뜀
            if (!tickets[i][0].equals(current)) {
                continue;
            }

            // 현재 티켓 사용 처리
            visited[i] = true;

            // 도착 공항을 경로에 추가
            path.add(tickets[i][1]);

            // 다음 공항으로 이동
            dfs(
                    tickets[i][1],
                    tickets,
                    visited,
                    path
            );

            // 방금 추가한 공항 제거
            path.remove(path.size() - 1);

            // 티켓 사용 취소
            visited[i] = false;
        }
    }
}