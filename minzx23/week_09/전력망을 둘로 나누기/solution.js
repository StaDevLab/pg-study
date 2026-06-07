function solution(n, wires) {
    var answer = n;
    
    function bfs(start, graph){
        let visited=Array(n+1).fill(false);
        let queue=[start];
        visited[start]=true;
        let count=1;
        
        while(queue.length){
            let node=queue.shift();
            
            for(let neighbor of graph[node]){
                if(!visited[neighbor]){
                    visited[neighbor]=true;
                    queue.push(neighbor);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    for(let i=0; i<wires.length; i++){
            let graph=Array.from({length: n+1}, ()=>[]);
            
            for(let j=0; j<wires.length; j++){
                if(i===j){
                    continue;
                }
                let [a, b]=wires[j];
                graph[a].push(b);
                graph[b].push(a);
            }
            
            let [a, b]=wires[i];
            let size=bfs(a, graph);
            let otherSize=n-size;
            let diff=Math.abs(size-(n-size));
            answer=Math.min(answer, diff);
        }
    
    return answer;
}