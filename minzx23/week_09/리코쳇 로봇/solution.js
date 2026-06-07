function solution(board) {  
    let grid=board.map(row=>row.split(''));
    let visited=Array.from({length:grid.length}, ()=> Array(grid[0].length).fill(false));
    let start;
        
    const dx = [-1, 1, 0, 0];
    const dy = [0, 0, -1, 1];
    
    // 시작 부분 (R) 찾기
    for(let i=0; i<grid.length; i++){
        for(let j=0; j<grid[0].length; j++){
            if(grid[i][j]==='R'){
                start=[i, j];
            }
        }
    }
    
    // 시작 부분 큐에 넣고 방문 처리
    let queue=[[...start, 0]];
    visited[start[0]][start[1]]=true;
        
    while(queue.length){
        let [x, y, count]=queue.shift();
        
        if(grid[x][y]==='G'){
            return count;
        }
          
        // 상하좌우 방향으로 쭉 간 후 멈춘 위치 탐색
        for (let i = 0; i < 4; i++){
            let nx = x;
            let ny = y;
                
            while(true){
                const nextX=nx+dx[i];
                const nextY=ny+dy[i];
                
                if(nextX<0 || nextY<0 || nextX>=grid.length || nextY>=grid[0].length){
                    break;
                }
                if(grid[nextX][nextY]==='D'){
                    break;
                }
                
                nx=nextX;
                ny=nextY;
            }
            
            if(!visited[nx][ny]){
                visited[nx][ny]=true;
                queue.push([nx, ny, count+1]);
            }
        }
    }
    
    return -1;
}