function solution(edges) {
    let node=new Set(edges.flat());
    let nodeList=[...node];
    
    let root=new Map();
    let inNode=new Map();
    let outNode=new Map();
    let inOut=new Map();
    
    for (let v of nodeList){
        root.set(v, v);
        inNode.set(v, 0);
        outNode.set(v, 0);
        inOut.set(v, 0);
    }    
    
    function find(x){
        //자기가 루트가 아니면 부모를 타고 올라가 루트 찾음
        if(root.get(x)!==x){
            root.set(x, find(root.get(x)));
        }
        
        return root.get(x);
    }
    
    function union(a,b){
        let A=find(a);
        let B=find(b);
        
        //a와 b의 루트가 다르면 둘을 연결
        if(A!==B){
            root.set(B, A);
        }
    }
    
    //각 노드에 들어오고 나가는 간선 카운트
    for (let [a, b] of edges){
        inNode.set(b, inNode.get(b)+1);
        outNode.set(a, outNode.get(a)+1);
    }
    
    let start=0;
    
    //들어오는 간선은 없고 나가는 간선만 있다면 새로 생성된 정점
    for (let v of nodeList){
        if(inNode.get(v)===0 && outNode.get(v)>1){
            start=v;
            break;
        }
    }
    
    for (let [a, b] of edges){
        if(a===start || b===start){
            continue;
        }
            
        union(a, b);
        
        //a와 b에 연결된 간선 카운트
        inOut.set(a, inOut.get(a)+1);
        inOut.set(b, inOut.get(b)+1);
    }
    
    let group={};
    
    for (let v of nodeList){
        let findedRoot=find(v);
        
        if(v===start){
            continue;
        }
        
        //찾은 루트가 속한 그룹이 없다면 새로 생성
        if(!group[findedRoot]){
            group[findedRoot]=[];
        }
        //해당 노드를 그룹에 추가
        group[findedRoot].push(v);
    }
    
    let donut=0;
    let stick=0;
    let eight=0;
    
    //그룹별 각 노드에 연결된 간선 수 분포로 유형 카운트
    for (let nodes of Object.values(group)){
        let lines=nodes.map(x=>inOut.get(x));
        
        //모든 노드에 연결된 간선 수가 2이면 도넛
        if(lines.every(l=>l===2)){
            donut++;
        }
        //두 노드는 간선 수 1, 나머지는 2이면 막대
        else if(lines.filter(l=>l===1).length===2
                && lines.filter(l=>l===2).length===nodes.length-2){
            stick++;
        }
        //한 노드는 간선 수 4, 나머지는 2이면 8자
        else if(lines.filter(l=>l===4).length===1
               && lines.filter(l=>l===2).length===nodes.length-1){
            eight++;
        }
        //노드 하나만 있는 경우도 막대로 카운트
        else if(nodes.length===1 && lines[0]===0){
            stick++;
        }
    }
    
    return [start, donut, stick, eight];
}