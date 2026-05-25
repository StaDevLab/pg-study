var getCommon = function(nums1, nums2) {
    let pt1=0;
    let pt2=0;

    while(1){
        if(nums1[pt1]<nums2[pt2]){
            pt1++;
        }
        else if(nums1[pt1]>nums2[pt2]){
            pt2++;
        }
        else if(nums1[pt1]===nums2[pt2]){
            return nums1[pt1];
        }
        else if(pt1===nums1.length || pt2===nums2.length){
            return -1;
        }
    }
};