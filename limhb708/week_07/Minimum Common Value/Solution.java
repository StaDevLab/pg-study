class Solution {
    public int getCommon(int[] nums1, int[] nums2) {

        // nums1을 가리키는 포인터
        int i = 0;

        // nums2를 가리키는 포인터
        int j = 0;

        // 두 포인터가 각각 배열 범위를 벗어나기 전까지 반복한다
        while (i < nums1.length && j < nums2.length) {

            // 두 배열의 현재 값이 같다면 공통 값을 찾은 것이다
            if (nums1[i] == nums2[j]) {

                // 배열이 오름차순이므로 처음 찾은 공통 값이 가장 작은 공통 값이다
                return nums1[i];
            }

            // nums1의 현재 값이 더 작다면 nums1의 포인터를 이동한다
            if (nums1[i] < nums2[j]) {

                // 더 작은 값은 앞으로 공통 값이 될 수 없으므로 다음 값으로 넘어간다
                i++;
            }

            // nums2의 현재 값이 더 작다면 nums2의 포인터를 이동한다
            else {

                // 더 작은 값은 앞으로 공통 값이 될 수 없으므로 다음 값으로 넘어간다
                j++;
            }
        }

        // 반복이 끝날 때까지 공통 값을 찾지 못했다면 -1을 반환한다
        return -1;
    }
}