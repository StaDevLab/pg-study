import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {

        Arrays.sort(people);

        int answer = 0;

        for (int i = 0, j = people.length - 1; i < people.length && j >= 0;) {
            if (i > j) break;
            if (people[i] + people[j] <= limit) {
                answer++;
                i++; j--;
            }
            else {
                answer++;
                j--;
            }
        }

        return answer;
    }
}