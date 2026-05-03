class Solution {
    public int[] solution(int[] sequence, int k) {

        int[] answer = {0, sequence.length - 1};

        int left = 0;
        int sum = 0;

        for (int right = 0; right < sequence.length; right++) {

            sum += sequence[right];

            while (sum > k) {
                sum -= sequence[left++];
            }

            if (sum == k) {
                if (right - left < answer[1] - answer[0]) {
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }

        return answer;
    }
}