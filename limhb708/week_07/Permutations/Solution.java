import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {

        // 모든 순열 결과를 저장할 리스트
        List<List<Integer>> answer = new ArrayList<>();

        // 현재 만들고 있는 순열을 저장할 리스트
        List<Integer> current = new ArrayList<>();

        // 각 숫자가 현재 순열에 사용되었는지 체크하는 배열
        boolean[] visited = new boolean[nums.length];

        // 백트래킹을 시작
        backtrack(nums, visited, current, answer);

        // 모든 순열이 저장된 결과를 반환
        return answer;
    }

    private void backtrack(
            int[] nums,
            boolean[] visited,
            List<Integer> current,
            List<List<Integer>> answer
    ) {

        // 현재 순열의 길이가 nums 배열 길이와 같다면 하나의 순열이 완성
        if (current.size() == nums.length) {

            // current는 계속 재사용되는 리스트이므로 새로운 리스트로 복사해서 저장
            answer.add(new ArrayList<>(current));

            // 현재 경우의 처리를 끝내고 이전 단계로 돌아감
            return;
        }

        // nums 배열의 모든 숫자를 하나씩 확인
        for (int i = 0; i < nums.length; i++) {

            // 이미 현재 순열에 사용한 숫자라면 다시 사용할 수 없으므로 건너뜀
            if (visited[i]) {
                continue;
            }

            // nums[i]를 현재 순열에 사용했다고 표시
            visited[i] = true;

            // 현재 순열에 nums[i]를 추가
            current.add(nums[i]);

            // 다음 숫자를 선택하기 위해 재귀 호출
            backtrack(nums, visited, current, answer);

            // 재귀 호출이 끝나면 방금 추가한 숫자를 제거
            current.remove(current.size() - 1);

            // nums[i]를 다시 사용할 수 있도록 방문 표시를 해제
            visited[i] = false;
        }
    }
}