function solution(brown, yellow) {
    let total=brown+yellow; //w*h
    let sum=(total-yellow+4)/2; //w+h
    //(w-2)*(h-2)=yellow 전개
        
    for (let h=3; h<=sum; h++){
        let w=sum-h;
        if(w*h===total){
            return [w,h];
        }
    }
}