import java.util.*;

class Solution {
    public int solution(int[] nums) {

        // 중복 제거용
        HashSet<Integer> rmDup = new HashSet<>();

        for (int n : nums) {
            rmDup.add(n);
        }

        // n2값 변수
        int n2 = nums.length / 2;

        // n2와 rmDup 중 가장 작은 값이 곧 선택가능한 종류 최댓값
        return Math.min(n2,rmDup.size());

    }
}