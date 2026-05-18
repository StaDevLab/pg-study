import java.util.*;

class Solution {
    public int solution(int[] elements) {

        HashSet<Integer> answer = new HashSet<>();

        int n = elements.length;

        // 구간 별
        for (int cp = 1; cp <= n; cp++) {

            // 시작 별
            for (int start = 0; start < n; start++) {

                int sum = 0;

                for (int i = 0; i < cp; i++) {
                    sum += elements[(start + i) % n];
                }

                answer.add(sum);
            }
        }

        return answer.size();
    }
}