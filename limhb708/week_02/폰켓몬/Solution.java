import java.util.*;

class Solution { // 클래스 선언
    public int solution(int[] nums) { // solution 메서드: 배열을 입력받아 결과 반환

        int max = nums.length / 2; // 선택할 수 있는 최대 개수 = 전체 길이의 절반

        HashSet<Integer> kinds = new HashSet<>(); // 중복을 제거하고 종류 수를 세기 위한 HashSet 생성

        for (int num : nums) { // 배열의 각 원소를 순회
            kinds.add(num);    // HashSet에 추가 → 자동으로 중복 제거됨
        }

        // 종류 수와 선택 가능 수 중 작은 값을 반환
        return Math.min(kinds.size(), max);
    }
}