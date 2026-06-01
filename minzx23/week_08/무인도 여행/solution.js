function solution(maps) {
    var answer = [];
    let grid=maps.map(row=>row.split(''));
    let visited=Array.from({length:grid.length}, (_, i)=> Array(grid[i].length).fill(false));
    
    // 섬의 식량 합 구하기
    function dfs(grid, x, y, visited){
        visited[x][y]=true;
        let sum=Number(grid[x][y]);
        
        const direction=[
            [1,0],
            [-1,0],
            [0,1],
            [0,-1]
        ];
        
        for (const [dirX, dirY] of direction){
            const newX=x+dirX;
            const newY=y+dirY;
            
            if(newX>=0&& newX<grid.length&& 
                newY>=0&& newY<grid[0].length&&
                !visited[newX][newY]&& grid[newX][newY]!== 'X'){
                sum+=dfs(grid, newX, newY, visited);
            }
        }
        
        return sum;
    }
    
    // 새로운 섬 찾기
    for (let i=0; i<grid.length; i++){
        for (let j=0; j<grid[i].length; j++){
            if(!visited[i][j]&& grid[i][j]!== 'X'){
                answer.push(dfs(grid, i, j, visited));
            }
        }
    }
    
    return answer.length ? answer.sort((a,b)=> a-b) : [-1];
}