var permute = function(nums) {
    let answer=[];

    function recursion(pos){
        if(pos===nums.length){
            answer.push([...nums]);
            return;
        }

        for (let i=pos; i<nums.length; i++){
            [nums[pos], nums[i]]=[nums[i],nums[pos]];
            recursion(pos+1);
            [nums[pos], nums[i]]=[nums[i],nums[pos]];
        }
    }

    recursion(0);
    
    return answer;
};