import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {

        HashSet<Integer> temp = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) continue;
                temp.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[temp.size()];

        int idx = 0;

        for (int r : temp) {
            answer[idx++] = r;
        }

        Arrays.sort(answer);

        return answer;

    }
}