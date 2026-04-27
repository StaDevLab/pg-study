function solution(s) {
    
    let num=s.split(' ').map(Number);
    let max=(Math.max(...num));
    let min=(Math.min(...num));
    
    return `${min} ${max}`;
}