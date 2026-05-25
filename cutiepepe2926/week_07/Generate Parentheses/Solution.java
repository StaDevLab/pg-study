import java.util.*;

class Solution {

    List<String> answer = new ArrayList<>(); // 정답용
    StringBuilder temp = new StringBuilder(); // 각 경우의 수를 담을 보관용

    public List<String> generateParenthesis(int n) {

        dfs(n, 0, 0);

        return answer;
    }

    public void dfs(int n, int open, int close) {

        if (temp.length() == n * 2) {
            answer.add(temp.toString());
            return;
        }

        // 여는 괄호는 n개까지만 사용할 수 있음
        if (open < n) {
            temp.append("(");

            dfs(n, open + 1, close);

            temp.deleteCharAt(temp.length() - 1);
        }

        // 닫는 괄호는 여는 괄호보다 적게 사용했을 때만 사용할 수 있음
        if (close < open) {
            temp.append(")");

            dfs(n, open, close + 1);

            temp.deleteCharAt(temp.length() - 1);
        }
    }
}