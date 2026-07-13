public class Solution {

    public int solution(int n) {

        // 최소 건전지 사용량을 저장할 변수
        int answer = 0;

        // 현재 위치가 0이 될 때까지 반복
        while (n > 0) {

            // 현재 값이 짝수라면
            if (n % 2 == 0) {

                // 순간이동의 역연산으로 2로 나누기
                // 순간이동은 건전지를 사용하지 않는다.
                n /= 2;

            } else {

                // 현재 값이 홀수라면 1칸 점프가 필요하므로 1 감소
                n--;

                // 점프한 거리만큼 건전지 사용량 1 증가
                answer++;
            }
        }

        // 최소 건전지 사용량 반환
        return answer;
    }
}