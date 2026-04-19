import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {

        // 결과 값
        int answer = 0;

        // 바구니
        Deque<Integer> bucket = new ArrayDeque<>();

        // 각 턴 별 가로 축 움직이기
        for (int turn = 0; turn < moves.length; turn++) {

            // 하강 (board의 1차 갯수가 깊이와 같음)
            for (int depth = 0; depth < board.length; depth++) {

                // 인형 발견 시
                if (board[depth][moves[turn] - 1] != 0) {

                    // 인형 추가 전 터지는 지 체크
                    if (!bucket.isEmpty() && bucket.peek() == board[depth][moves[turn] - 1]) {

                        // 인형 터뜨리기
                        bucket.pop();
                        answer += 2;

                        // 뺀 인형 반영
                        board[depth][moves[turn] - 1] = 0;

                    }

                    else {

                        // 인형 추가
                        bucket.push(board[depth][moves[turn] - 1]);

                        // 뺀 인형 반영
                        board[depth][moves[turn] - 1] = 0;
                    }

                    // 다음 턴
                    break;

                }

            }

        }


        return answer;
    }
}