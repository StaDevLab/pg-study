function solution(number, k) {
    var answer = '';
    const stack=[];
    
    for (let num of number){
        while (k>0 && stack.length>0 && stack[stack.length-1]<num){
            stack.pop();
            k--;
        }
        stack.push(num);
    }
    
    answer=stack.slice(0, number.length-k).join('');
    
    return answer;
}