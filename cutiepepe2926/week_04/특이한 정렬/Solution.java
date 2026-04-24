import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {

        int[] answer = new int[numlist.length];

        Integer[] temp = new Integer[numlist.length];

        int idx = 0;

        for (Integer t : numlist) {
            temp[idx++] = t;
        }

        Arrays.sort(temp, (a,b) -> {

            int absA = Math.abs(n-a);
            int absB = Math.abs(n-b);

            if (absA != absB) {
                return Integer.compare(absA, absB);
            }
            return Integer.compare(b, a);
        });

        idx = 0;

        for (int t : temp) {
            answer[idx++] = t;
        }

        return answer;

    }
}