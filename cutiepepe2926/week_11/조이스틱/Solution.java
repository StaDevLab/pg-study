class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        int minMove = length - 1;

        for (int i = 0; i < length; i++) {
            char ch = name.charAt(i);

            answer += Math.min(ch - 'A', 'Z' - ch + 1);

            int next = i + 1;

            while (next < length && name.charAt(next) == 'A') {
                next++;
            }

            minMove = Math.min(minMove, i * 2 + length - next);
            minMove = Math.min(minMove, (length - next) * 2 + i);
        }

        return answer + minMove;
    }
}