function solution(n, wires) {
    let answer=Infinity;
    
    function find(x, parent){
        if(parent[x]!==x){
            parent[x]=find(parent[x], parent);
        }
        
        return parent[x];
    }
    
    function union(a, b, parent){
        let A=find(a, parent);
        let B=find(b, parent);
        
        if(A!==B){
            parent[B]=A;
        }
    }
    
    for (let i=0; i<wires.length; i++){
        let parent=Array.from({length:n+1}, (_, idx)=>idx);
        
        for (let j=0; j<wires.length; j++){
            if(i===j){
                continue;
            }
            
            let [a, b]=wires[j];
            union(a, b, parent);
        }
        
        let count=Array(n+1).fill(0);
        
        for (let k=1; k<=n; k++){
            count[find(k, parent)]++;
        }
        
        let groups=count.filter(x=>x>0);
        answer=Math.min(answer, Math.abs(groups[0]-groups[1]));
    }
    
    return answer;
}