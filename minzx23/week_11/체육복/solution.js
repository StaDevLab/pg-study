function solution(n, lost, reserve) {
    var answer = n;
    
    lost.sort((a,b)=> a-b);
    reserve.sort((a,b)=> a-b);
    
    lost=lost.filter(l=> {
        if(reserve.includes(l)){
            reserve.splice(reserve.indexOf(l),1);
            return false;
        }
        return true;
    });
    
    for (let l of lost){
        if(reserve.includes(l-1)){
            reserve.splice(reserve.indexOf(l-1), 1);
        }
        else if(reserve.includes(l+1)){
            reserve.splice(reserve.indexOf(l+1), 1);
        }
        else{
            answer--;
        }
    }
    
    return answer;
}