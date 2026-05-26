class Solution {
    public boolean isPalindrome(String s) {

        // 문자열의 왼쪽 시작 위치를 가리키는 포인터
        int left = 0;

        // 문자열의 오른쪽 끝 위치를 가리키는 포인터
        int right = s.length() - 1;

        // 왼쪽 포인터가 오른쪽 포인터보다 작을 동안 반복
        while (left < right) {

            // left 위치의 문자가 문자 또는 숫자가 아니라면 비교하지 않고 넘어감
            if (!Character.isLetterOrDigit(s.charAt(left))) {

                // 왼쪽 포인터를 한 칸 오른쪽으로 이동
                left++;

                // 아래 비교 로직을 실행하지 않고 다음 반복으로 넘어감
                continue;
            }

            // right 위치의 문자가 문자 또는 숫자가 아니라면 비교하지 않고 넘어감
            if (!Character.isLetterOrDigit(s.charAt(right))) {

                // 오른쪽 포인터를 한 칸 왼쪽으로 이동
                right--;

                // 아래 비교 로직을 실행하지 않고 다음 반복으로 넘어감
                continue;
            }

            // 왼쪽 문자를 소문자로 변환
            char leftChar = Character.toLowerCase(s.charAt(left));

            // 오른쪽 문자를 소문자로 변환
            char rightChar = Character.toLowerCase(s.charAt(right));

            // 두 문자가 다르다면 팰린드롬이 아님
            if (leftChar != rightChar) {

                // 앞뒤 문자가 다르므로 false를 반환
                return false;
            }

            // 두 문자가 같다면 왼쪽 포인터를 한 칸 오른쪽으로 이동
            left++;

            // 두 문자가 같다면 오른쪽 포인터를 한 칸 왼쪽으로 이동
            right--;
        }

        return true;
    }
}