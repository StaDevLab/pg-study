class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int nums1P = 0;
        int nums2P = 0;

        while (nums1P < nums1.length && nums2P < nums2.length) {

            if (nums1[nums1P] == nums2[nums2P]) {
                return nums1[nums1P];
            } else if (nums1[nums1P] < nums2[nums2P]) {
                nums1P++;
            } else {
                nums2P++;
            }
        }

        return -1;
    }
}