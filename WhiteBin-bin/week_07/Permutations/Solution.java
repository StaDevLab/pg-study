import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        backtrack(nums, visited, new ArrayList<>(), answer);

        return answer;
    }

    private void backtrack(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> answer) {
        if (current.size() == nums.length) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            current.add(nums[i]);

            backtrack(nums, visited, current, answer);

            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}