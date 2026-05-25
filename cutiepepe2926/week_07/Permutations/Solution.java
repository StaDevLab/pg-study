class Solution {

    List<List<Integer>> answer = new ArrayList<>(); // 정답용
    List<Integer> temp = new ArrayList<>(); //각 경우의 수를 담을 보관용
    boolean[] visited; // 방문지 체크용

    public List<List<Integer>> permute(int[] nums) {

        visited = new boolean[nums.length];

        dfs(nums, 0);

        return answer;

    }

    public void dfs(int[] nums, int depth) {

        if (depth == nums.length) {
            answer.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (visited[i]) {
                continue;
            }

            visited[i] = true;

            temp.add(nums[i]);

            dfs(nums, depth + 1);

            temp.remove(temp.size() - 1);

            visited[i] = false;
        }

    }
}