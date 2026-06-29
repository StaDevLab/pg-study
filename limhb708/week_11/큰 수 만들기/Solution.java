class Solution {

    public String solution(String number, int k) {

        // 최종적으로 남아야 하는 숫자의 길이
        int targetLength = number.length() - k;

        // 숫자를 쌓아둘 스택 역할의 배열
        char[] stack = new char[number.length()];

        // stack의 다음 삽입 위치
        int top = 0;

        // 앞으로 제거할 수 있는 숫자의 개수
        int removeCount = k;

        // number의 숫자를 왼쪽부터 하나씩 확인
        for (int i = 0; i < number.length(); i++) {

            // 현재 숫자
            char current = number.charAt(i);

            // 제거할 수 있고, 이전 숫자가 현재 숫자보다 작으면 제거
            while (
                    removeCount > 0
                            && top > 0
                            && stack[top - 1] < current
            ) {

                // 스택 맨 위 숫자 제거
                top--;

                // 제거 횟수 감소
                removeCount--;
            }

            // 현재 숫자를 스택에 추가
            stack[top] = current;

            // 다음 삽입 위치로 이동
            top++;
        }

        // 앞에서부터 targetLength만큼만 사용해 정답 생성
        return new String(stack, 0, targetLength);
    }
}