import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        // 목적지 n에서 0으로 거꾸로 이동
        while (n > 0) {

            // 홀수인 경우에는 순간이동만으로 올 수 없으므로 1칸 점프한 것으로 처리
            if (n % 2 == 1) {
                n--;
                ans++;
            }

            // 짝수인 경우에는 순간이동으로 온 것이므로 현재 거리를 절반으로 줄이기
            n /= 2;
        }

        return ans;
    }
}