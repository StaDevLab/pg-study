function solution(n) {
    var answer = 1;
    let num=1;
    
    while(num<=n){
        answer++;
        num*=answer;
    }
    
    return answer-1;
}