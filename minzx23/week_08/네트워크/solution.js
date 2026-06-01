function solution(n, computers) {
    var answer = 0;
    let visited=Array(n).fill(false);
    
    // 한 노드가 포함된 네트워크 찾기
    function dfs(node){
        visited[node]=true;
        
        for (let i=0; i<n; i++){
            if(computers[node][i]===1&& !visited[i]){
                dfs(i);
            }
        }
    }
    
    // 방문 안한 노드 찾기
    for(let i=0; i<n; i++){
        if(!visited[i]){
            dfs(i);
            answer++;
        }
    }
    
    return answer;
}