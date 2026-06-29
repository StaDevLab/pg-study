class Solution {
    public String solution(String number, int k) {

        StringBuilder answer = new StringBuilder();

        int length = number.length() - k;

        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);

            while (k > 0 && answer.length() > 0 && answer.charAt(answer.length() - 1) < current) {
                answer.deleteCharAt(answer.length() - 1);
                k--;
            }

            answer.append(current);
        }

        return answer.substring(0, length);
    }
}