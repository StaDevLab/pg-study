import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {

        int answer = 0; // 사라진 인형의 총 개수를 저장할 변수
        Stack<Integer> basket = new Stack<>(); // 인형을 담을 바구니 (스택)

        // 크레인이 움직이는 위치(moves)를 하나씩 순회
        for (int move : moves) {
            int col = move - 1; // 1부터 시작하는 열 번호를 0부터 시작하는 배열 인덱스로 변환

            // 위에서부터 아래로 인형이 있는지 탐색 (행 순회)
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] != 0) { // 0이 아니면 인형이 있는 것
                    int doll = board[row][col]; // 인형의 종류(번호)를 가져옴
                    board[row][col] = 0; // 인형을 뽑았으므로 해당 자리를 0(빈칸)으로 처리

                    // 스택이 비어있지 않고, 바구니의 맨 위 인형과 현재 뽑은 인형이 같다면
                    if (!basket.isEmpty() && basket.peek() == doll) {
                        basket.pop(); // 바구니에서 맨 위 인형을 제거
                        answer += 2; // 사라진 인형 2개를 카운트
                    } else {
                        // 스택이 비어있거나 인형이 같지 않으면 바구니에 인형을 추가
                        basket.push(doll);
                    }

                    break; // 인형을 하나 뽑았으면 해당 move는 종료, 다음 move로 이동
                }
            }
        }

        return answer;
    }
}
