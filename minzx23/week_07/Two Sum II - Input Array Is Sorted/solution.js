var twoSum = function(numbers, target) {
    let start=0;
    let end=numbers.length-1;
    let arr=[];

    while(start<end){
        if (numbers[start]+numbers[end]<target){
            start++;
        }
        else if (numbers[start]+numbers[end]>target){
            end--;
        }
        else{
            break;
        }
    }

    arr.push(start+1);
    arr.push(end+1);

    return arr;
};