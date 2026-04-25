function solution(numbers) {
    var answer = [];
    
    for (let i=0; i<numbers.length; i++){
        for (let j=0; j<numbers.length; j++){
            if (i!==j){
                answer.push(numbers[i]+numbers[j]);
            }
            else{
                continue;
            }
        }
    }
    
    answer.sort((a,b)=>(a-b));
    let set= new Set(answer);
    answer=Array.from(set);
    
    return answer;
}