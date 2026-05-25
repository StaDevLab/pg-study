class Solution {
    public int getCommon(int[] nums1, int[] nums2) {

        int ptr1 = 0;
        int ptr2 = 0;
        int answer = -1;

        boolean found = false;

        for (int i = 0; i < nums1.length; i++) {

            if (!found) {

                for (int j = 0; j < nums2.length; j++) {

                    if (nums1[i] == nums2[j]) {
                        answer = nums2[j];
                        found = true;
                        break;
                    }

                    else if (nums1[i] < nums2[j]) { // 더 찾을 필요 없음
                        break;
                    }

                }

            }
            else {
                break;
            }

        }

        return answer;

    }
}