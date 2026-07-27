function solution(commands) {
    var answer = [];
    let SIZE=50;
    let parent=Array(SIZE*SIZE).fill(0).map((_, i)=>i);
    let values=Array(SIZE*SIZE).fill(null);
    
    function makeIdx(r, c){
        return (r-1)*SIZE+(c-1);
    }
    
    function find(x){
        if(parent[x]!==x){
            parent[x]=find(parent[x]);
        }
        
        return parent[x];
    }
    
    function union(a, b){
        let ra=find(a);
        let rb=find(b);
        
        if(ra===rb){
            return;
        }
        
        //ra 값이 없으면 rb 사용
        if(values[ra]===null && values[rb]!==null){
            values[ra]=values[rb];
        }
        
        values[rb]=null;
        parent[rb]=ra;
    }
    
    function updateCell(r, c, v){
        values[find(makeIdx(r, c))]=v;
    }
    
    function updateAll(v1, v2){
        for (let i=0; i<values.length; i++){
            if(values[i]===v1){
                values[i]=v2;
            }
        }
    }
    
    function unmerge(r, c){
        let root=find(makeIdx(r, c));
        let val=values[root];
        let group=[];
        
        for (let i=0; i<parent.length; i++){
            if(find(i)===root){
                group.push(i);
            }
        }
        
        for (let g of group){
            parent[g]=g;
            values[g]=null;
        }
        
        values[makeIdx(r, c)]=val;
    }
    
    function print(r, c){
        let v=values[find(makeIdx(r, c))];
        
        return v===null?'EMPTY':v;
    }
    
    for (let cmd of commands){
        let token=cmd.split(' ');
        
        if(token[0]==='UPDATE'){
            if(token.length===4){
                let [_, r, c, v]=token;
                updateCell(+r, +c, v);
            }
            else{
                let [_, v1, v2]=token;
                updateAll(v1, v2);
            }
        }
        else if(token[0]==='MERGE'){
            let [_, r1, c1, r2, c2]=token;
            union(makeIdx(+r1, +c1), makeIdx(+r2, +c2));
        }
        else if(token[0]==='UNMERGE'){
            let [_, r, c]=token;
            unmerge(+r, +c);
        }
        else if(token[0]==='PRINT'){
            let [_, r, c]=token;
            answer.push(print(+r, +c));
        }
    }
    
    return answer;
}