function solution(info, edges) {
    var answer = 0;
    let graph=Array.from({length:info.length}, ()=>[])
    let visited=Array(info.length).fill(false);
    
    for (let [parent, child] of edges){
        graph[parent].push(child);
    }
    
    function dfs(sheep, wolf, node, visited){
        answer=Math.max(answer, sheep);
        
        for (let i=0; i<node.length; i++){
            let next=node[i];
            let nextSheep=sheep;
            let nextWolf=wolf;
            
            if(visited[next]){
                continue;
            }
            
            if(info[next]===0){
                nextSheep++;
            }
            else{
                nextWolf++;
            }
            
            if(nextWolf>=nextSheep){
                continue;
            }
            
            visited[next]=true;
            
            let newNode=[...node];
            newNode.splice(i, 1);
            newNode.push(...graph[next]);
            
            dfs(nextSheep, nextWolf, newNode, visited);
            visited[next]=false;
        }
    }
    
    visited[0]=true;
    dfs(1, 0, graph[0], visited);
    
    return answer;
}