import java.util.*;

class Solution {
    public int solution(int[] ingredient) {

        int answer = 0; // 햄버거 완성 횟수를 저장할 변수
        Stack<Integer> stack = new Stack<>(); // 재료를 임시로 쌓아둘 스택 선언

        for (int i = 0; i < ingredient.length; i++) { // 재료 배열을 처음부터 순회
            stack.push(ingredient[i]); // 현재 재료를 스택에 무조건 push

            // 스택에 4개 이상 쌓였을 때만 햄버거 조합(1-2-3-1) 확인
            if (stack.size() >= 4) {
                int size = stack.size(); // 스택의 현재 크기 가져오기

                // 스택 맨 위 4개의 재료가 1, 2, 3, 1 순서인지 확인 (빵-야채-고기-빵)
                if (stack.get(size - 4) == 1 &&
                        stack.get(size - 3) == 2 &&
                        stack.get(size - 2) == 3 &&
                        stack.get(size - 1) == 1) {

                    // 햄버거가 완성되었으므로, 스택에서 4개 재료 제거 (pop)
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();

                    answer++; // 햄버거 완성 횟수 1 증가
                }
            }
        }

        return answer;
    }
}
