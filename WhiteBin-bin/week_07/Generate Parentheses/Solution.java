import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();

        backtrack(answer, new StringBuilder(), 0, 0, n);

        return answer;
    }

    private void backtrack(List<String> answer, StringBuilder current, int open, int close, int n) {
        if (current.length() == n * 2) {
            answer.add(current.toString());
            return;
        }

        if (open < n) {
            current.append("(");
            backtrack(answer, current, open + 1, close, n);
            current.deleteCharAt(current.length() - 1);
        }

        if (close < open) {
            current.append(")");
            backtrack(answer, current, open, close + 1, n);
            current.deleteCharAt(current.length() - 1);
        }
    }
}