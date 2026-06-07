function solution(maps) {
    let grid=maps.map(row=>row.split(''));
    
    function bfs(start, target, grid){
        let visited=Array.from({length:grid.length}, ()=> Array(grid[0].length).fill(false));
        let queue=[];
        
        const dx = [-1, 1, 0, 0];
        const dy = [0, 0, -1, 1];
        
        for (let i=0; i<grid.length; i++){
            for (let j=0; j<grid[0].length; j++){
                if(grid[i][j]===start){
                    queue.push([i, j, 0]);
                    visited[i][j]=true;
                }
            }
        }
        
        while (queue.length){
            let [x, y, dist]=queue.shift();
            
            for(let i=0; i<4; i++){
                let nx=x+dx[i];
                let ny=y+dy[i];
                
                if(nx>=0 && ny>=0 && nx<grid.length && ny<grid[0].length && grid[nx][ny]!=='X' && !visited[nx][ny]){
                    if(grid[nx][ny]===target){
                        return dist+1;
                    }
                    visited[nx][ny]=true;
                    queue.push([nx, ny, dist+1]);
                }
            }
        }
        
        return -1;
    }
    
    let distSL=bfs('S', 'L', grid);
    let distLE=bfs('L', 'E', grid);
    
    if(distSL===-1 || distLE===-1){
        return -1;
    }
    
    return distSL+distLE;
}