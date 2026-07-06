import java.util.Arrays;

class Solution {

    public int solution(int[] people, int limit) {

        // 몸무게 오름차순 정렬
        Arrays.sort(people);

        // 가장 가벼운 사람 위치
        int left = 0;

        // 가장 무거운 사람 위치
        int right = people.length - 1;

        // 필요한 보트 수
        int answer = 0;

        // 모든 사람을 태울 때까지 반복
        while (left <= right) {

            // 가장 가벼운 사람과 가장 무거운 사람이 같이 탈 수 있는 경우
            if (people[left] + people[right] <= limit) {

                // 가벼운 사람도 태움
                left++;
            }

            // 무거운 사람은 항상 현재 보트에 태움
            right--;

            // 보트 한 대 사용
            answer++;
        }

        // 최소 보트 수 반환
        return answer;
    }
}