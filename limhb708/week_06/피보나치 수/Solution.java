class Solution {

    public int solution(int n) {

        return fibonacci(n) % 1234567;
        // n번째 피보나치 수를 구한 뒤 1234567로 나눈 나머지를 반환
    }

    public int fibonacci(int n) {

        if (n == 0) { // 0번째 피보나치 수는 0
            return 0;
        }

        if (n == 1) { // 1번째 피보나치 수는 1
            return 1;
        }

        return (fibonacci(n - 1) + fibonacci(n - 2)) % 1234567;
        // 이전 두 피보나치 수를 재귀적으로 호출하여 더함
    }
}