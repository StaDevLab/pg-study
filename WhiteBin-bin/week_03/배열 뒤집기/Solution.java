import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[num_list.length];
        
        for(int num : num_list) {
            stack.push(num);
        }
        
        while(!stack.isEmpty()) {
            
            for (int i = 0; i < arr.length; i++) {
                arr[i] = stack.pop();
            }
        }
        
        return arr;
    }
}