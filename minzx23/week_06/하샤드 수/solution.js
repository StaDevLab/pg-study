function solution(x) {
    let str=String(x);
    let num=str.split('').map(Number);
    let sum=0;
    
    for (let i=0; i<num.length; i++){
        sum+=num[i];
    }
    
    return x%sum===0;
}