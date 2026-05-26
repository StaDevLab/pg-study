class Solution {
    public int[] twoSum(int[] numbers, int target) {

        // 왼쪽 포인터를 배열의 시작 위치로 설정
        int left = 0;

        // 오른쪽 포인터를 배열의 마지막 위치로 설정
        int right = numbers.length - 1;

        // 왼쪽 포인터가 오른쪽 포인터보다 작을 동안 반복
        while (left < right) {

            // 현재 두 포인터가 가리키는 값의 합을 구함
            int sum = numbers[left] + numbers[right];

            // 합이 target과 같다면 정답
            if (sum == target) {

                // 문제는 1-indexed 배열 기준으로 답을 요구하므로 각각 1을 더해서 반환
                return new int[] {left + 1, right + 1};
            }

            // 합이 target보다 작다면 더 큰 합이 필요함
            if (sum < target) {

                // 배열이 오름차순이므로 왼쪽 포인터를 오른쪽으로 이동하면 합이 커질 수 있음
                left++;
            }

            // 합이 target보다 크다면 더 작은 합이 필요
            else {

                // 배열이 오름차순이므로 오른쪽 포인터를 왼쪽으로 이동하면 합이 작아질 수 있음
                right--;
            }
        }

        return new int[] {};
    }
}