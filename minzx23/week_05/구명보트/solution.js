function solution(people, limit) {
    var answer = 0;
    let start = 0;
    let end = people.length-1;
    
    people.sort((a,b)=>a-b);
    
    while (start<=end){
        let sum=people[start]+people[end];
        if (sum<=limit){
            start++;
            end--;
        }
        else {
            end--;
        }
        answer++;
    }
    
    return answer;
}