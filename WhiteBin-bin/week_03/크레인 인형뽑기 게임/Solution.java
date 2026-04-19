import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        
        for (int move : moves) {
            int col = move - 1;
            
            for (int i = 0; i < board.length; i++) {
                if (board[i][col] != 0) {
                    int doll = board[i][col];
                    board[i][col] = 0;
                    
                    if (!stack.isEmpty() && stack.peek() == doll) {
                        stack.pop();
                        count += 2;
                    } else {
                        stack.push(doll);
                    }
                    
                    break;
                }
            }
        }
        
        return count;
    }
}