import java.util.HashSet;
import java.util.Set;

class Solution {

    public int solution(int[] elements) {

        // 원래 수열 길이
        int n = elements.length;

        // 원형 처리를 위해 길이를 2배로 본 prefix 배열
        int[] prefix = new int[n * 2 + 1];

        // 두 바퀴 길이만큼 누적합 생성
        for (int i = 0; i < n * 2; i++) {
            prefix[i + 1] = prefix[i] + elements[i % n];
        }

        // 만들 수 있는 부분 수열 합 저장
        Set<Integer> sums = new HashSet<>();

        // 부분 수열 길이
        for (int length = 1; length <= n; length++) {

            // 시작 위치
            for (int start = 0; start < n; start++) {

                // start부터 length개를 더한 값
                int sum = prefix[start + length] - prefix[start];

                // 중복 제거하면서 저장
                sums.add(sum);
            }
        }

        // 서로 다른 합의 개수 반환
        return sums.size();
    }
}