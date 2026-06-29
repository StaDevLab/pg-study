class Solution {

    public int solution(String name) {

        // 이름 길이
        int length = name.length();

        // 알파벳 변경 횟수 합
        int answer = 0;

        // 커서를 오른쪽으로만 이동하는 기본 횟수
        int move = length - 1;

        // 각 위치의 알파벳을 확인
        for (int i = 0; i < length; i++) {

            // 현재 문자
            char current = name.charAt(i);

            // A에서 위로 이동하는 횟수
            int up = current - 'A';

            // A에서 아래로 이동하는 횟수
            int down = 'Z' - current + 1;

            // 위와 아래 중 더 적은 조작 횟수 추가
            answer += Math.min(up, down);

            // 현재 위치 다음 인덱스
            int next = i + 1;

            // 연속된 A 구간을 건너뜀
            while (
                    next < length
                            && name.charAt(next) == 'A'
            ) {
                next++;
            }

            // 오른쪽으로 i까지 갔다가 다시 왼쪽으로 돌아가는 경우
            move = Math.min(
                    move,
                    i * 2 + length - next
            );

            // 왼쪽으로 먼저 갔다가 다시 오른쪽으로 돌아오는 경우
            move = Math.min(
                    move,
                    (length - next) * 2 + i
            );
        }

        // 알파벳 변경 횟수 + 커서 이동 횟수
        return answer + move;
    }
}