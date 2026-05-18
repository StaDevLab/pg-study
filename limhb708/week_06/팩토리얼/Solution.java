class Solution {
    public int solution(int n) {
        int factorial = 1; // 팩토리얼 값을 저장할 변수 1!부터 계산하기 위해 1로 초기화
        int answer = 1; // 조건을 만족하는 가장 큰 정수 i를 저장할 변수

        for (int i = 1; i <= 10; i++) { // 제한사항상 최대 10!까지만 확인
            factorial *= i; // 현재 i 값을 곱해서 i! 값을 만듬

            if (factorial <= n) { // 계산한 i! 값이 n보다 작거나 같으면 조건을 만족
                answer = i; // 조건을 만족하는 i를 정답으로 갱신
            } else { // i! 값이 n보다 커지면 더 이상 확인할 필요가 없음
                break;
            }
        }

        return answer;
    }
}