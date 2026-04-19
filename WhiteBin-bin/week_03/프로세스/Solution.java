import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        
        for (int num : priorities) {
            que.offer(num);
        }
        
        while(!que.isEmpty()) {
            
            for (int i = 0; i < priorities.length; i++) {
                
                if (que.peek() == priorities[i]) {
                    que.poll();
                    answer++;

                    if (location == i) {
                        return answer;
                    }
                }
            }
        }
        
        return answer;
        
    }
}