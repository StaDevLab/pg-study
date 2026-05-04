import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        int n = elements.length;

        for (int len = 1; len <= n; len++) {
            int sum = 0;

            for (int i = 0; i < len; i++) {
                sum += elements[i];
            }

            set.add(sum);

            for (int start = 1; start < n; start++) {
                sum -= elements[start - 1];
                sum += elements[(start + len - 1) % n];

                set.add(sum);
            }
        }

        return set.size();
    }
}