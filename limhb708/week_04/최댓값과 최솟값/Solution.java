class Solution {

    public String solution(String s) {

        // 공백 기준으로 숫자 문자열 분리
        String[] numbers = s.split(" ");

        // 최솟값 초기화
        int min = Integer.MAX_VALUE;

        // 최댓값 초기화
        int max = Integer.MIN_VALUE;

        // 모든 숫자 확인
        for (String number : numbers) {

            // 문자열을 정수로 변환
            int value = Integer.parseInt(number);

            // 최솟값 갱신
            min = Math.min(min, value);

            // 최댓값 갱신
            max = Math.max(max, value);
        }

        // "최솟값 최댓값" 형태로 반환
        return min + " " + max;
    }
}