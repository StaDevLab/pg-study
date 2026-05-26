import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {

        // 올바른 괄호 조합들을 저장할 리스트
        List<String> answer = new ArrayList<>();

        // 현재 만들고 있는 괄호 문자열
        StringBuilder current = new StringBuilder();

        // 백트래킹을 시작
        dfs(n, 0, 0, current, answer);

        // 모든 괄호 조합을 반환
        return answer;
    }

    private void dfs(
            int n,
            int open,
            int close,
            StringBuilder current,
            List<String> answer
    ) {

        // 현재 문자열의 길이가 2 * n이면 괄호를 모두 사용한 상태
        if (current.length() == 2 * n) {

            // 완성된 괄호 문자열을 정답 리스트에 추가
            answer.add(current.toString());

            // 현재 탐색을 종료하고 이전 단계로 돌아감
            return;
        }

        // 여는 괄호를 아직 n개보다 적게 사용했다면 추가할 수 있음
        if (open < n) {

            // 현재 문자열에 여는 괄호를 추가
            current.append('(');

            // 여는 괄호 개수를 1 증가시키고 다음 단계로 이동
            dfs(n, open + 1, close, current, answer);

            // 방금 추가한 여는 괄호를 제거해서 이전 상태로 되돌림
            current.deleteCharAt(current.length() - 1);
        }

        // 닫는 괄호는 여는 괄호보다 적게 사용한 경우에만 추가할 수 있음
        if (close < open) {

            // 현재 문자열에 닫는 괄호를 추가
            current.append(')');

            // 닫는 괄호 개수를 1 증가시키고 다음 단계로 이동
            dfs(n, open, close + 1, current, answer);

            // 방금 추가한 닫는 괄호를 제거해서 이전 상태로 되돌림
            current.deleteCharAt(current.length() - 1);
        }
    }
}