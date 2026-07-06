import java.util.TreeSet;

class Solution {

    public int[] solution(int[] numbers) {

        // 중복 제거와 오름차순 정렬을 동시에 처리
        TreeSet<Integer> set = new TreeSet<>();

        // 서로 다른 두 인덱스 선택
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {

                // 두 수의 합 저장
                set.add(numbers[i] + numbers[j]);
            }
        }

        // 정답 배열 생성
        int[] answer = new int[set.size()];

        // 배열 인덱스
        int index = 0;

        // TreeSet은 오름차순으로 값을 꺼냄
        for (int value : set) {
            answer[index++] = value;
        }

        // 결과 반환
        return answer;
    }
}