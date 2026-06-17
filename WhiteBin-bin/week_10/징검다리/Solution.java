import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        
        int answer = 0;
        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance;
        
        while (left <= right) {
            
            int mid = (left + right) / 2;     
            int removedRocks = 0; 
            int prev = 0;        
        
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid) {
                    removedRocks++; 
                } else {
                    prev = rocks[i];
                }
            }
         
            if (distance - prev < mid) {
                removedRocks++;
            }
            
            if (removedRocks > n) {
                right = mid - 1;
            } else {
                answer = mid; 
                left = mid + 1;
            }
        }
        
        return answer;
    }
}