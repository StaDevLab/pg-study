import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int answer = 0;
        int maxWidth=0;
        int maxHeight=0;
        
        for (int i = 0; i < sizes.length; i++){
            
            int v = Math.max(sizes[i][0],sizes[i][1]);
            int h = Math.min(sizes[i][0],sizes[i][1]);
            maxWidth = Math.max(maxWidth,v);
            maxHeight = Math.max(maxHeight,h);
        }
        return answer = maxWidth * maxHeight;
    }
}
