function solution(tickets) {
    var answer = [];
    let visited=Array(tickets.length).fill(false);
    
    tickets.sort((a,b)=>{
        if(a[0]===b[0]){
            return a[1]<b[1] ? -1 : 1;
        }
        return a[0]<b[0] ? -1 : 1;
    })
    
    function dfs(path, count){
        let end=path[path.length-1];
        
        if(count===tickets.length){
            answer=[...path];
            
            return true;
        }
        
        for (let i=0; i<tickets.length; i++){
            let [from, to]=tickets[i];
            
            if(!visited[i] && from===end){
                visited[i]=true;
                
                if(dfs([...path, to], count+1)){
                    return true;
                }
                
                visited[i]=false;
            }
        }
    }
    
    dfs(['ICN'], 0);
    
    return answer;
}