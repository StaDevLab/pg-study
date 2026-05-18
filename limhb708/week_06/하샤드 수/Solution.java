class Solution {
    public boolean solution(int x) {

        int sum = 0; // 각 자릿수의 합을 저장할 변수
        int num = x; // 원래 x 값을 보존하기 위해 복사한 변수

        while (num > 0) { // 숫자가 0보다 클 동안 반복

            sum += num % 10; // 현재 마지막 자릿수를 sum에 더함

            num /= 10; // 마지막 자릿수를 제거
        }

        return x % sum == 0; // 자릿수 합으로 나누어 떨어지면 true 아니면 false
    }
}