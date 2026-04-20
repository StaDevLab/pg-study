function solution(priorities, location) {
    var answer = 0;
    let idx=location;
    
    while (priorities.length>0){
            if (priorities[0]===Math.max(...priorities)){
                priorities.shift();
                answer+=1;
                
                if (idx===0){
                    break;
                }
                else {
                    idx-=1;
                }
            }
            else {
                let n=priorities.shift();
                priorities.push(n);
                
                if (idx===0){
                    idx=priorities.length-1;
                }
                else {
                    idx-=1;
                }
            }
    }

    
    return answer;
}