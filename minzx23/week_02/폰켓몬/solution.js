function solution(nums) {
    var answer = 0;

    let set = new Set(nums);
    let count=nums.length/2;
    let size=set.size;

    return size>count?count:size;
}