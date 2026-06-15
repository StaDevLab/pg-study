function solution(distance, rocks, n) {
    var answer = 0;
    
    rocks.sort((a,b)=>a-b);
    rocks.push(distance);
    
    let left=1;
    let right=distance;
    
    while(left<=right){
        let mid=Math.floor((left+right)/2);
        let prevRock=0;
        let remove=0;
        
        for (let curRock of rocks){
            if(curRock-prevRock<mid){
                remove++;
            }
            else{
                prevRock=curRock;
            }
        }
        
        if(remove>n){
            right=mid-1;
        }
        else{
            answer=mid;
            left=mid+1;
        }
    }
    
    return answer;
}