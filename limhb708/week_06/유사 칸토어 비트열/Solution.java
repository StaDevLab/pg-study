class Solution {

    public int solution(int n, long l, long r) {
        long rightCount = countOne(n, r); // 1번 위치부터 r번 위치까지의 1 개수를 구함
        long leftCount = countOne(n, l - 1); // 1번 위치부터 l - 1번 위치까지의 1 개수를 구함

        return (int) (rightCount - leftCount); // [l, r] 구간의 1 개수만 반환
    }

    private long countOne(int n, long index) {
        if (index <= 0) { // index가 0 이하이면 셀 수 있는 범위가 없음
            return 0; // 1의 개수는 0개
        }

        if (n == 0) { // 0번째 유사 칸토어 비트열은 1
            return 1; // index가 1 이상이면 1개를 반환
        }

        long blockLength = 1; // 한 블록의 길이를 저장할 변수
        long blockOneCount = 1; // 한 블록 안에 들어 있는 1의 개수를 저장할 변수

        for (int i = 0; i < n - 1; i++) { // n - 1번째 비트열의 길이와 1의 개수를 계산
            blockLength *= 5; // 비트열의 길이는 단계마다 5배
            blockOneCount *= 4; // 1의 개수는 단계마다 4배
        }

        long fullBlock = index / blockLength; // index 전까지 완전히 포함되는 블록 개수를 구함
        long remain = index % blockLength; // 마지막에 일부만 포함되는 블록의 길이를 구함

        long count = 0; // 현재까지 센 1의 개수를 저장할 변

        for (int i = 0; i < fullBlock; i++) { // 완전히 포함되는 블록들을 하나씩 확인
            if (i != 2) { // 3번째 블록은 00000으로 바뀌는 구간이므로 제외
                count += blockOneCount; // 1이 있는 블록이면 해당 블록의 1 개수를 더함
            }
        }

        if (fullBlock != 2) { // 일부만 포함되는 블록이 3번째 블록이 아니라면
            count += countOne(n - 1, remain); // 이전 단계 비트열에서 남은 길이만큼 1 개수를 재귀로 구함
        }

        return count; // index 위치까지 존재하는 1의 개수를 반환
    }
}