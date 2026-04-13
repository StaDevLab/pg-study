class Solution {
    public int solution(int[] array) {

        int[] count = new int[1000]; // 숫자 범위(0~999)의 등장 횟수를 저장할 배열 생성

        for (int num : array) { // 입력 배열의 각 원소를 순회
            count[num]++;       // 해당 숫자의 등장 횟수를 1 증가
        }

        int max = 0;            // 최댓값(최빈도)을 저장할 변수
        int answer = -1;        // 최빈값 숫자를 저장할 변수 (없으면 -1)
        boolean isDuplicate = false; // 최빈값이 여러 개 존재하는지 여부

        for (int i = 0; i < 1000; i++) { // 0~999까지 순회
            if (count[i] > max) {        // 더 큰 빈도수를 발견한 경우
                max = count[i];          // 최댓값 갱신
                answer = i;              // 최빈값 숫자 갱신
                isDuplicate = false;     // 새로운 최댓값이므로 중복 여부 초기화
            } else if (count[i] == max && max != 0) {
                // 현재 빈도수가 최댓값과 같고, 0이 아닌 경우
                isDuplicate = true;      // 최빈값이 중복됨을 표시
            }
        }

        if (isDuplicate) {       // 최빈값이 여러 개라면
            return -1;           // -1 반환
        }

        return answer;
    }
}
