class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = sequence[0];

        int answerLeft = 0;
        int answerRight = sequence.length - 1;

        while (right < sequence.length) {
            if (sum == k) {
                if (right - left < answerRight - answerLeft) {
                    answerLeft = left;
                    answerRight = right;
                }

                sum -= sequence[left];
                left++;
            } 
            else if (sum < k) {
                right++;

                if (right < sequence.length) {
                    sum += sequence[right];
                }
            } 
            else {
                sum -= sequence[left];
                left++;
            }
        }

        return new int[]{answerLeft, answerRight};
    }
}