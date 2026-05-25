var getCommon = function (nums1, nums2) {
  let i = 0;
  let j = 0;
  let arr = [];

  while (i < nums1.length && j < nums2.length) {
    if (nums1[i] === nums2[j]) {
      // 공통값 발견
      return nums1[i];
    } else if (nums1[i] < nums2[j]) {
      // nums1 값이 더 작음
      i++;
    } else {
      // nums2 값이 더 작음
      j++;
    }
  }

  return -1;
};
