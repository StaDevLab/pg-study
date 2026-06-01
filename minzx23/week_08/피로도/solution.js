function solution(k, dungeons) {
    var answer = -1;
    let visited=Array(dungeons.length).fill(false);
    
    function dfs(k, count){
        answer=Math.max(answer, count);
        
        for(let i=0; i<dungeons.length; i++){
            let need=dungeons[i][0];
            let cost=dungeons[i][1];
            
            if(k>=need&& !visited[i]){
                visited[i]=true;
                dfs(k-cost, count+1);
                visited[i]=false;
            }
        }
    }
    
    dfs(k, 0);
    
    return answer;
}