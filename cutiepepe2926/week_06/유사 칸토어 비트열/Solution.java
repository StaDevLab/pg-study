class Solution {

    /*
    문제는 일부 풀리나 메모리 초과나 출력초과가 발생한다.
    */
    // 1 1 0 1 1 -> 1, 2, 4, 5만 처리 (0, 1, 3, 4)만 처리
    // 11011 11011 00000 11011 11011 -> 5로 나눠도 1, 2, 4, 5만 처리
    // 5^n을 구하고, 5로 구간 마다 계산하되, 0...24 -> 0...624 / (2, 7, 10, 11, 12, 13, 14,)
    // n 필요없을듯? l, r로만 구할 수 있겠는데
    // 각 구간 인덱스에 대해서 이게 0인지 1인지만 판별 가능?

    public int solution(int n, long l, long r) {

        int answer = 0;

        for (long i = l; i <= r; i++) {
            if (oon(i - 1)) {
                answer++;
            }
        }

        return answer;

    }

    // 나머지가 2면, false 그 외는 true 재귀 호출은? 5단위로 끊으면될듯

    public boolean oon(long x) {

        if (x == 0) return true;

        return (x % 5 == 2) ? false : oon(x / 5);

    }

}