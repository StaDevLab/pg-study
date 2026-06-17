import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;
        int answer = right;
        
        while (left <= right) {
            int mid = left + (right - left) / 2; 
            
            if (isPossible(mid, diffs, times, limit)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    private boolean isPossible(int level, int[] diffs, int[] times, long limit) {
        long totalTime = 0;
        
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                
                totalTime += times[i];
            } else {
                
                long mistakes = diffs[i] - level;
                long timePrev = (i == 0) ? 0 : times[i - 1];      
                totalTime += mistakes * (times[i] + timePrev) + times[i];
            }
            
            if (totalTime > limit) {
                return false;
            }
        }
        
        return true;
    }
}