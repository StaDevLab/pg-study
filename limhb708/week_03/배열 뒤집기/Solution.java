import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {

        int[] answer = new int[num_list.length];

        // 정수를 저장할 Stack 객체를 생성합니다.
        Stack<Integer> stack = new Stack<>();

        // 1. 스택에 값 넣기: num_list의 요소를 순서대로 스택에 push합니다.
        for (int num : num_list) {
            stack.push(num); // LIFO 구조로 나중에 들어간 게 위에 쌓입니다.
        }

        // 2. 스택에서 꺼내면서 뒤집기: 스택이 빌 때까지 pop하여 answer 배열에 채웁니다.
        for (int i = 0; i < num_list.length; i++) {
            // 스택의 맨 위(마지막에 들어간 값)부터 꺼내어 순서대로 배열에 넣습니다.
            answer[i] = stack.pop();
        }

        // 뒤집힌 배열을 반환합니다.
        return answer;
    }
}