function solution(name) {
    var answer = 0;
    
    for (let i=0; i<name.length; i++){
        const code=name.charCodeAt(i);
        const forward=code-'A'.charCodeAt(0);
        const backward='Z'.charCodeAt(0)-code+1;
        
        answer+=Math.min(forward, backward);
    }
    
    let moveCount=name.length-1;
    
    for (let i=0; i<name.length; i++){
        let next=i+1;
        
        while (next<name.length && name[next]==='A'){
            next++;
        }
        
        moveCount=Math.min(moveCount, i+2*(name.length-next), i*2+name.length-next);
    }
    
    return answer+moveCount;
}