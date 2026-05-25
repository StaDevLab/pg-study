var isPalindrome = function(s) {
    let start=0;
    let end=s.length-1;
    let newS=s.toLowerCase();

    while(start<=end){
        if(!/[a-z0-9]/.test(newS[start])){
            start++;
            continue;
        }
        if(!/[a-z0-9]/.test(newS[end])){
            end--;
            continue;
        }
        if(newS[start] !== newS[end]){
            return false;
        }
        start++;
        end--;
    }

    return true;
};