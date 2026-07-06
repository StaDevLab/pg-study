import java.util.Arrays;

class Solution {

    public int[] solution(int[] numlist, int n) {

        // Comparator를 쓰기 위해 Integer 배열로 변환
        Integer[] arr = new Integer[numlist.length];

        // int 배열 값을 Integer 배열로 복사
        for (int i = 0; i < numlist.length; i++) {
            arr[i] = numlist[i];
        }

        // n과 가까운 순서로 정렬
        Arrays.sort(arr, (a, b) -> {

            // a와 n 사이 거리
            int distanceA = Math.abs(a - n);

            // b와 n 사이 거리
            int distanceB = Math.abs(b - n);

            // 거리가 다르면 가까운 수가 앞
            if (distanceA != distanceB) {
                return distanceA - distanceB;
            }

            // 거리가 같으면 더 큰 수가 앞
            return b - a;
        });

        // 정답 배열
        int[] answer = new int[numlist.length];

        // Integer 배열을 int 배열로 변환
        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i];
        }

        // 정렬 결과 반환
        return answer;
    }
}