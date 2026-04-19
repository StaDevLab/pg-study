import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {

        int[] answer = new int[num_list.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int nl : num_list) {
            stack.push(nl);
        }

        for (int i = 0; i < num_list.length; i++) {
            answer[i] = stack.pop();
        }

        return answer;

    }
}